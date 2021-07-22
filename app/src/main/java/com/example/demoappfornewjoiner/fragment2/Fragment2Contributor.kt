package com.example.demoappfornewjoiner.fragment2

import com.example.demoappfornewjoiner.fragment2.presenter.Fragment2
import com.example.demoappfornewjoiner.repo.RepoModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class Fragment2Contributor {
	@ContributesAndroidInjector(modules = [
		Fragment2Module::class,
		RepoModule::class
	])
	abstract fun contributeFragment2() : Fragment2
}