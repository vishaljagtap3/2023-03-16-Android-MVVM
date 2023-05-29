package com.bitcodetech.mvvm.products.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitcodetech.mvvm.products.models.Product
import com.bitcodetech.mvvm.products.repositories.ProductsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductsViewModel(
    private val productsRepository: ProductsRepository
) : ViewModel() {

    val productsLiveData = MutableLiveData<ArrayList<Product>>()


    fun getProductsByCategory(
        token : String,
        mainCategoryId : Int,
        pageNo : Int,
        pageSize : Int
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = productsRepository.getProductsByCategory(
                token,
                mainCategoryId,
                pageNo,
                pageSize
            )

            withContext(Dispatchers.Main) {
                productsLiveData.postValue(response!!.data)
            }
        }

    }

}