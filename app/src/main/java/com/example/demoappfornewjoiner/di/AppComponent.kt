package com.example.demoappfornewjoiner.di

import com.example.demoappfornewjoiner.MyApplication
import com.example.demoappfornewjoiner.network.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
	AndroidSupportInjectionModule::class,
	NetworkModule::class,
	ContributeModule::class
])
interface AppComponent: AndroidInjector<MyApplication> {
	@Component.Factory
	interface Factory: AndroidInjector.Factory<MyApplication>
}