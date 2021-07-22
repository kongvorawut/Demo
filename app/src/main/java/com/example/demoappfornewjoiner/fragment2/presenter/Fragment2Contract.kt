package com.example.demoappfornewjoiner.fragment2.presenter

interface Fragment2Contract {
	interface View {
		fun showCat(url: String)
	}
	interface UserActionListener {
		fun randomCat()
	}
}