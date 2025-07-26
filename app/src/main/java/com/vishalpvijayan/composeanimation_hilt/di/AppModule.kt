package com.vishalpvijayan.composeanimation_hilt.di

import com.vishalpvijayan.composeanimation_hilt.data.repository.ManualBuyEducationRepositoryImpl
import com.vishalpvijayan.composeanimation_hilt.domain.repository.ManualBuyEducationRepository
import com.vishalpvijayan.composeanimation_hilt.data.remote.ApiService
import com.vishalpvijayan.composeanimation_hilt.data.remote.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindManualBuyEducationRepository(
        impl: ManualBuyEducationRepositoryImpl
    ): ManualBuyEducationRepository
}

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.npoint.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideRemoteDataSource(apiService: ApiService) = RemoteDataSource(apiService)
}
