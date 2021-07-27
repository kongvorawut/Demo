package com.example.demoappfornewjoiner.repo

import com.example.demoappfornewjoiner.model.Cat
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface Service {
	@GET("catapi/rest/")
	fun randomCat(): Observable<Response<Cat>>
}