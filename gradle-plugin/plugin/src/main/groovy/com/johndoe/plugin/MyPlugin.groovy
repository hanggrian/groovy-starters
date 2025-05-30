package com.johndoe.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class MyPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.getTasks().register('myTask') { task ->
            task.setDescription 'Print a line'
            task.doLast { t ->
                printf '%d characters%n', new ProjectImpl(project).getCount()
            }
        }
    }
}
