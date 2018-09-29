package net.noworks.android.ui.helper

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
object SpekSampleTest : Spek({
 
    describe("SampleCalculatorのテスト") {
        val calculator = SampleCalculatorHelper()
 
        on("足し算") {
            val sum = calculator.sum(2, 4)
            assertEquals(6, sum)
 
            it("2+4が6になるテスト") {
                assertEquals(6, sum)
            }
        }
 
        on("引き算") {
            val subtract = calculator.subtract(4, 2)

            it("hoge"){
                println(subtract)
                assertEquals(15, subtract)

            }

            it("4-2は2になるテスト") {
                println(subtract)
                assertEquals(15, subtract)
            }
        }
    }
 
})