package com.bitcodetech.mvvm.products.provider

import android.widget.ViewSwitcher.ViewFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.mvvm.auth.viewmodels.AuthViewModel
import com.bitcodetech.mvvm.auth.repo.AuthRepo
import com.bitcodetech.mvvm.products.repositories.BaseRepository
import com.bitcodetech.mvvm.products.repositories.ProductsRepository
import com.bitcodetech.mvvm.products.viewmodels.ProductsViewModel

class ViewModelFactory(private val repository: BaseRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {


        if (modelClass.isAssignableFrom(ProductsViewModel::class.java) && repository is ProductsRepository) {
            return ProductsViewModel(repository) as T
        }

        //**** AuthViewModel ****//
        if (modelClass.isAssignableFrom(AuthViewModel::class.java) && repository is AuthRepo) {
            return AuthViewModel(repository) as T
        }

        throw java.lang.Exception()
    }
}