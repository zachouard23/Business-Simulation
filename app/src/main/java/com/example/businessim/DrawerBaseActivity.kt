package com.example.businessim

import android.content.Intent
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.view.MenuItem
open class DrawerBaseActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun setContentView(view: View) {
        drawerLayout = layoutInflater.inflate(R.layout.activity_drawer_base, null) as DrawerLayout
        val container = drawerLayout.findViewById<FrameLayout>(R.id.activityContainer)
        container.addView(view)
        super.setContentView(drawerLayout)
        val toolbar = drawerLayout.findViewById<Toolbar>(R.id.toolBar)
        setSupportActionBar(toolbar)

        val navigationView = drawerLayout.findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.menu_drawer_open, R.string.menu_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

     override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)
        when (item.itemId) {
            R.id.nav_logout -> {
                val intent1 = Intent(this, LoginActivity::class.java)
                startActivity(intent1)

            }

            R.id.nav_home -> {
                val intent2 = Intent(this, HomeActivity::class.java)
                startActivity(intent2)

            }
            R.id.nav_research -> {
                val intent3 = Intent(this, ResearchActivity::class.java)
                startActivity(intent3)

            }
            R.id.nav_finance -> {
                val intent4 = Intent(this, FinanceActivity::class.java)
                startActivity(intent4)

            }

            R.id.nav_Marketing -> {
                val intent5 = Intent(this, MarketingActivity::class.java)
                startActivity(intent5)

            }
            R.id.nav_production -> {
                val intent6 = Intent(this, ProductionActivity::class.java)
                startActivity(intent6)

            }
        }
         return false

            // Add more cases for other navigation items if needed

    }

    protected fun allocateActivityTitle(titleString: String) {
        if (supportActionBar != null) {
            supportActionBar?.title = titleString
        }
    }
}

