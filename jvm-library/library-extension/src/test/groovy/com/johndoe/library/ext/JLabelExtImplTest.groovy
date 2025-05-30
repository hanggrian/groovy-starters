package com.johndoe.library.ext

import javax.swing.JLabel
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

import static com.google.common.truth.Truth.assertThat
import static org.mockito.Mockito.verify
import static org.mockito.Mockito.when

@ExtendWith(MockitoExtension)
class JLabelExtImplTest {
    @Mock private JLabel label

    @Test
    void test() {
        when label.getX() thenReturn 0
        when label.getY() thenReturn 1
        assertThat new JLabelExtImpl(label).getPosition() isEqualTo '(0,1)'
        verify label getX()
        verify label getY()
    }
}
