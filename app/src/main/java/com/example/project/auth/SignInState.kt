package com.example.project.auth

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)