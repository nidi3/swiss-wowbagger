/*
 * Copyright © 2018 Stefan Niederhauser (nidin@gmx.ch)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package guru.nidi.wowbagger.telegram

import io.mockk.every
import io.mockk.mockk

import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.bots.AbsSender
import kotlin.test.Test

internal class TelegramMessageHandlerTest {

    @Test
    fun `ignore message without command`() {
        val telegramApiClient = mockk<AbsSender>()

        TelegramMessageHandler(
            telegramApiClient = telegramApiClient,
            botUsername = "adf"
        ).onUpdateReceived(
            TelegramUpdate(
                message = TelegramUpdateMessage(
                    text = "my text",
                    chat = TelegramUpdateChat(4242)
                )
            )
        )
    }

    @Test
    fun `handle command help`() {
        val telegramApiClient = mockk<AbsSender>()
        every { telegramApiClient.execute(SendMessage("4242", HELP_TEXT)) } returns Message()

        TelegramMessageHandler(
            telegramApiClient = telegramApiClient,
            botUsername = "adf"
        ).onUpdateReceived(
            TelegramUpdate(
                message = TelegramUpdateMessage(
                    text = "/help",
                    chat = TelegramUpdateChat(4242)
                )
            )
        )
    }
}