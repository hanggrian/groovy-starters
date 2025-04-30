package com.johndoe.library

import org.junit.jupiter.api.Test

import static com.google.common.truth.Truth.assertThat

class ViewTest {
    @Test
    void test() {
        assertThat(new View().getText()).isEqualTo('Hello World')
    }
}
