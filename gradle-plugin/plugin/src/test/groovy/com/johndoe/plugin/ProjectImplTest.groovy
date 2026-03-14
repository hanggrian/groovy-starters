package com.johndoe.plugin

import static com.google.common.truth.Truth.assertThat
import static org.mockito.Mockito.verify
import static org.mockito.Mockito.when

import org.gradle.api.Project
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner)
class ProjectImplTest {
    @Mock private Project project

    @Test
    void test() {
        when(project.getName()).thenReturn('Hello World')
        assertThat(new ProjectImpl(project).getCount()).isEqualTo(11)
        verify(project) getName()
    }
}
