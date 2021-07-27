package com.example.demoappfornewjoiner.repo

import com.example.demoappfornewjoiner.model.Cat
import io.reactivex.Observable
import io.reactivex.functions.Function
import retrofit2.Response
import javax.inject.Inject

class RepositoryImp @Inject constructor(
		private val service: Service,
		private val mapper: Function<Response<Cat>, Cat>
): Repository {

	override fun randomCat(): Observable<Cat> {
		return service.randomCat().map(mapper)
	}
}