package com.johndoe.plugin

import org.gradle.api.Project

class ProjectImpl {
    protected final Project project

    ProjectImpl(Project project) {
        this.project = project
    }

    int getCount() {
        return project.getName().length()
    }
}
