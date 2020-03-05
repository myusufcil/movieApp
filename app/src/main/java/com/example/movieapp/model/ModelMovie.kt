package com.example.movieclone.model

/* 
Created by Muhammed Yusuf ÇİL 
Date : 2/18/2020
*/
data class ModelMovie(
    var results: List<Results>
)

data class Results(
    var backdrop_path: String,
    var poster_path: String,
    var title: String,
    var vote_average:String,
    var name:String,//tv
    var id:Int
)