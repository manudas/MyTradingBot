package org.myTradingBot.implementations.bot

import org.myTradingBot.implementations.config.MyTradingBotJsonFileConfig
import org.myTradingBot.intefaces.bot.IMyTradingBot
import org.myTradingBot.intefaces.bot.IMyTradingBotLoader
import org.myTradingBot.intefaces.config.CONFIG_SOURCE

class MyTradingBotLoader: IMyTradingBotLoader {
    override fun load(bot: IMyTradingBot) {
        when (bot.configSource) {
            CONFIG_SOURCE.JSON_FILE -> {
                val jsonLoader = MyTradingBotJsonFileConfig()
                jsonLoader.loadConfig(bot)
            }
            else -> {
                TODO("Other methods to load the Bot Config are not yet implemented")
            }
        }
    }
}