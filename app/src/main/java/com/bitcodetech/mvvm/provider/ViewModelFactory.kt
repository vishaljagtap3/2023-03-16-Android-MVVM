package com.bitcodetech.mvvm.provider

import android.widget.ViewSwitcher.ViewFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.mvvm.repositories.BaseRepository
import com.bitcodetech.mvvm.repositories.ProductsRepository
import com.bitcodetech.mvvm.viewmodels.ProductsViewModel

class ViewModelFactory(private val repository: BaseRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {


        if (modelClass.isAssignableFrom(ProductsViewModel::class.java) && repository is ProductsRepository) {
            return ProductsViewModel(repository) as T
        }

        throw java.lang.Exception()
    }
}