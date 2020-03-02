package com.example.movieapp.dto

import com.example.movieclone.model.BaseModel

/* 
Created by Muhammed Yusuf ÇİL 
Date : 2/29/2020
*/
data class HomeFragmentPopularMovieListDTO(
    var vote_average:String,
    var title:String,
    var poster_path:String
):BaseModel {
    override val type: Int
        get() = BaseModel.TYPE_ITEM_FRAGMENT_HOME_MOVIE_POPULAR_LIST
}