package com.example.demoappfornewjoiner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.demoappfornewjoiner.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
	private val viewModel: MainViewModel by viewModels()
	private var binding: ActivityMainBinding? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		binding?.lifecycleOwner = this
		binding?.viewModel = viewModel
		setContentView(binding?.root)

		binding?.button?.setOnClickListener {
			viewModel.name.value = binding?.editText?.text.toString()
		}
	}
}