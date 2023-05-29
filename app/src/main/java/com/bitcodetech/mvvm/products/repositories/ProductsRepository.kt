package com.bitcodetech.mvvm.products.repositories

import com.bitcodetech.mvvm.products.models.Product
import com.bitcodetech.mvvm.products.models.ProductsResponse
import com.bitcodetech.mvvm.products.network.ProductsService

class ProductsRepository(
    private val productsService: ProductsService
) : BaseRepository() {

    suspend fun getProductsByCategory(
        token : String,
        mainCategoryId : Int,
        pageNo : Int,
        pageSize : Int
    ) : ProductsResponse? {
        return productsService.getProductsByCategory(
            token,
            mainCategoryId,
            pageNo,
            pageSize
        )
    }

}