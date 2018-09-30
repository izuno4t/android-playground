package net.noworks.android.ui.helper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith


@RunWith(Enclosed::class)
class JunitSampleTest {
 
    class 加算 {
        lateinit var calculator: SampleCalculatorHelper
        @Before
        fun setup() {
            calculator = SampleCalculatorHelper()
        }
        @Test
        fun `2足す4が6になるテストになるテスト`() {
            assertEquals(6, calculator.sum(2, 4))
        }
    }
 
    class 減算 {
        lateinit var calculator: SampleCalculatorHelper
        @Before
        fun setup() {
            calculator = SampleCalculatorHelper()
        }
        @Test
        fun `4引く2が2になるテストになるテスト`() {
            assertEquals(2, calculator.subtract(4, 2))
        }
    }
}