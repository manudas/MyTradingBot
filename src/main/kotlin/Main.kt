import org.myTradingBot.implementations.bot.MyBotManagerLoader
import org.myTradingBot.implementations.bot.MyTradingBotManager
import org.myTradingBot.intefaces.bot.IBotManager
import org.myTradingBot.intefaces.bot.IMyTradingBotManagerLoader

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val myTradingBotManager: IBotManager = MyTradingBotManager()
    val myIMyTradingBotManagerLoader: IMyTradingBotManagerLoader = MyBotManagerLoader()
    myIMyTradingBotManagerLoader.load(myTradingBotManager)
    myTradingBotManager.loadBots()
    myTradingBotManager.startBots()
}