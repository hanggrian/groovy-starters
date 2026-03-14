package com.johndoe.application

import static com.google.common.truth.Truth.assertThat
import static org.mockito.Mockito.verify
import static org.mockito.Mockito.when

import java.awt.Component
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension)
class ComponentStatsTest {
    @Mock private Component component

    @Test
    void test() {
        when(component.width).thenReturn(2)
        when(component.height).thenReturn(4)
        assertThat(new ComponentStats(component).size).isEqualTo(8)
        verify(component).width
        verify(component).height
    }
}
