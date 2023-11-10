package org.myTradingBot.implementations.bot

import org.myTradingBot.implementations.config.MyTradingBotManagerJsonFileConfig
import org.myTradingBot.intefaces.bot.IBotManager
import org.myTradingBot.intefaces.bot.IMyTradingBotManagerLoader
import org.myTradingBot.intefaces.config.CONFIG_SOURCE

class MyBotManagerLoader(override val configSource: CONFIG_SOURCE = CONFIG_SOURCE.JSON_FILE) : IMyTradingBotManagerLoader {
    override fun load(botManager: IBotManager) {
        when (this.configSource) {
            CONFIG_SOURCE.JSON_FILE -> {
                val jsonLoader = MyTradingBotManagerJsonFileConfig()
                jsonLoader.loadConfig(botManager)
            }
            else -> {
                TODO("Other methods to load the Bot Manager are not yet implemented")
            }
        }
    }
}