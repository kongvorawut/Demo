package com.example.demoappfornewjoiner.fragment2

import com.example.demoappfornewjoiner.fragment2.presenter.Fragment2
import com.example.demoappfornewjoiner.fragment2.presenter.Fragment2Contract
import com.example.demoappfornewjoiner.fragment2.presenter.Fragment2Presenter
import com.example.demoappfornewjoiner.repo.RepoModule
import dagger.Module
import dagger.Provides

@Module
class Fragment2Module {
	@Provides
	fun provideView(fragment2: Fragment2): Fragment2Contract.View = fragment2

	@Provides
	fun providePresenter(presenter: Fragment2Presenter): Fragment2Contract.UserActionListener = presenter
}