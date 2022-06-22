class JambGame{

    private val resultChecker = ResultCheck()
    private val roller = Roller()

    private var rollsAvailable = 3

    fun startGame() {
        println("Type 'r' to roll all dices and start the game round.")
        println("In first roll of the round you need to roll all dices. You can then re-roll 2 more times any number of dices.")
        println("Type letter in front of the dice you want to roll again, type them in one row with or without spaces.")
        println("If you want to keep current roll type 'q'.")

        test()

        for (i in generateSequence(0) { it }) {
            println("-----------------------------------------------------------------------------------------------------------------")
            println("----------------------------------------------------------------------------------------------------------------- Round starts")
            startRound()
            println("Type 'quit' to stop playing, or type any character to continue playing!")
            val command = readLine()
            if (command.equals("quit"))
                break
            rollsAvailable = 3
        }
    }

    private fun processCommand(command: String): Boolean {
        when(command) {
            "r" -> roller.rollAll()
            "q" -> return false
            else -> {
                roller.rollAt(command)
            }
        }
        return true
    }

    private fun startRound() {
        var command: String?// = "" //readLine()

        do {
            println("Rolls available $rollsAvailable")
            command = readLine()
        } while(command != "r")
        processCommand(command)
        rollsAvailable--
        println("------------------------------")
        println(roller.getRolledValuesWithId())

        do {
            println("Rolls available $rollsAvailable")
            println("Type command...")
            command = readLine()
            if (command?.let { processCommand(it) } == true) rollsAvailable--
            else break
            println("------------------------------")
            println(roller.getRolledValuesWithId())
        }while (rollsAvailable > 0)

        val score = resultChecker.getScore(roller.getRolledValues())
        println("Score: $score")
    }

    private fun test() {
        val jamb = listOf(1,1,1,1,1,2)
        println(resultChecker.getScore(jamb))

        val full = listOf(1,1,1,3,2,2)
        println(resultChecker.getScore(full))

        val scale = listOf(1,2,3,4,5,2)
        println(resultChecker.getScore(scale))

        val scale2 = listOf(6,2,3,4,5,2)
        println(resultChecker.getScore(scale2))
    }
}