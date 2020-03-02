package com.example.movieapp.dto

import com.example.movieclone.model.BaseModel
import com.example.movieclone.model.BaseModel.Companion.TYPE_ITEM_FRAGMENT_TELEVISION_POPULAR_SERIESLIST

/* 
Created by Muhammed Yusuf ÇİL 
Date : 2/29/2020
*/
data class TelevisionFragmentPopularSeriesDTO (
    var name:String,
    var backdrop_path:String,
    var vote_average:String
):BaseModel {
    override val type: Int
        get() = TYPE_ITEM_FRAGMENT_TELEVISION_POPULAR_SERIESLIST
}