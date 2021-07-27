package com.example.demoappfornewjoiner.fragment2.presenter

interface Fragment2Contract {
	interface View {
		fun showCat(url: String)
		fun showLoading()
		fun hideLoading()
		fun showError()
	}
	interface UserActionListener {
		fun randomCat()
	}
}