package com.example.demoappfornewjoiner.repo

import com.example.demoappfornewjoiner.model.Cat
import io.reactivex.Observable
import javax.inject.Inject

class RepositoryImp @Inject constructor(
		private val service: Service
): Repository {

	override fun randomCat(): Observable<Cat> {
		return service.randomCat()
	}
}