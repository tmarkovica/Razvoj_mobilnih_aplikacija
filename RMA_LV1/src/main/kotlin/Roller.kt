class Roller {
    private val identifiers: String = "asdfgh"
    private val idArr: CharArray =  identifiers.toCharArray()

    private val rollingDices: List<IRollable>  = listOf(
        RollingDice(idArr[0]),
        RollingDice(idArr[1]),
        RollingDice(idArr[2]),
        RollingDice(idArr[3]),
        RollingDice(idArr[4]),
        RollingDice(idArr[5]))

    fun rollAll() {
        for (dice in rollingDices) {
            dice.roll()
        }
    }

    fun rollAt(command: String) {
        for (i in (1..command.length)){
            val index = identifiers.indexOf(command[i-1])
            if (index != -1)
                rollingDices[index].roll()
            else
                println("Incorrect input character '${command[i - 1]}'!")
        }
    }

    fun getRolledValuesWithId(): String {
        var valuesStr = ""
        for (dice in rollingDices)
            valuesStr += dice.getRollValueWithId()
        return valuesStr
    }

    fun getRolledValues(): List<Int> {
        val temp = mutableListOf<Int>()
        for (dice in rollingDices)
            temp.add(dice.getRollValue())
        return temp
    }
}