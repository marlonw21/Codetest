package com.mw21.codetest.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.mw21.codetest.R
import com.mw21.codetest.presentation.di.Injector
import com.mw21.codetest.presentation.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: LogInViewModelFactory
    private lateinit var logInViewModel: LogInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        (application as Injector).createLogInSubComponent()
            .inject(this)

        logInViewModel = ViewModelProvider(this, factory)
            .get(LogInViewModel::class.java)

        logInBtn.setOnClickListener {
            showProgressBar()
            val user = etUser.text.toString()
            val pass = etPassword.text.toString()
            checkFields(user, pass)
            logInViewModel.logInResult.observe(this, Observer {
                if (it){
                    Log.d("Login","IN")
                    goHome()
                } else{
                    hideProgressBar()
                    showError()
                }
            })
        }
    }

    private fun checkFields(user: String, pass: String) {
        if (user.isNullOrEmpty() || pass.isNullOrEmpty()){
            etUser.setError("Field required")
            etPassword.setError("Field required")
            hideProgressBar()
        }else{
            login(user, pass)
        }

    }

    private fun login(user: String, pass: String) {
        logInViewModel.logIn(user, pass)
    }

    private fun showError() {
        tvError.visibility = View.VISIBLE
    }

    private fun goHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    private fun showProgressBar(){
        progressBar.visibility = View.VISIBLE
    }
    private fun hideProgressBar(){
        progressBar.visibility = View.GONE
    }
}