package com.example.movieapp.dto

import com.example.movieclone.model.BaseModel

/* 
Created by Muhammed Yusuf ÇİL 
Date : 2/26/2020
*/
data class HomeFragmentTopRatedListMovieDTO(
    var backdrop_path: String,
    var id: Int
) : BaseModel {
    override val type: Int
        get() = BaseModel.TYPE_ITEM_FRAGMENT_HOME_MOVIE_TOP_RATED_LIST
}
