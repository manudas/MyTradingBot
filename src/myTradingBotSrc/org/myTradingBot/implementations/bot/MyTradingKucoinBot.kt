package org.myTradingBot.implementations.bot

import org.myTradingBot.intefaces.bot.IMyTradingBot
import org.myTradingBot.intefaces.config.CONFIG_SOURCE

class MyTradingKucoinBot(override val configSource: CONFIG_SOURCE): IMyTradingBot {
    override val name = "Kucoin"
    override fun sell(limit: Float?) {
        TODO("Not yet implemented")
    }

    override fun buy(limit: Float?) {
        TODO("Not yet implemented")
    }
}