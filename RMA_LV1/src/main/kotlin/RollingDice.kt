class RollingDice(c: Char, sides: Int = 6) : IRollable {
    private var rolledValue: Int = 2
    private val id : Char
    private val numberOfSides: Int

    init {
        id = c
        numberOfSides = sides
    }

    override fun roll() {
        rolledValue = (1..numberOfSides).random()
        println("Dice '$id' rolled $rolledValue")
    }

    override fun getRollValueWithId(): String {
        return id.toString() + ": " + RollValueColor.blue + " " + rolledValue + " " + RollValueColor.reset + "     "
    }

    override fun getRollValue(): Int {
        return rolledValue
    }

    override fun toString(): String {
        return when (rolledValue) {
            1 -> {  " _______\n" +
                    "|       |\n" +
                    "|   *   |\n" +
                    "|       |\n" +
                    "|_______|\n"
            }
            2 -> {  " _______\n" +
                    "|       |\n" +
                    "|    *  |\n" +
                    "|  *    |\n" +
                    "|_______|\n"
            }
            3 -> {  " _______\n" +
                    "|     * |\n" +
                    "|    *  |\n" +
                    "|  *    |\n" +
                    "|_______|\n"
            }
            4 -> {  " _______\n" +
                    "|       |\n" +
                    "|  *  * |\n" +
                    "|  *  * |\n" +
                    "|_______|\n"
            }
            5 -> {
                    " _______\n" +
                    "|  *  * |\n" +
                    "|   *   |\n" +
                    "|  *  * |\n" +
                    "|_______|\n"
            }
            else -> {  " _______\n" +
                    "|  *  * |\n" +
                    "|  *  * |\n" +
                    "|  *  * |\n" +
                    "|_______|\n"
            }
        }
    }

    companion object RollValueColor {
        // Everything after this is in red
        const val blue = "\u001B[34m"
        // Resets previous color codes
        const val reset = "\u001b[0m"
    }
}