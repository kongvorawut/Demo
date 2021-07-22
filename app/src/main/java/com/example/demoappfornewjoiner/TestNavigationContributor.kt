package com.example.demoappfornewjoiner

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TestNavigationContributor {
	@ContributesAndroidInjector
	abstract fun contributeTestNavigation() : TestNavigationActivity
}