package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.dto.DetailFragmentContentDTO
import com.example.movieapp.viewholder.*
import com.example.movieclone.model.BaseModel
import java.lang.IllegalArgumentException

/* 
Created by Muhammed Yusuf ÇİL 
Date : 2/26/2020
*/
class AppRecyclerViewAdapter(
    var items: MutableList<BaseModel>,
    var recyclerViewClickListener: RecyclerViewClickListener
) : RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            BaseModel.TYPE_ITEM_FRAGMENT_HOME_MOVIE_TOP_RATED_LIST ->{
                HomeTopRatedViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_fragment_home_top_rated_slider,
                        parent,
                        false
                    )
                )
            }
            BaseModel.TYPE_ITEM_FRAGMENT_HOME_MOVIE_NOW_PLAYING->
                HomeNowPlayingViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_fragment_home_now_playing_slider,
                        parent,
                        false
                    )
                )
            BaseModel.TYPE_ITEM_FRAGMENT_HOME_MOVIE_POPULAR_LIST->
                HomePopularMoviesViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_fragment_home_popular_slider,
                        parent,
                        false
                    )
                )
            BaseModel.TYPE_ITEM_FRAGMENT_TELEVISION_TOP_RATED_LIST->
               TelevisionTopRatedViewHolder(
                   layoutInflater.inflate(
                       R.layout.item_fragment_television_top_rated_slider,
                       parent,
                       false
                   )
               )
            BaseModel.TYPE_ITEM_FRAGMENT_TELEVISION_POPULAR_SERIESLIST->
                TelevisionPopularViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_fragment_television_popular_slider,
                        parent,
                        false
                    )
                )
            BaseModel.TYPE_ITEM_FRAGMENT_DETAIL_CONTENT->
                FragmentMovieDetailViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_frament_movie_detail,
                        parent,
                        false
                    )
                )

            else ->
                throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount()=items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when(items[position].type)
        {
            BaseModel.TYPE_ITEM_FRAGMENT_HOME_MOVIE_TOP_RATED_LIST->
                (holder as HomeTopRatedViewHolder).bindView(items[position],position,recyclerViewClickListener)
            BaseModel.TYPE_ITEM_FRAGMENT_HOME_MOVIE_NOW_PLAYING->
                (holder as HomeNowPlayingViewHolder).bindView(items[position],position,recyclerViewClickListener)
            BaseModel.TYPE_ITEM_FRAGMENT_HOME_MOVIE_POPULAR_LIST->
                (holder as HomePopularMoviesViewHolder).bindView(items[position],position,recyclerViewClickListener)
            BaseModel.TYPE_ITEM_FRAGMENT_TELEVISION_TOP_RATED_LIST->
                (holder as TelevisionTopRatedViewHolder).bindView(items[position],position,recyclerViewClickListener)
            BaseModel.TYPE_ITEM_FRAGMENT_TELEVISION_POPULAR_SERIESLIST->
                (holder as TelevisionPopularViewHolder).bindView(items[position],position,recyclerViewClickListener)
            BaseModel.TYPE_ITEM_FRAGMENT_DETAIL_CONTENT->
                (holder as FragmentMovieDetailViewHolder).bindView(items[position],position,recyclerViewClickListener)
        }
    }
    override fun getItemViewType(position: Int): Int { //  !!!Burayı sor!!!
        return items[position].type
    }
}