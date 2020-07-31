package de.mdrone.pandemic_companion.ui.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import de.mdrone.pandemic_companion.MainActivity.Companion.cities
import de.mdrone.pandemic_companion.R

class CitiesFragment : Fragment() {

    private lateinit var citiesViewModel: CitiesViewModel
    private lateinit var colorChoice: RadioGroup

    private fun onClickPlus(city: City, amount: Int){
        city.addDice(getSelectedColor(), amount)
    }

    private fun onClickMinus(city: City, amount: Int){
        city.subtractDice(getSelectedColor(), amount)
    }

    private fun getSelectedColor(): Int{
        return when(colorChoice.checkedRadioButtonId){
            R.id.radio_btn_default_color -> 0
            R.id.radio_btn_red -> City.RED
            R.id.radio_btn_blue -> City.BLUE
            R.id.radio_btn_yellow -> City.YELLOW
            else -> 0
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        citiesViewModel =
                ViewModelProviders.of(this).get(CitiesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_cities, container, false)
        colorChoice = root.findViewById(R.id.radio_grp_colors)
        colorChoice.check(R.id.radio_btn_default_color)
        val scrollView: LinearLayout = root.findViewById(R.id.scrollview_cities)
        cities.forEach {
            val thisCity = it
            val cityRow: LinearLayout = LinearLayout(this.context)
            val layoutParamsMatch = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            val layoutParamsWrap = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            val layoutParamsMatchWrap = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            cityRow.layoutParams = layoutParamsMatch
            cityRow.orientation = LinearLayout.HORIZONTAL
            val btnMinus3 = Button(this.context)
            val btnMinus1 = Button(this.context)
            val btnPlus1 = Button(this.context)
            val btnPlus3 = Button(this.context)
            val btnRemoveAll = Button(this.context)
            btnMinus3.layoutParams = layoutParamsWrap
            btnMinus1.layoutParams = layoutParamsWrap
            btnPlus1.layoutParams = layoutParamsWrap
            btnPlus3.layoutParams = layoutParamsWrap
            btnRemoveAll.layoutParams = layoutParamsMatchWrap
            btnMinus3.text = getString(R.string.btn_minus_3)
            btnMinus1.text = getString(R.string.btn_minus_1)
            btnPlus1.text = getString(R.string.btn_plus_1)
            btnPlus3.text = getString(R.string.btn_plus_3)
            btnRemoveAll.text = getString(R.string.btn_remove_all)

            btnPlus1.setOnClickListener {
                onClickPlus(thisCity, 1)
            }
            btnPlus3.setOnClickListener {
                onClickPlus(thisCity, 3)
            }
            btnMinus1.setOnClickListener {
                onClickMinus(thisCity, 1)
            }
            btnMinus3.setOnClickListener {
                onClickMinus(thisCity, 3)
            }

            btnRemoveAll.setOnClickListener {
                thisCity.removeAllDice(getSelectedColor())
            }

            val txtCityName = TextView(this.context)
            txtCityName.text = it.name
            val txtCityDice = TextView(this.context)
            txtCityDice.text = getString(R.string.txt_dice_amount, it.dice[City.RED], it.dice[City.BLUE], it.dice[City.YELLOW])

            btnPlus1.setOnClickListener {
                onClickPlus(thisCity, 1)
                txtCityDice.text = getString(R.string.txt_dice_amount, thisCity.dice[City.RED], thisCity.dice[City.BLUE], thisCity.dice[City.YELLOW])
            }
            btnPlus3.setOnClickListener {
                onClickPlus(thisCity, 3)
                txtCityDice.text = getString(R.string.txt_dice_amount, thisCity.dice[City.RED], thisCity.dice[City.BLUE], thisCity.dice[City.YELLOW])
            }
            btnMinus1.setOnClickListener {
                onClickMinus(thisCity, 1)
                txtCityDice.text = getString(R.string.txt_dice_amount, thisCity.dice[City.RED], thisCity.dice[City.BLUE], thisCity.dice[City.YELLOW])
            }
            btnMinus3.setOnClickListener {
                onClickMinus(thisCity, 3)
                txtCityDice.text = getString(R.string.txt_dice_amount, thisCity.dice[City.RED], thisCity.dice[City.BLUE], thisCity.dice[City.YELLOW])
            }

            btnRemoveAll.setOnClickListener {
                thisCity.removeAllDice(getSelectedColor())
                txtCityDice.text = getString(R.string.txt_dice_amount, thisCity.dice[City.RED], thisCity.dice[City.BLUE], thisCity.dice[City.YELLOW])
            }

            val cityInformation = LinearLayout(this.context)
            cityInformation.layoutParams = layoutParamsWrap
            cityInformation.orientation = LinearLayout.VERTICAL
            cityInformation.addView(txtCityName)
            cityInformation.addView(txtCityDice)
            cityInformation.addView(btnRemoveAll)

            cityRow.addView(btnMinus3)
            cityRow.addView(btnMinus1)

            cityRow.addView(cityInformation)

            cityRow.addView(btnPlus1)
            cityRow.addView(btnPlus3)

            scrollView.addView(cityRow)
        }
        return root
    }
}