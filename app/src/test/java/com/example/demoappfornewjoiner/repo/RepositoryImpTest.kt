package com.example.demoappfornewjoiner.repo

import com.example.demoappfornewjoiner.RxImmediateSchedulerRule
import com.example.demoappfornewjoiner.model.Cat
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import io.reactivex.functions.Function
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import retrofit2.Response

class RepositoryImpTest {

	@get:Rule
	var rx = RxImmediateSchedulerRule()

	@Mock
	lateinit var service: Service

	@Mock
	lateinit var mapper: Function<Response<Cat>, Cat>

	private lateinit var repo: Repository

	@Before
	fun setUp() {
		MockitoAnnotations.initMocks(this)
		repo = RepositoryImp(
				service = service,
				mapper = mapper
		)
	}

	@Test
	fun randomCatSuccess() {
		val cat = Cat()
		val res = Response.success(cat)
		whenever(service.randomCat()) doReturn Observable.just(res)
		whenever(mapper.apply(res)) doReturn cat

		val observable = repo.randomCat().test()
		observable.assertValue(cat)

		verify(service).randomCat()
		verify(mapper).apply(res)
	}

	@Test
	fun randomCatFailure() {
		val error = Throwable()
		whenever(service.randomCat()) doReturn Observable.error(error)

		val observable = repo.randomCat().test()
		observable.assertError(error)

		verify(service).randomCat()
	}
}