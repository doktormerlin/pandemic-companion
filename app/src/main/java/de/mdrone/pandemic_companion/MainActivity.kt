package de.mdrone.pandemic_companion

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import de.mdrone.pandemic_companion.ui.cities.City

class MainActivity : AppCompatActivity() {

    companion object{
        val cities: List<City> = listOf<City>(
            City("Seattle", City.RED),
            City("Denver", City.RED),
            City("San Francisco", City.RED),
            City("Calgary", City.RED),
            City("Minneapolis", City.RED),
            City("Los Angeles", City.RED),
            City("Dallas", City.RED),
            City("Phoenix", City.RED),
            City("Washington", City.BLUE),
            City("New York", City.BLUE),
            City("Boston", City.BLUE),
            City("Montreal", City.BLUE),
            City("Indianapolis", City.BLUE),
            City("Chicago", City.BLUE),
            City("Atlanta", City.BLUE),
            City("Toronto", City.BLUE),
            City("New Orleans", City.YELLOW),
            City("Miami", City.YELLOW),
            City("Tegucigalpa", City.YELLOW),
            City("Santo Domingo", City.YELLOW),
            City("Mexico City", City.YELLOW),
            City("Monterey", City.YELLOW),
            City("Guadalajara", City.YELLOW),
            City("Havanna", City.YELLOW)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        // val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_cities, R.id.navigation_medicine, R.id.navigation_about))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}