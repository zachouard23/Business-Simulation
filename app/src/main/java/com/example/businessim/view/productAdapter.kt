package com.example.businessim.view

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.businessim.R
import com.example.businessim.model.ProductData

class productAdapter(val c: Context, val userList: ArrayList<ProductData>) :
    RecyclerView.Adapter<productAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
        var rName: TextView
        var rfocus: TextView
        var rMethod: TextView
        var rQuality: TextView
        var mMenus: ImageView

        init {
            rName = v.findViewById<TextView>(R.id.productName)
            rfocus = v.findViewById<TextView>(R.id.reseachFocus)
            rMethod = v.findViewById<TextView>(R.id.rMethod)
            rQuality = v.findViewById<TextView>(R.id.quality)
            mMenus = v.findViewById(R.id.mMenus)
            mMenus.setOnClickListener { popupMenus(it) }
        }

        private fun popupMenus(v: View) {
            val position = userList[adapterPosition]
            val popupMenus = PopupMenu(c, v)
            popupMenus.inflate(R.menu.edit_product)
            popupMenus.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.editText -> {
                        val v = LayoutInflater.from(c).inflate(R.layout.add_product, null)
                        val name = v.findViewById<EditText>(R.id.productName)
                        val focus = v.findViewById<EditText>(R.id.productFocus)
                        val method = v.findViewById<Spinner>(R.id.researchMethod)
                        val quality = v.findViewById<Spinner>(R.id.quality_spinner)
                        AlertDialog.Builder(c)
                            .setView(v)
                            .setPositiveButton("Ok") { dialog, _ ->
                                position.productName = name.text.toString()
                                position.researchFocus = focus.text.toString()
                                position.researchMethod = method.selectedItem.toString()
                                position.quality = quality.selectedItem.toString()
                                notifyDataSetChanged()
                                Toast.makeText(c, "User Information is Edited", Toast.LENGTH_SHORT).show()
                                dialog.dismiss()

                            }
                            .setNegativeButton("Cancel") { dialog, _ ->
                                dialog.dismiss()

                            }
                            .create()
                            .show()

                        true
                    }
                    R.id.delete -> {
                        /**set delete*/
                        AlertDialog.Builder(c)
                            .setTitle("Delete")
                            .setIcon(R.drawable.warning_icon)
                            .setMessage("Are you sure delete this Information")
                            .setPositiveButton("Yes") { dialog, _ ->
                                userList.removeAt(adapterPosition)
                                notifyDataSetChanged()
                                Toast.makeText(c, "Deleted this Information", Toast.LENGTH_SHORT).show()
                                dialog.dismiss()
                            }
                            .setNegativeButton("No") { dialog, _ ->
                                dialog.dismiss()
                            }
                            .create()
                            .show()

                        true
                    }
                    else -> true
                }

            }
            popupMenus.show()
            val popup = PopupMenu::class.java.getDeclaredField("mPopup")
            popup.isAccessible = true
            val menu = popup.get(popupMenus)
            menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                .invoke(menu, true)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val pro = LayoutInflater.from(parent.context).inflate(R.layout.product_list, parent, false)
        return ProductViewHolder(pro)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val newList = userList[position]
        holder.rName.text = newList.productName
        holder.rfocus.text = newList.researchFocus
        holder.rMethod.text = newList.researchMethod
        holder.rQuality.text = newList.quality
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}