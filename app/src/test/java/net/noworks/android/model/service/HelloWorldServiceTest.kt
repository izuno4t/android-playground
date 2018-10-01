package net.noworks.android.ui.helper

import net.noworks.android.model.service.HelloWorldService
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object HelloWorldServiceTest : Spek({

    describe("HelloWorldServiceのテスト") {
        val service = HelloWorldService()

        describe("挨拶") {
            val message = service.greeting()

            it("英語のテスト") {
                assertEquals("Hello World.", message)
            }
        }

    }

})