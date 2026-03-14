package com.johndoe.application

import java.awt.Component
import javax.inject.Inject
import javax.inject.Provider
import javax.swing.JFrame

class MainFrame extends JFrame {
    @Inject Provider<ComponentStats> statsProvider

    private ComponentStats stats

    MainFrame(Component child) {
        add(child)
        setSize(400, 300)
        layout = null
        setVisible(true)
    }

    ComponentStats getStats() {
        if (stats == null) {
            stats = statsProvider.get()
        }
        return stats
    }
}
