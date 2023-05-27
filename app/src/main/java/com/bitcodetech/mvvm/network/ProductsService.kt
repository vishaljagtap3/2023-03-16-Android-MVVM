package com.bitcodetech.mvvm.network

import com.bitcodetech.mvvm.models.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ProductsService {


    @GET("superadmin/products/maincategory/{mainCatId}/{pageNo}/{pageSize}")
    fun getProductsByCategory(
        @Path("mainCatId")
        mainCatId : Int,
        @Path("pageNo")
        pageNo : Int,
        @Path("pageSize")
        pageSize : Int
    ) : ArrayList<Product>

    companion object {

        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://bitcode.in:3001/apis/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        private val productsService = retrofit.create(ProductsService::class.java)

        fun getProductsService(): ProductsService = productsService
    }
}