package de.mdrone.pandemic_companion.ui.cities

import kotlin.properties.Delegates

class City(var defaultColor: Int) {
    var redDice: Int = 0
    var yellowDice: Int  = 0
    var blueDice: Int  = 0

    companion object {
        var totalRedDice: Int  = 16
        var totalBlueDice: Int  = 16
        var totalYellowDice: Int  = 16
        const val RED = 1
        const val BLUE = 2
        const val YELLOW = 3
    }

    private fun getDiceSum(total_dice: Int, amount: Int): Int {
        return if (total_dice - amount < 0){
            total_dice
        } else {
            amount
        }
    }

    private fun addRedDice(amount: Int){
        totalRedDice -= amount
        redDice += amount
    }

    private fun addYellowDice(amount: Int){
        totalYellowDice -= amount
        yellowDice += amount
    }

    private fun addBlueDice(amount: Int){
        totalBlueDice -= amount
        blueDice += amount
    }

    fun addDice(color: String, amount: Int){
        when(color){
            "red" -> addRedDice(getDiceSum(totalRedDice, amount))
            "blue" -> addBlueDice(getDiceSum(totalBlueDice, amount))
            "yellow" -> addYellowDice(getDiceSum(totalYellowDice, amount))
        }
    }
}