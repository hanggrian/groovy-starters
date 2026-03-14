package com.example

import com.johndoe.library.ext.ExtendedComponentStats
import java.awt.Component
import javax.inject.Inject
import javax.inject.Provider
import javax.swing.JFrame

@SuppressWarnings('NonSerializableFieldInSerializableClass')
class MainFrame extends JFrame {
    @Inject Provider<ExtendedComponentStats> statsProvider

    private ExtendedComponentStats stats

    MainFrame(Component child) {
        add(child)
        setSize(400, 300)
        layout = null
        setVisible(true)
    }

    ExtendedComponentStats getStats() {
        if (stats == null) {
            stats = statsProvider.get()
        }
        return stats
    }
}
