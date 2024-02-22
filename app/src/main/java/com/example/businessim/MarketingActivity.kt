package com.example.businessim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.businessim.databinding.ActivityMarketingBinding

class MarketingActivity : DrawerBaseActivity() {
    private lateinit var binding: ActivityMarketingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarketingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        allocateActivityTitle("Marketing")
    }
}