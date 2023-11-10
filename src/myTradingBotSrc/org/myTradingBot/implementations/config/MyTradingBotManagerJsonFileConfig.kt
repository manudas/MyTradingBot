package org.myTradingBot.implementations.config

import java.io.File
import java.io.FileInputStream
import org.json.JSONObject

import org.myTradingBot.intefaces.bot.IBotManager
import org.myTradingBot.intefaces.config.CONFIG_ATTRIBUTE_FIELDS
import org.myTradingBot.intefaces.config.IMyTradingBotManagerConfig

class MyTradingBotManagerJsonFileConfig: IMyTradingBotManagerConfig {
    private val botManagerConfigFile: String = "config/BotManagerConfig.json"
    override fun loadConfig(botManager: IBotManager) {
        val jsonStream: FileInputStream = File (this.botManagerConfigFile).inputStream()

        // Option B: val inputString = inputStream.reader().use {it.readText()}
        val jsonString = jsonStream.reader().use { t -> t.readText() }

        val jsonObj = JSONObject(jsonString)
        // todo: In future versions we should check a property in this json that will state whether or not we should go to the database to grab the needed data

        val exchangesJsonArr = jsonObj.getJSONArray(CONFIG_ATTRIBUTE_FIELDS.exchanges.value)
        val exchanges = List(exchangesJsonArr.length()) { i -> this.loadExchange(exchangesJsonArr.getString(i))}

        botManager.botList = exchanges
    }
}