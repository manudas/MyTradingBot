package org.myTradingBot.intefaces.config

import org.myTradingBot.intefaces.bot.IBotManager
import org.myTradingBot.intefaces.bot.IMyTradingBot
import java.util.*

interface IMyTradingBotManagerConfig {
    fun loadConfig(botManager: IBotManager)
    fun loadExchange(exchangeName: String, configSource: CONFIG_SOURCE): IMyTradingBot {
        val cl = this.javaClass.classLoader
        return cl.loadClass("org.myTradingBot.implementations.bot.MyTrading${exchangeName.lowercase()
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }}Bot")
            .getDeclaredConstructor()
            .newInstance(configSource) as IMyTradingBot
    }
}

enum class CONFIG_ATTRIBUTE_FIELDS(val value: String) {
    exchanges("exchanges")
}

enum class CONFIG_SOURCE {
    JSON_FILE,
    DATABASE,
}