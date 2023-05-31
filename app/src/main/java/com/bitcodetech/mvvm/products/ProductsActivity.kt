package com.bitcodetech.mvvm.products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.mvvm.R
import com.bitcodetech.mvvm.products.network.ProductsService
import com.bitcodetech.mvvm.products.provider.ViewModelFactory
import com.bitcodetech.mvvm.products.repositories.ProductsRepository
import com.bitcodetech.mvvm.products.viewmodels.ProductsViewModel
import com.bitcodetech.mvvm.util.prefs.Preferences

class ProductsActivity : AppCompatActivity() {

    private lateinit var productsViewModel: ProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModels()
        initAdapters()
        initObservers()

        productsViewModel.getProductsByCategory(
            Preferences.getToken(this)!!,
            2,
            1,
            10
        )
    }

    private fun initAdapters() {
        productsViewModel.productsList //connect this to adapter and connect adapter to RV
    }

    private fun initObservers() {

        productsViewModel.productsLiveData.observe(
            this
        ) {
            if (it != null) {
                for (product in it!!) {
                    Log.e("tag", "$product")
                }
            }
        }

        productsViewModel.productsAvailableLiveData.observe(
            this
        ) {
            if(it != null) {
                val startPos = it.getInt("start_pos")
                val endPost = it.getInt("end_pos")

            }
        }

        /*productsViewModel.productsLiveData.observe(
            this,
            object : Observer<ArrayList<Product>> {
                override fun onChanged(t: ArrayList<Product>?) {
                    TODO("Not yet implemented")
                }

            }
        )*/
    }

    private fun initViewModels() {
        productsViewModel =
            ViewModelProvider(
                this,
                ViewModelFactory(
                    ProductsRepository(
                        ProductsService.getProductsService()
                    )
                )
            )[ProductsViewModel::class.java]
    }
}