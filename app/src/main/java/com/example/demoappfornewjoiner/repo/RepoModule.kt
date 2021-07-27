package com.example.demoappfornewjoiner.repo

import com.example.demoappfornewjoiner.model.Cat
import dagger.Module
import dagger.Provides
import io.reactivex.functions.Function
import retrofit2.Response
import retrofit2.Retrofit

@Module
class RepoModule {
	@Provides
	fun provideService(retrofit: Retrofit): Service = retrofit.create(Service::class.java)

	@Provides
	fun provideRepo(repositoryImp: RepositoryImp): Repository = repositoryImp

	@Provides
	fun provideMapper(mapper: CatMapper): Function<Response<Cat>, Cat> = mapper
}