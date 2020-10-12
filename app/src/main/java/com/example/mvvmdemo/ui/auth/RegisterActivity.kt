package com.example.mvvmdemo.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmdemo.R
import com.example.mvvmdemo.d
import com.example.mvvmdemo.databinding.ActivityRegisterBinding
import com.example.mvvmdemo.toast

class RegisterActivity : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_register)

        val binding:ActivityRegisterBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.authListener = this
    }

    override fun onStarted() {
        this.toast("OnStarted")
        this.d("I'm Registering")
    }

    override fun onSuccess(response: LiveData<String>) {
        response.observe(this, Observer {
            this.toast("Success")
        })
    }

    override fun failure(message: String) {
        this.toast(message)

    }
}