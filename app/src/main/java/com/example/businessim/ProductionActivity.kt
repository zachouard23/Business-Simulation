package com.example.businessim

import android.os.Bundle
import com.example.businessim.databinding.ActivityProductionBinding

class ProductionActivity : DrawerBaseActivity() {
    private lateinit var binding: ActivityProductionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        allocateActivityTitle("Production")
    }
}
