package com.example.sa4

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class DoubleTapTest {
    @Test
    fun testDoubleTapDetection() {
        var lastTapTime = 0L
        var isDoubleTap = false

        // First tap
        val firstTapTime = System.currentTimeMillis()
        lastTapTime = firstTapTime
        isDoubleTap = false

        // Second tap within 300ms
        val secondTapTime = firstTapTime + 200 // 200ms later
        isDoubleTap = secondTapTime - lastTapTime < 300
        assertTrue(isDoubleTap)

        // Second tap after 300ms
        val lateTapTime = firstTapTime + 400 // 400ms later
        isDoubleTap = lateTapTime - lastTapTime < 300
        assertFalse(isDoubleTap)
    }
} 