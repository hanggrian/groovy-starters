package com.johndoe.library.ext

import org.junit.Test

import static com.google.common.truth.Truth.assertThat

class ViewsTest {
    @Test
    void test() {
        assertThat(Views.create()).isNotNull()
    }
}
