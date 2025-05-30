package com.johndoe.library

import javax.swing.JLabel
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

import static com.google.common.truth.Truth.assertThat
import static org.mockito.Mockito.verify
import static org.mockito.Mockito.when

@ExtendWith(MockitoExtension)
class JLabelImplTest {
    @Mock private JLabel label

    @Test
    void test() {
        when label.getWidth() thenReturn 2
        when label.getHeight() thenReturn 4
        assertThat new JLabelImpl(label).getSize() isEqualTo 8
        verify label getWidth()
        verify label getHeight()
    }
}
