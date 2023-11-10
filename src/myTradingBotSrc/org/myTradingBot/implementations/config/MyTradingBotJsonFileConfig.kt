package org.myTradingBot.implementations.config

import org.myTradingBot.intefaces.bot.IMyTradingBot
import org.myTradingBot.intefaces.config.IMyTradingBotConfig

class MyTradingBotJsonFileConfig: IMyTradingBotConfig {
    override val wsAddress: String
        get() = TODO("Not yet implemented")
    override val apiKey: String
        get() = TODO("Not yet implemented")

    override fun loadConfig(bot: IMyTradingBot) {
        TODO("Not yet implemented")
    }

}