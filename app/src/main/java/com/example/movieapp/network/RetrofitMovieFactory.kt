package com.example.movieclone.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/* 
Created by Muhammed Yusuf ÇİL 
Date : 2/18/2020
*/

class RetrofitMovieFactory {
    companion object{
        var BASE_URL="https://api.themoviedb.org/3/"
        fun createMovie(): ApiService {
            val logging = HttpLoggingInterceptor()
            logging.apply { logging.level = HttpLoggingInterceptor.Level.BODY }
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            val retrofit=Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}