package com.johndoe.library.ext

import com.johndoe.library.ComponentStats
import java.awt.Component

class ExtendedComponentStats extends ComponentStats {
    ExtendedComponentStats(Component component) {
        super(component)
    }

    String getPosition() {
        return "(${component.x},${component.y})"
    }
}
