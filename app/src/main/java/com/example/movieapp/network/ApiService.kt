package com.example.movieclone.network

import com.example.movieapp.model.ModelDetailMovie
import com.example.movieclone.constant.AppConstants
import com.example.movieclone.model.ModelMovie
import retrofit2.http.GET
import retrofit2.http.Query

/* 
Created by Muhammed Yusuf ÇİL 
Date : 2/18/2020
*/
interface ApiService{
    @GET("movie/top_rated?api_key=348de44a7486f8a17da47d853ea193f7")
    fun getTopRatedMovieListToHomeFragment():retrofit2.Call<ModelMovie>

    @GET("movie/now_playing?api_key=348de44a7486f8a17da47d853ea193f7")
    fun getNowPlayingMovieListToHomeFragment():retrofit2.Call<ModelMovie>

    @GET("movie/popular?api_key=348de44a7486f8a17da47d853ea193f7")
    fun getPopularMovieListToHomeFragment():retrofit2.Call<ModelMovie>
    
    @GET("tv/top_rated?api_key=348de44a7486f8a17da47d853ea193f7")
    fun getTelevisionTopRatedSeries():retrofit2.Call<ModelMovie>

    @GET("tv/popular?api_key=348de44a7486f8a17da47d853ea193f7")
    fun getTelevisionPopularSeries():retrofit2.Call<ModelMovie>

    @GET("movie/{movie_id}?api_key=348de44a7486f8a17da47d853ea193f7")
    fun getMovieAccordingToId(@Query("api_key")api_key : String=AppConstants.apiKey):retrofit2.Call<ModelDetailMovie>
}
