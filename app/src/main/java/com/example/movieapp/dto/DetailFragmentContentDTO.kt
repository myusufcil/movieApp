package com.example.movieapp.dto

import com.example.movieapp.model.Genres
import com.example.movieclone.model.BaseModel

/* 
Created by Muhammed Yusuf ÇİL 
Date : 3/4/2020
*/
data class DetailFragmentContentDTO(
    var backdrop_path:String,
    var poster_path:String,
    var title:String,
    var overview:String,
    var vote_average:Float,
    var name:List<Genres>
):BaseModel {
    override val type: Int
        get() = BaseModel.TYPE_ITEM_FRAGMENT_DETAIL_CONTENT
}