package com.example.demoappfornewjoiner

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.demoappfornewjoiner.base.BaseActivity
import com.example.demoappfornewjoiner.fragment1.Fragment1Args

class TestNavigationActivity : BaseActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_test_navigation)

		val bundle = Fragment1Args(data = "Test").toBundle()
		val navHost = NavHostFragment.create(R.navigation.navigation_test, bundle)

		supportFragmentManager.beginTransaction()
				.replace(R.id.fragmentContainerView, navHost)
				.setPrimaryNavigationFragment(navHost)
				.commitNow()
	}
}