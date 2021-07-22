package com.example.demoappfornewjoiner.network

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
	private val BASE_URL = "https://thatcopy.pw/"

	@Provides
	fun provideInterceptor(): OkHttpClient = OkHttpClient.Builder()
			.addInterceptor(HttpLoggingInterceptor().apply {
				level = HttpLoggingInterceptor.Level.BODY
			})
			.build()

	@Provides
	fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			.client(client)
			.build()
}