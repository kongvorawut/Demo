package com.example.demoappfornewjoiner.repo

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RepoModule {
	@Provides
	fun provideService(retrofit: Retrofit): Service = retrofit.create(Service::class.java)

	@Provides
	fun provideRepo(repositoryImp: RepositoryImp): Repository = repositoryImp
}