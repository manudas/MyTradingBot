package org.myTradingBot.intefaces.bot

import org.myTradingBot.intefaces.config.CONFIG_SOURCE

interface IMyTradingBotManagerLoader {
    val configSource: CONFIG_SOURCE
    fun load(botManager: IBotManager)
}