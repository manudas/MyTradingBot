package org.myTradingBot.intefaces.config

import org.myTradingBot.intefaces.bot.IMyTradingBot

interface IMyTradingBotConfig {
    val wsAddress: String
    val apiKey: String

    fun loadConfig(bot: IMyTradingBot)
}
