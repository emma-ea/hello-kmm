package com.emma_ea.hellokmm

import kotlin.test.Test
import kotlin.test.assertTrue

class NewYearTest {

    @Test
    fun `does daysUntilNewYear return a value greater than 0`() {
        assertTrue(daysUntilNewYear() > 0, "results should be more than 0")
    }

}