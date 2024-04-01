package com.example.businessim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.businessim.databinding.ActivityMarketingBinding
import com.example.businessim.view.productAdapter

class MarketingActivity : DrawerBaseActivity() {
    private lateinit var binding: ActivityMarketingBinding
    private lateinit var recv: RecyclerView
    private lateinit var adapter: productAdapter
    private lateinit var productList: ArrayList<String> // Assuming your product names are strings

    // Firebase
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarketingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        allocateActivityTitle("Marketing")
    }
}