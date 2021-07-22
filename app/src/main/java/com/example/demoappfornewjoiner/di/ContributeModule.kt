package com.example.demoappfornewjoiner.di

import com.example.demoappfornewjoiner.TestNavigationContributor
import com.example.demoappfornewjoiner.fragment1.Fragment1Contributor
import com.example.demoappfornewjoiner.fragment2.Fragment2Contributor
import dagger.Module

@Module(includes = [
	TestNavigationContributor::class,
	Fragment1Contributor::class,
	Fragment2Contributor::class
])
class ContributeModule {
}