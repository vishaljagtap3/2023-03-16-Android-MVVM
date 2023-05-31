package com.bitcodetech.mvvm.products.viewmodels

import android.content.Context
import android.os.Bundle
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
    val productsAvailableLiveData = MutableLiveData<Bundle>()

    //actual data srouce
    val productsList = ArrayList<Product>()


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
                //productsLiveData.postValue(response!!.data)
                val update = Bundle()
                update.putInt("start_pos", productsList.size)
                update.putInt("end_pos", productsList.size + response!!.data.size - 1)
                productsList.addAll(response!!.data)

                 productsAvailableLiveData.postValue(update)

            }
        }

    }

}