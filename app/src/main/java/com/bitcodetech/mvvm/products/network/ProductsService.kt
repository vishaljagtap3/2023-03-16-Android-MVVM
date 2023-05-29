package com.bitcodetech.mvvm.products.network

import com.bitcodetech.mvvm.products.models.Product
import com.bitcodetech.mvvm.products.models.ProductsResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ProductsService {



    @GET("superadmin/products/maincategory/{mainCatId}/{pageNo}/{pageSize}")
    suspend fun getProductsByCategory(
        @Header("Authorization")
        token : String,
        @Path("mainCatId")
        mainCatId : Int,
        @Path("pageNo")
        pageNo : Int,
        @Path("pageSize")
        pageSize : Int
    ) : ProductsResponse

    companion object {

        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://bitcode.in:3000/apis/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        private val productsService = retrofit.create(ProductsService::class.java)

        fun getProductsService(): ProductsService = productsService
    }
}