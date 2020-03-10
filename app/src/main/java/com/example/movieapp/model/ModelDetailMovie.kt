package com.example.movieapp.model

/* 
Created by Muhammed Yusuf ÇİL 
Date : 3/4/2020
*/
data class ModelDetailMovie(
    var backdrop_path:String,
    var poster_path:String,
    var title:String,
    var overview:String,
    var vote_average:Float,
    var genres:Genres
)
data class Genres(
    var name:String
)