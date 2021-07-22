package com.example.demoappfornewjoiner.fragment1

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class Fragment1Contributor {
	@ContributesAndroidInjector
	abstract fun contributeFragment1(): Fragment1
}