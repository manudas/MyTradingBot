package org.myTradingBot.implementations.bot

import org.myTradingBot.intefaces.bot.IBotManager
import org.myTradingBot.intefaces.bot.IMyTradingBot
import org.myTradingBot.intefaces.config.CONFIG_SOURCE

class MyTradingBotManager: IBotManager {
    override var botList: Collection<IMyTradingBot>? = null
}