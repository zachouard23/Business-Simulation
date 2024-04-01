package com.example.businessim.model

data class ProductData (
    var productName: String? = null,
    var researchFocus: String? = null,
    var researchMethod: String? = null, // in-house, outsource, coop
    var quality: String? = null         // 1, 2, 3, 4, 5
)
