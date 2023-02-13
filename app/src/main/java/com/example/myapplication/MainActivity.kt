package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        binding.apply {
            btnSave.setOnClickListener {
                val userName = edtUsername.text.toString()
                val email = edtEmail.text.toString()
                Log.d(userName,email);
                editor.apply {
                    putString("user_name", userName)
                    putString("email", email)
                    apply()
                }
            }
            btnLoad.setOnClickListener{
                val userName = sharedPref.getString("user_name",null)
                val email = sharedPref.getString("email",null)
                tvEmail.text = email
                tvUsername.text = userName
            }
        }
    }
}