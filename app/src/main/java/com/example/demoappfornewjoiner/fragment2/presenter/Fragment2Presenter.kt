package com.example.demoappfornewjoiner.fragment2.presenter

import com.example.demoappfornewjoiner.repo.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Fragment2Presenter @Inject constructor(
		private val view: Fragment2Contract.View,
		private val repo: Repository
): Fragment2Contract.UserActionListener {
	override fun randomCat() {
		repo.randomCat()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.doOnSubscribe { view.showLoading() }
				.doFinally { view.hideLoading() }
				.subscribeBy(onNext = { cat ->
					view.showCat(cat.webpUrl)
				}, onError = {
					view.showError()
				})
				.addTo(CompositeDisposable())
	}
}