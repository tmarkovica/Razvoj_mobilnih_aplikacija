class ResultCheck {

    private fun containsTwoOfTheSame(arr: List<Int>): Int {
        var counter: Int
        for (i in (0..arr.size/2+1)) {
            counter = 0
            for (j in (i until arr.size)) {
                if (arr[j] == arr[i]) counter++
            }
            if (counter == 2) return arr[i]
        }
        return 0
    }

    private fun containsThreeOfTheSame(arr: List<Int>): Int {
        var counter: Int
        for (i in (0..arr.size/2+1)) {
            counter = 0
            for (j in (i until arr.size)) {
                if (arr[j] == arr[i]) counter++
            }
            if (counter == 3) return arr[i]
        }
        return 0
    }

    private fun checkForTris(arr: List<Int>): Boolean {
        return containsThreeOfTheSame(arr) != 0
    }

    private fun checkForPoker(arr: List<Int>): Boolean {
        var counter: Int
        for (i in (0..arr.size/2)) {
            counter = 0
            for (j in (i until arr.size)) {
                if (arr[j] == arr[i]) counter++
            }
            if (counter == 4) return true
        }
        return false
    }

    private fun checkForJamb(arr: List<Int>): Boolean {
        var counter: Int
        val upperBound = arr.size/2 -1
        for (i in (0..upperBound)) {
            counter = 0
            for (j in (i until arr.size)) {
                if (arr[j] == arr[i]) counter++
            }
            if (counter == 5) return true
        }
        return false
    }

    private fun checkForFullHouse(arr: List<Int>): Boolean {
        val triss = containsThreeOfTheSame(arr)
        if (triss == 0) return false
        val arrWithoutTriss = mutableListOf<Int>()
        for (i in arr) {
            if (i != triss)
                arrWithoutTriss.add(i)
        }
        return containsTwoOfTheSame(arrWithoutTriss) != 0
    }

    private fun incrementCheck(arr: List<Int>, value: Int, counter: Int): Boolean {
        if (counter == 5) return true

        if (arr.contains(value))
            return incrementCheck(arr, value+1, counter+1)
        else
            return false
    }

    private fun decrementCheck(arr: List<Int>, value: Int, counter: Int): Boolean {
        if (counter == 5) return true

        if (arr.contains(value))
            return incrementCheck(arr, value-1, counter+1)
        else
            return false
    }

    private fun checkForScale(arr: List<Int>): Boolean {
        val min = arr.minOrNull() ?: 0
        val max = arr.maxOrNull() ?: 0

        if (decrementCheck(arr, max, 0))
            return true
        else return incrementCheck(arr, min, 0)
    }

    fun getScore(arr: List<Int>): String {
        if (checkForJamb(arr))
            return "Jamb"
        if (checkForScale(arr))
            return "Scale"
        if (checkForPoker(arr))
            return "Poker"
        if (checkForFullHouse(arr))
            return "Full House"
        if (checkForTris(arr))
            return "Triss"

        return "Nothing to score"
    }
}