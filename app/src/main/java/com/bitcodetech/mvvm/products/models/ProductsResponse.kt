package com.bitcodetech.mvvm.products.models

import com.google.gson.annotations.SerializedName

class ProductsResponse(
    @SerializedName("response_code")
    val responseCode: String,
    val message: String,
    val data: ArrayList<Product>
)
