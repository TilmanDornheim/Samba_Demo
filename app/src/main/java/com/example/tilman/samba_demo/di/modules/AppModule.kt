package com.example.tilman.samba_demo.di.modules

import android.annotation.SuppressLint
import android.app.Application
import android.support.v4.app.FragmentManager
import com.example.tilman.samba_demo.R
import com.example.tilman.samba_demo.data.api.MockApi
import com.example.tilman.samba_demo.data.repos.PartyRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Singleton

@Module
class AppModule(private val app: Application){


    @Singleton
    @Provides
    fun provideApplication() = app


    @Singleton
    @Provides
    fun provideGson(): Gson{

        return GsonBuilder().create()

    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {

        return OkHttpClient.Builder().build()


    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit{

        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .baseUrl(app.getString(R.string.api_base_url))
                .build()

    }


    @Singleton
    @Provides
    fun provideMockApiService(retrofit: Retrofit): MockApi{

        return retrofit.create(MockApi::class.java)

    }

    @Singleton
    @Provides
    fun providePartyRepository(mockApiService: MockApi): PartyRepository{

        return PartyRepository(mockApiService)

    }

    @SuppressLint("SimpleDateFormat")
    @Singleton
    @Provides
    fun provideDateFormat(): SimpleDateFormat{

        return SimpleDateFormat("yyyy-MM-dd")

    }







}