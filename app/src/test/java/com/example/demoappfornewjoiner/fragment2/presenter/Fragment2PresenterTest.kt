package com.example.demoappfornewjoiner.fragment2.presenter

import com.example.demoappfornewjoiner.RxImmediateSchedulerRule
import com.example.demoappfornewjoiner.model.Cat
import com.example.demoappfornewjoiner.repo.Repository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class Fragment2PresenterTest {

	@get:Rule
	var rule = RxImmediateSchedulerRule()

	@Mock
	lateinit var view: Fragment2Contract.View

	@Mock
	lateinit var repo: Repository

	private lateinit var presenter: Fragment2Contract.UserActionListener

	@Before
	fun setUp() {
		MockitoAnnotations.initMocks(this)
		presenter = Fragment2Presenter(
				view = view,
				repo = repo)
	}

	@Test
	fun randomCatSuccess() {
		val cat = Cat()
		whenever(repo.randomCat()) doReturn Observable.just(cat)

		presenter.randomCat()

		verify(repo).randomCat()
		verify(view).showLoading()
		verify(view).hideLoading()
		verify(view).showCat(cat.webpUrl)
	}

	@Test
	fun randomCatFailure() {
		val error = Throwable()
		whenever(repo.randomCat()) doReturn Observable.error(error)

		presenter.randomCat()

		verify(repo).randomCat()
		verify(view).showLoading()
		verify(view).hideLoading()
		verify(view).showError()
	}
}