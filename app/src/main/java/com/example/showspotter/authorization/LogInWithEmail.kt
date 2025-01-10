package com.example.showspotter.authorization

import android.content.Context
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

fun LogInUser(
    auth: FirebaseAuth,
    email: String,
    password: String,
    context: Context,
    openMainScreen: () -> Unit
) {

    if (email.isNotBlank() && password.isNotBlank()) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task -> // this is a callback, gets executed when sign up is done, sign up can take some time
                if (task.isSuccessful) {
                    Toast.makeText(context, "Log In SuccessFully", Toast.LENGTH_SHORT).show()
                    openMainScreen()

                } else [
                    Toast.makeText(
                        context,
                        "Log In  Failed ${task.exception?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                ]
            }
    }
}