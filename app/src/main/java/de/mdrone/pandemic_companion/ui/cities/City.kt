package de.mdrone.pandemic_companion.ui.cities

class City(val name: String, val defaultColor: Int) {
    var dice: MutableMap<Int, Int> = mapOf(RED to 0, BLUE to 0, YELLOW to 0)
            as MutableMap<Int, Int>
    var neighbors: MutableList<City> = mutableListOf<City>()

    companion object {
        const val RED = 1
        const val BLUE = 2
        const val YELLOW = 3
        var totalDice: MutableMap<Int, Int> = mapOf(RED to 16, BLUE to 16, YELLOW to 16)
                as MutableMap<Int, Int>
    }

    private fun getDiceSum(dice: Int, amount: Int): Int {
        return if (dice - amount < 0){
            dice
        } else {
            amount
        }
    }


    private fun sumOfDice(): Int{
        return (dice.map{it.value}.sum())
    }

    fun addDice(color: Int, amount: Int){
        var colour = 0
        colour = if(color == 0) defaultColor else color
        val realAmount: Int = getDiceSum(totalDice[colour]!!, amount)
        dice[colour] = dice[colour]!! + realAmount
        totalDice[colour] = totalDice[colour]!! - realAmount
    }

    fun subtractDice(color: Int, amount: Int){
        var colour = 0
        colour = if(color == 0) defaultColor else color
        val realAmount: Int = getDiceSum(dice[colour]!!, amount)
        dice[colour] = dice[colour]!! - realAmount
        totalDice[colour] = totalDice[colour]!! + realAmount
    }

    fun removeAllDice(color: Int){
        var colour = 0
        colour = if(color == 0) defaultColor else color
        val subtraction = dice[colour]!!
        dice[colour] = 0
        totalDice[colour] = totalDice[colour]!! + subtraction
    }

    fun addNeighbor(city: City){
        neighbors.add(city)
    }
}