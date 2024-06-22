package com.example.apkroomtamires

import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.configurarBarraDeFerramentas(title: String, enableBackButton: Boolean) {
    supportActionBar?.apply {
        this.title = title
        setDisplayHomeAsUpEnabled(enableBackButton)
    }
}