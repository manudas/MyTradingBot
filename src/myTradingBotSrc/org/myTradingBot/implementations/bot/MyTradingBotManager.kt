package org.myTradingBot.implementations.bot

import org.myTradingBot.intefaces.bot.IBotManager
import org.myTradingBot.intefaces.bot.IMyTradingBot
import org.myTradingBot.intefaces.bot.IMyTradingBotLoader

class MyTradingBotManager(override val botLoader: IMyTradingBotLoader): IBotManager {
    override var botList: Collection<IMyTradingBot>? = null
    override fun loadBots() {
        botList?.forEach { botLoader.load(it) }
    }

    override fun startBots() {
        botList?.forEach { it.start() }
    }
}