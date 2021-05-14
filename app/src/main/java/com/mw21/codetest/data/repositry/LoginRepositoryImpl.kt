package com.mw21.codetest.data.repositry

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import com.mw21.codetest.domain.repository.LogInRepositoy

class LoginRepositoryImpl: LogInRepositoy {
    override var logInResult: MutableLiveData<Boolean> = MutableLiveData()
     lateinit var firebaseAuth: FirebaseAuth
    override suspend fun logIn(user: String, pass: String) {
        try {
            firebaseAuth = FirebaseAuth.getInstance()
            firebaseAuth.signInWithEmailAndPassword(user, pass)
                .addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                    override fun onComplete(task: Task<AuthResult>) {
                        if (task.isSuccessful) {
                            logInResult.postValue(true)
                        } else {
                            logInResult.postValue(false)
                        }
                    }
                })
        }catch (e: Exception) {
            Log.d("Exception", e.message.toString())
        }
    }
}