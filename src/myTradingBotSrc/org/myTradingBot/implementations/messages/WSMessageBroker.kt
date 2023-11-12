package org.myTradingBot.implementations.messages

import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import org.json.JSONObject
import org.myTradingBot.intefaces.messages.IMessageBroker
import java.net.URI


class WSMessageBroker(override val endpoint: String, override val apiKey: String): IMessageBroker, WebSocketClient(URI.create(endpoint)) {
    private var isOpen: Boolean = false
    private val subscribers: List<(message: Map<String, Any>) -> Unit> = mutableListOf()
    override fun sendMessage(message: Any) {
        val jsonObject = JSONObject(message)
        val myJson: String = jsonObject.toString()
        this.send(myJson)
    }
    fun subscribe(callback: (message: Map<String, Any>) -> Unit) {
        subscribers.addLast(callback)
    }

    /**
     * Called after an opening handshake has been performed and the given websocket is ready to be
     * written on.
     *
     * @param handshakedata The handshake of the websocket instance
     */
    override fun onOpen(handshakedata: ServerHandshake?) {
        // TODO("Not yet implemented")
        isOpen = true
    }

    /**
     * Callback for string messages received from the remote host
     *
     * @param message The UTF-8 decoded message that was received.
     * @see .onMessage
     */
    override fun onMessage(message: String?) {
        // TODO("Not yet implemented")
        val json = JSONObject(message)
        subscribers.forEach { it(json.toMap()) }
    }

    /**
     * Called after the websocket connection has been closed.
     *
     * @param code   The codes can be looked up here: [CloseFrame]
     * @param reason Additional information string
     * @param remote Returns whether or not the closing of the connection was initiated by the remote
     * host.
     */
    override fun onClose(code: Int, reason: String?, remote: Boolean) {
        // TODO("Not yet implemented")
        isOpen = false
    }

    /**
     * Called when errors occurs. If an error causes the websocket connection to fail [ ][.onClose] will be called additionally.<br></br> This method will be called
     * primarily because of IO or protocol errors.<br></br> If the given exception is an RuntimeException
     * that probably means that you encountered a bug.<br></br>
     *
     * @param ex The exception causing this error
     */
    override fun onError(ex: Exception?) {
        // TODO("Not yet implemented")
        print("ERROR on ${this.javaClass.name}:: $ex")
    }
}