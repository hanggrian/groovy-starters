package com.johndoe.application

import dagger.Module
import dagger.Provides
import java.awt.Component

@Module
class FrameModule {
    @Provides
    ComponentStats provideStats(@Stats Component component) {
        return new ComponentStats(component)
    }

    @Provides
    @Stats
    Component provideView(MainFrame frame) {
        return frame.getComponent(0)
    }
}
