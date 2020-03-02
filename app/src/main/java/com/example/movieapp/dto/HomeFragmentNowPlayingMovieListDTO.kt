package com.example.movieapp.dto

import com.example.movieclone.model.BaseModel

/* 
Created by Muhammed Yusuf ÇİL 
Date : 2/27/2020
*/
data class HomeFragmentNowPlayingMovieListDTO(
    var poster_path: String,
    var title:String
) : BaseModel {
    override val type: Int
        get() = BaseModel.TYPE_ITEM_FRAGMENT_HOME_MOVIE_NOW_PLAYING
}