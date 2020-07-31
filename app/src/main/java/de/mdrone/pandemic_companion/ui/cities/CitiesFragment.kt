package de.mdrone.pandemic_companion.ui.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import de.mdrone.pandemic_companion.R

class CitiesFragment : Fragment() {

    private lateinit var citiesViewModel: CitiesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        citiesViewModel =
                ViewModelProviders.of(this).get(CitiesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_cities, container, false)
        val textView: TextView = root.findViewById(R.id.text_cities)
        citiesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}