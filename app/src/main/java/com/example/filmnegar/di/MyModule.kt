package com.example.filmnegar.di

import android.content.Context
import androidx.room.Room
import com.example.filmnegar.model.db.AppDatabase
import com.example.filmnegar.model.db.MovieDao
import com.example.filmnegar.model.net.ApiService
import com.example.filmnegar.model.repoaitory.RepositoryImpl
import com.example.filmnegar.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MyModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDao(appDatabase: AppDatabase): MovieDao = appDatabase.movieDao()

    fun provideRoomDatabase(@ApplicationContext context: Context) : AppDatabase{
        return Room.databaseBuilder(context, AppDatabase::class.java, "my_db").build()
    }

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService,) = RepositoryImpl(apiService)





}