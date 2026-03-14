package com.johndoe.application

import java.awt.Component

class ComponentStats {
    protected final Component component

    ComponentStats(Component component) {
        this.component = component
    }

    int getSize() {
        return component.width * component.height
    }
}
