package edu.bellevue.bhuvan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.bellevue.bhuvan.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.content_main.view.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val bottomNav=binding.bottomNavigation

        val navController = this.findNavController(R.id.myNavHostFragment)
        //NavigationUI.setupWithNavController(bottomNav,navController)
        bottomNav.setupWithNavController(navController)
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }
}
