package com.example.mvvmdemo.ui.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdemo.R
import com.example.mvvmdemo.adapters.AdapterProductsList
import com.example.mvvmdemo.data.model.Product
import com.example.mvvmdemo.data.repositories.UserRepository
import com.example.mvvmdemo.databinding.ActivityProductBinding
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity(), ProductListener {
    lateinit var mBinding:ActivityProductBinding
    var mList:ArrayList<Product> = ArrayList()
    var adapterProductsList:AdapterProductsList? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_product)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_product)
        init()
      // UserRepository().getProducts()
    }

    private fun init() {
        val viewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)
        mBinding.viewModel = viewModel
        viewModel.productListener = this

        adapterProductsList = AdapterProductsList(this, mList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapterProductsList
    }

    override fun onStarted() {
        Toast.makeText(this, "Starting now..", Toast.LENGTH_SHORT).show()

    }

    override fun onSuccess(response: LiveData<List<Product>>) {
        response.observe(this, Observer {
            adapterProductsList?.setData(it)
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()

        })
    }

    override fun onFailure(message: String) {

    }
}