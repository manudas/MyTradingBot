package org.myTradingBot.intefaces.bot

interface IMyTradingBot {
    val name: String
    fun sell(limit: Float? = null)
    fun buy(limit: Float? = null)
}