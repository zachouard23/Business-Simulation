package com.example.businessim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.businessim.databinding.ActivityHomeBinding


class HomeActivity : DrawerBaseActivity() {
    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        allocateActivityTitle("Home")
    }
}