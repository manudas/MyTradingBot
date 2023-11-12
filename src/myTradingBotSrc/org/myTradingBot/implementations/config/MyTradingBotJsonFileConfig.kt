package org.myTradingBot.implementations.config

import org.json.JSONObject
import org.myTradingBot.intefaces.bot.IMyTradingBot
import org.myTradingBot.intefaces.config.IMyTradingBotConfig
import java.io.File
import java.io.FileInputStream

class MyTradingBotJsonFileConfig: IMyTradingBotConfig {

    override lateinit var wsAddress: String
    override lateinit var apiKey: String

    override fun loadConfig(bot: IMyTradingBot) {
        val botConfigFile: String = "config/${bot.name}Config.json"
        val jsonStream: FileInputStream = File (botConfigFile).inputStream()
        val inputString = jsonStream.reader().use { it.readText() }
        val jsonObj = JSONObject(inputString)
        val apiKey = jsonObj.get("apiKey")
        val wsAddress = jsonObj.get("wsAddress")
        this.apiKey = apiKey as String
        this.wsAddress = wsAddress as String

        bot.config = this
    }

}