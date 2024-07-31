# Groovy Starters

![The repository logo.](https://github.com/hendraanggrian/groovy-starters/raw/assets/logo.png)

Personal Gradle project templates with emphasis on **Groovy**, separated by
target platform and kind of distribution.

| | Plugins | Publication
--- | :---: | :---:
jvm-app | [Application] | &cross;
jvm-library | &cross; | [Maven Central]

## Groovy Frameworks

- [CodeNarc](https://codenarc.org/) code linter with third-party ruleset
  [Rulebook](https://github.com/hendraanggrian/rulebook/).
- [JaCoCo](https://docs.gradle.org/current/userguide/jacoco_plugin.html) code
  coverage.

## Project Layout

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
    for generating webpage displaying README's content and documentation links
    (except for apps).
  - [gradle-git-publish](https://github.com/ajoberstar/gradle-git-publish/)
    plugin, necessary for uploading to [GitHub Pages](https://pages.github.com/).

[Application]: https://docs.gradle.org/current/userguide/application_plugin.html
[Maven Central]: https://search.maven.org/
