package com.example.sibsutisschedule.di

import com.example.sibsutisschedule.data.ScheduleRepository
import com.example.sibsutisschedule.data.ScheduleServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://sibsutis.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideScheduleService(retrofit: Retrofit) : ScheduleServices {
        return retrofit.create(ScheduleServices::class.java)
    }

    @Provides
    @Singleton
    fun providesScheduleRepository(service : ScheduleServices) : ScheduleRepository {
        return ScheduleRepository(service)
    }

    // todo: room provide
}