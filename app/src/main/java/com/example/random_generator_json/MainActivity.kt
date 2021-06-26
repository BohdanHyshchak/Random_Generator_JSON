package com.example.random_generator_json

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.random_generator_json.databinding.ActivityMainBinding
import retrofit2.HttpException
import java.io.IOException


const val TAG = "MainActivity"

private  lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onButton(view: View){
        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.api.getRandomNumber()
            }catch (e: IOException){
                println("IOException")
                return@launchWhenCreated
            }catch (e: HttpException){
                println("HttpException")
                return@launchWhenCreated
            }
            if(response.isSuccessful && response.body() != null){
                binding.tvNumber.text = response.body()!![0].random.toString()
            }
        }
    }
}