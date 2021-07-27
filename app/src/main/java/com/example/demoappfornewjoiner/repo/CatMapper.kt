package com.example.demoappfornewjoiner.repo

import com.example.demoappfornewjoiner.model.Cat
import com.example.demoappfornewjoiner.model.exception.InternalErrorException
import com.example.demoappfornewjoiner.model.exception.OtherException
import io.reactivex.functions.Function
import retrofit2.Response
import java.net.HttpURLConnection
import javax.inject.Inject

class CatMapper @Inject constructor(): Function<Response<Cat>, Cat> {
	override fun apply(res: Response<Cat>): Cat {
		return when {
			res.isSuccessful -> {
				res.body() ?: throw OtherException()
			}
			res.code() == HttpURLConnection.HTTP_INTERNAL_ERROR -> {
				throw InternalErrorException()
			}
			else -> {
				throw OtherException()
			}
		}
	}
}