# Groovy Starters

![](https://github.com/hanggrian/groovy-starters/raw/assets/logo.png)

Common Gradle project templates with emphasis on **Groovy,** separated by target
platform and kind of distribution.

| | Plugins | Testing | Publishing | Website | Coverage | Max Heap Size
--- | :---: | :---: | :---: | :---: | :---: | :---:
gradle-plugin | [Groovy] | [JUnit 4] | [Plugin Portal] | [Groovydoc], [Minimal] | &cross; | 2GB
jvm-app | [Groovy], [Application] | [JUnit 5] | &cross; | [Cayman] | &check; | 2GB
jvm-library | [Groovy] | [JUnit 5] | [Maven Central] | [Groovydoc], [Minimal] | &check; | 2GB

## Frameworks

- JUnit testing framework with [Mockito](https://site.mockito.org/) suite and
  [Truth](https://truth.dev/) asserter.
- [CodeNarc](https://codenarc.org/) code linter with third-party ruleset
  [Rulebook](https://github.com/hendraanggrian/rulebook/).
- [JaCoCo](https://docs.gradle.org/current/userguide/jacoco_plugin.html) code
  coverage.

## Project layout

- GitHub project layout:
  - GitHub [README](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-readmes/),
    [LICENSE](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/licensing-a-repository/),
    and [gitignore](https://docs.github.com/en/get-started/getting-started-with-git/ignoring-files/)
    file.
  - [EditorConfig](https://editorconfig.org/) enforces IDE settings.
  - [CircleCI](https://circleci.com/) to run test every commit, also triggers
    [Codecov](https://about.codecov.io/) integration within CircleCI.
- Gradle build tool:
  - [Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
    scripts with properties delegation.
  - Apply plugin using [plugins DSL](https://docs.gradle.org/current/userguide/plugins.html).
  - [Version catalogs](https://docs.gradle.org/current/userguide/platforms.html)
    in TOML file to avoid typing unsafe dependencies.
- Website module:
  - [Pages Gradle Plugin](https://github.com/hendraanggrian/pages-gradle-plugin/)
    for generating webpage displaying README's content and documentation links.
  - [gradle-git-publish](https://github.com/ajoberstar/gradle-git-publish/)
    plugin, necessary for uploading to [GitHub Pages](https://pages.github.com/).

[Groovy]: https://docs.gradle.org/current/userguide/groovy_plugin.html
[Application]: https://docs.gradle.org/current/userguide/application_plugin.html
[JUnit 4]: https://junit.org/junit4/
[JUnit 5]: https://junit.org/junit5/
[Plugin Portal]: https://plugins.gradle.org/
[Maven Central]: https://central.sonatype.com/
[Groovydoc]: https://docs.gradle.org/current/dsl/org.gradle.api.tasks.javadoc.Groovydoc.html
[Cayman]: https://hanggrian.github.io/cayman-dark-theme/
[Minimal]: https://hanggrian.github.io/minimal-dark-theme/
