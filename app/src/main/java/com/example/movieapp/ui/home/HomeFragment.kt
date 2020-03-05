package com.example.movieapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.adapter.AppRecyclerViewAdapter
import com.example.movieapp.adapter.RecyclerViewClickListener
import com.example.movieapp.dto.HomeFragmentNowPlayingMovieListDTO
import com.example.movieapp.dto.HomeFragmentPopularMovieListDTO
import com.example.movieapp.dto.HomeFragmentTopRatedListMovieDTO
import com.example.movieclone.model.BaseModel
import com.example.movieclone.model.ModelMovie
import com.example.movieclone.network.RetrofitMovieFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    //TopRated Adapter and recyclerview
    lateinit var recyclerAdapterTopRatedMovies: AppRecyclerViewAdapter
    lateinit var recyclerViewTopRatedMovies: RecyclerView

    //NowPlaying Adapter and RecyclerView
    lateinit var recyclerAdapterNowPlaying: AppRecyclerViewAdapter
    lateinit var recyclerViewNowPlayingMovies: RecyclerView

    //Popular Adapter and RecyclerView
    lateinit var recyclerViewAdapterPopular: AppRecyclerViewAdapter
    lateinit var recyclerViewPopularMovies: RecyclerView


    private val topRatedList = mutableListOf<BaseModel>()
    private val nowPlayingList = mutableListOf<BaseModel>()
    private val popularList = mutableListOf<BaseModel>()
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var homeViewModel: HomeViewModel

    var recyclerViewItemClickListener = object : RecyclerViewClickListener {
        override fun onClickListener(position: Int, model: BaseModel) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onLongClickListener(position: Int, model: BaseModel) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apiServiceTopRated = RetrofitMovieFactory.createMovie().getTopRatedMovieListToHomeFragment()
        getRecyclerViewAdapter()
        apiServiceTopRated.enqueue(object : Callback<ModelMovie> {
            override fun onFailure(call: Call<ModelMovie>, t: Throwable) {
                Log.d("Başarısız", "başarısız")
            }

            override fun onResponse(call: Call<ModelMovie>, response: Response<ModelMovie>) {
                Log.d("Başarılı", "başarılı")
                response.body()?.let {
                    it.results.forEach {
                        var topRatedListObject = HomeFragmentTopRatedListMovieDTO(
                            it.backdrop_path
                        )
                        topRatedList.add(topRatedListObject)
                    }
                    recyclerAdapterTopRatedMovies.notifyDataSetChanged()
                }
            }
        })
        val apiServiceNowPlaying = RetrofitMovieFactory.createMovie().getNowPlayingMovieListToHomeFragment()
        apiServiceNowPlaying.enqueue(object : Callback<ModelMovie> {
            override fun onFailure(call: Call<ModelMovie>, t: Throwable) {
                Log.d("Başarısız", "Başarısız")
            }

            override fun onResponse(call: Call<ModelMovie>, response: Response<ModelMovie>) {
                Log.d("Başarılı", "Başarılı")
                response.body()?.let {
                    it.results.forEach {
                        var nowplayingObject = HomeFragmentNowPlayingMovieListDTO(
                            it.poster_path,
                            it.title,
                            it.id
                        )
                        nowPlayingList.add(nowplayingObject)
                    }
                    recyclerAdapterNowPlaying.notifyDataSetChanged()
                }
            }
        })
        val apiServicePopularMovies = RetrofitMovieFactory.createMovie().getPopularMovieListToHomeFragment()
        apiServicePopularMovies.enqueue(object : Callback<ModelMovie> {
            override fun onFailure(call: Call<ModelMovie>, t: Throwable) {
                Log.d("Başarısız", "Başarısız")
            }

            override fun onResponse(call: Call<ModelMovie>, response: Response<ModelMovie>) {
                Log.d("Başarılı", "Başarılı")
                response.body().let {
                    it!!.results.forEach {
                        var popularMovieObject=HomeFragmentPopularMovieListDTO(
                            it.vote_average,
                            it.title,
                            it.poster_path
                        )
                        popularList.add(popularMovieObject)
                    }
                    recyclerViewAdapterPopular.notifyDataSetChanged()
                }
            }
        })
    }

    private fun getRecyclerViewAdapter() {
        linearLayoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        //TOP RATED MOVİES RECYCLERVİEW
        recyclerViewTopRatedMovies =
            view!!.findViewById(R.id.fragment_home_top_rated_movie_list_recyclerView)
        recyclerAdapterTopRatedMovies =
            AppRecyclerViewAdapter(topRatedList, recyclerViewItemClickListener)
        recyclerViewTopRatedMovies.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerViewTopRatedMovies.adapter = recyclerAdapterTopRatedMovies


        //NOW PLAYING MOVIES SLIDER RECYCLER VIEW
        recyclerViewNowPlayingMovies =
            view!!.findViewById(R.id.fragment_home_now_playing_movie_list_recyclerView)
        recyclerAdapterNowPlaying =
            AppRecyclerViewAdapter(nowPlayingList, recyclerViewItemClickListener)
        recyclerViewNowPlayingMovies.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerViewNowPlayingMovies.adapter = recyclerAdapterNowPlaying


        //POPULAR MOVİES RECYCLERVİEW
        recyclerViewPopularMovies =
            view!!.findViewById(R.id.fragment_home_popular_movie_list_recyclerView)
        recyclerViewAdapterPopular =
            AppRecyclerViewAdapter(popularList, recyclerViewItemClickListener)
        recyclerViewPopularMovies.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerViewPopularMovies.adapter = recyclerViewAdapterPopular
    }
}