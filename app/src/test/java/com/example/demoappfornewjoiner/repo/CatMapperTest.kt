package com.example.demoappfornewjoiner.repo

import com.example.demoappfornewjoiner.RxImmediateSchedulerRule
import com.example.demoappfornewjoiner.model.Cat
import com.example.demoappfornewjoiner.model.exception.InternalErrorException
import com.example.demoappfornewjoiner.model.exception.OtherException
import io.reactivex.functions.Function
import okhttp3.ResponseBody
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import retrofit2.Response

class CatMapperTest {

	@get:Rule
	var rx = RxImmediateSchedulerRule()

	private lateinit var mapper: Function<Response<Cat>, Cat>

	@Before
	fun setUp() {
		mapper = CatMapper()
	}

	@Test
	fun applySuccess() {
		val cat = Cat()
		val res = Response.success(cat)
		val result = mapper.apply(res)

		assertEquals(cat, result)
	}

	@Test(expected = OtherException::class)
	fun applySuccessWithNull() {
		val res = Response.success<Cat>(null)
		mapper.apply(res)
	}
}