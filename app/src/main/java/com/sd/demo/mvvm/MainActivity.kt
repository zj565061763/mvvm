package com.sd.demo.mvvm

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sd.demo.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val TAG = MainActivity::class.simpleName

    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
    }

    override fun onClick(v: View?) {
        when (v) {
            _binding.btn -> {

            }
        }
    }
}