package com.example.demoappfornewjoiner.fragment2.presenter

import com.example.demoappfornewjoiner.model.Cat
import com.example.demoappfornewjoiner.repo.Repository
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
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
				.subscribe(object : Observer<Cat>{
					override fun onSubscribe(d: Disposable) {
					}

					override fun onNext(cat: Cat) {
						view.showCat(cat.webpUrl)
					}

					override fun onError(e: Throwable) {
					}

					override fun onComplete() {
					}
				})
	}
}