package com.example.movieclone.model

/* 
Created by Muhammed Yusuf ÇİL 
Date : 2/18/2020
*/
interface BaseModel{
    val type :Int

    companion object{
        const val TYPE_ITEM_FRAGMENT_HOME_MOVIE_TOP_RATED_LIST=1
        const val TYPE_ITEM_FRAGMENT_HOME_MOVIE_NOW_PLAYING=2
        const val TYPE_ITEM_FRAGMENT_HOME_MOVIE_POPULAR_LIST=3
        const val TYPE_ITEM_FRAGMENT_TELEVISION_TOP_RATED_LIST=4
        const val TYPE_ITEM_FRAGMENT_TELEVISION_POPULAR_SERIESLIST=5
    }
}