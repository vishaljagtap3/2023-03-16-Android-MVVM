package com.bitcodetech.mvvm.repositories

import com.bitcodetech.mvvm.models.Product
import com.bitcodetech.mvvm.network.ProductsService

class ProductsRepository(
    private val productsService: ProductsService
) : BaseRepository() {

    fun getProductsByCategory(
        mainCategoryId : Int,
        pageNo : Int,
        pageSize : Int
    ) : ArrayList<Product>? {
        return productsService.getProductsByCategory(
            mainCategoryId,
            pageNo,
            pageSize
        )
    }

}