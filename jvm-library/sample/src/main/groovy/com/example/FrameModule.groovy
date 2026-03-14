package com.example

import com.johndoe.library.ext.ExtendedComponentStats
import dagger.Module
import dagger.Provides
import java.awt.Component

@Module
class FrameModule {
    @Provides
    ExtendedComponentStats provideStats(@Stats Component component) {
        return new ExtendedComponentStats(component)
    }

    @Provides
    @Stats
    Component provideView(MainFrame frame) {
        return frame.getComponent(0)
    }
}
