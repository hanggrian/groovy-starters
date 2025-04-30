package com.johndoe.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class MyPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.getTasks().register('myTask').configure { task ->
            task.setDescription('Print a line')
            task.doLast { System.out.println('line') }
        }
    }
}
