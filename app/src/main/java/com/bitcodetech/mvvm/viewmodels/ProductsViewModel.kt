package com.bitcodetech.mvvm.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitcodetech.mvvm.models.Product
import com.bitcodetech.mvvm.repositories.ProductsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductsViewModel(
    private val productsRepository: ProductsRepository
) : ViewModel() {

    val productsLiveData = MutableLiveData<ArrayList<Product>>()


    fun getProductsByCategory(
        mainCategoryId : Int,
        pageNo : Int,
        pageSize : Int
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val products = productsRepository.getProductsByCategory(mainCategoryId, pageNo, pageSize)

            withContext(Dispatchers.Main) {
                productsLiveData.postValue(products)
            }
        }

    }

}