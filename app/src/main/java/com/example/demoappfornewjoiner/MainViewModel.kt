package com.example.demoappfornewjoiner

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
	val name = MutableLiveData<String>()
}