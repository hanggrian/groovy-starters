package com.johndoe.app

import org.junit.Test

import static com.google.common.truth.Truth.assertThat

class ViewTest {
    @Test
    void test() {
        assertThat(new View().getText()).isEqualTo('Hello World')
    }
}
