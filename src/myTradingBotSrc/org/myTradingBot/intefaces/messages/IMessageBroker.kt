package org.myTradingBot.intefaces.messages

interface IMessageBroker {
    val endpoint: String
    val apiKey: String

    /**
     * Some sync/async implementations of sendMessage
     * may return the value for this API endpoint call
     * directly as a return value from this function
     */
    fun sendMessage(message: Any): Any?

/*
    var name: String by Delegates.observable("<not set>") {
            prop, old, new -> println("Old value: $old, New value: $new")
    }
*/
    
}

enum class CONNECTION_TYPE {
    WEB_SOCKETS,
    HTTP_POOLING
}