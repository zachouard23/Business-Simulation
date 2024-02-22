package com.example.businessim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.businessim.databinding.ActivityFinanceBinding
import com.example.businessim.databinding.ActivityHomeBinding

class FinanceActivity : DrawerBaseActivity() {
    private lateinit var binding: ActivityFinanceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinanceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        allocateActivityTitle("Finance")
    }
}