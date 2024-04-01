package com.example.businessim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.businessim.databinding.ActivityHomeBinding
import com.example.businessim.databinding.ActivityResearchBinding
import com.example.businessim.model.ProductData
import com.example.businessim.view.productAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class ResearchActivity : DrawerBaseActivity() {
    private lateinit var binding: ActivityResearchBinding
    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recv: RecyclerView
    private lateinit var userList: ArrayList<ProductData>
    private lateinit var proAdapter: productAdapter
    private val database = FirebaseDatabase.getInstance().reference.child("products")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**set List*/
        userList = ArrayList()
        /**set find Id*/
        addsBtn = findViewById(R.id.addingBtn)
        recv = findViewById(R.id.productRecycler)
        /**set Adapter*/
        proAdapter = productAdapter(this, userList)
        /**setRecycler view Adapter*/
        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = proAdapter
        getProductData()
        /**set Dialog*/
        addsBtn.setOnClickListener { addInfo() }

    }

    private fun addInfo() {
        val inflater = LayoutInflater.from(this)
        val v = inflater.inflate(R.layout.add_product, null)

        val name = v.findViewById<EditText>(R.id.productName)
        val focus = v.findViewById<EditText>(R.id.productFocus)
        val method = v.findViewById<Spinner>(R.id.researchMethod)
        val quality = v.findViewById<Spinner>(R.id.quality_spinner)

        val addDialog = AlertDialog.Builder(this)

        addDialog.setView(v)
        addDialog.setPositiveButton("Ok") { dialog, _ ->
            val rName = name.text.toString()
            val rFocus = focus.text.toString()
            val rMethod = method.selectedItem.toString()
            val rQuality = quality.selectedItem.toString()

             // Generate a unique ID for the product
            val productRef = database.child(rName ?: "")
            val productData = ProductData(rName, rFocus, rMethod, rQuality)
            productRef.setValue(productData)

            userList.add(productData)
            proAdapter.notifyDataSetChanged()
            Toast.makeText(this, "Adding product Information Success", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
        }
        addDialog.create().show()
    }
    private fun getProductData() {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val tempList = ArrayList<ProductData>()
                for (userSnapshot in snapshot.children) {
                    val product = userSnapshot.getValue(ProductData::class.java)
                    product?.let { tempList.add(it) }
                }
                userList.clear() // Clear userList
                userList.addAll(tempList)
                proAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
                Toast.makeText(this@ResearchActivity, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
