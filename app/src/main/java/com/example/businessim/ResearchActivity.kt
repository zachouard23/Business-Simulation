package com.example.businessim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.businessim.databinding.ActivityHomeBinding
import com.example.businessim.databinding.ActivityResearchBinding

class ResearchActivity : DrawerBaseActivity() {
    private lateinit var binding: ActivityResearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        allocateActivityTitle("R&D")
    }
}