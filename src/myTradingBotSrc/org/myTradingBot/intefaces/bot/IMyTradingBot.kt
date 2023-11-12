package org.myTradingBot.intefaces.bot

import org.myTradingBot.intefaces.config.CONFIG_SOURCE
import org.myTradingBot.intefaces.config.IMyTradingBotConfig

interface IMyTradingBot {
    val configSource: CONFIG_SOURCE
    var config: IMyTradingBotConfig
    val name: String

    /**
     * Some bot implementations (ie: WebSocket Bots)
     * may require to connect or setup before sending
     * messages to the trading platform / exchange
     */
    fun start()
    fun sell(limit: Float? = null)
    fun buy(limit: Float? = null)
}