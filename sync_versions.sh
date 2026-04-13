#!/bin/bash

RED="$(tput setaf 1)" && readonly RED
GREEN="$(tput setaf 2)" && readonly GREEN
YELLOW="$(tput setaf 3)" && readonly YELLOW
END="$(tput sgr0)" && readonly END

warn() { echo "$YELLOW$*$END"; } >&2
die() { echo; echo "$RED$*$END"; echo; exit 1; } >&2

SOURCE_ROOT="$(cd "$(dirname "$0")" && pwd)" && readonly SOURCE_ROOT
declare -a PROJECTS=(
  "$(cd "$SOURCE_ROOT/gradle-plugin" && pwd)"
  "$(cd "$SOURCE_ROOT/jvm-application" && pwd)"
  "$(cd "$SOURCE_ROOT/jvm-library" && pwd)"
) && readonly PROJECTS

GRADLE_WRAPPER_FILE='gradle/wrapper/gradle-wrapper.properties' && \
  readonly GRADLE_WRAPPER_FILE
LIBS_FILE='gradle/libs.versions.toml' && readonly LIBS_FILE

update_gradle_wrapper() {
  perl -i -pe "s|^$1=.*$|$1=$2|" "$GRADLE_WRAPPER_FILE"
}
update_libs() {
  perl -i -pe "s|^$1 = \".*\"|$1 = \"$2\"|" "$LIBS_FILE"
}

for project in "${PROJECTS[@]}"; do
  warn "Syncing $project..."

  echo '(1/4) Generating Gradle wrapper'
  cd "$project" || exit 1
  update_gradle_wrapper \
    'distributionUrl' \
    'https\\\://services.gradle.org/distributions/gradle-9.4.1-bin.zip'
  ./gradlew -q wrapper

  echo '(2/4) Updating base'
  update_libs 'java-compile' '21'
  update_libs 'java-support' '8'
  update_libs 'groovy' '4.0.30'
  update_libs 'codenarc' '3.7.0-groovy-4.0'
  update_libs 'git-publish' 'org.ajoberstar.git-publish:6.0.0'
  update_libs 'pages' 'com.hanggrian.pages:0.3'
  update_libs \
    'rulebook-codenarc' \
    'com.hanggrian.rulebook:rulebook-codenarc:0.2'
  update_libs 'truth' 'com.google.truth:truth:1.4.5'

  mockito_version='5.23.0'
  dagger_version='2.59.2'

  if [[ "$project" == *'jvm-'* ]]; then
    echo '(3/4) Updating JVM'
    update_libs 'dagger' "$dagger_version"
    update_libs 'junit' '5.14.3'
    update_libs \
      'junit-platform-launcher' \
      'org.junit.platform:junit-platform-launcher:1.14.3'
    update_libs \
      'mockito-junit-jupiter' \
      "org.mockito:mockito-junit-jupiter:$mockito_version"
  else
    echo '(3/4) Updating Gradle Publish'
    update_libs 'gradle-publish' 'com.gradle.plugin-publish:2.1.1'
    update_libs 'junit' 'junit:junit:4.13.2'
    update_libs 'mockito-core' "org.mockito:mockito-core:$mockito_version"
  fi

  if [[ "$project" == *'-library' ]]; then
    echo '(4/4) Updating Maven Publish'
    update_libs 'maven-publish' 'com.vanniktech.maven.publish.base:0.36.0'
  else
    echo '(4/4) Skip Maven Publish'
  fi
done

echo "${GREEN}Sync complete.$END"
