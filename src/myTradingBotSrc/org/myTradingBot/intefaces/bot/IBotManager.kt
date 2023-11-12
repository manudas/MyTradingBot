package org.myTradingBot.intefaces.bot

interface IBotManager {
    val botLoader: IMyTradingBotLoader
    var botList: Collection<IMyTradingBot>?

    fun loadBots()
    fun startBots()
}