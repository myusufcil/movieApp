package com.example.movieapp.ui.detail


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.adapter.AppRecyclerViewAdapter
import com.example.movieapp.adapter.RecyclerViewClickListener
import com.example.movieapp.dto.DetailFragmentContentDTO
import com.example.movieapp.model.ModelDetailMovie
import com.example.movieclone.model.BaseModel
import com.example.movieclone.network.RetrofitMovieFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    lateinit var recyclerAdapterDetailMovie: AppRecyclerViewAdapter
    lateinit var recyclerViewDetailMovie: RecyclerView

    private val detailMovieList = mutableListOf<BaseModel>()
    private lateinit var linearLayoutManager: LinearLayoutManager

    var recyclerViewItemClickListener=object:RecyclerViewClickListener{
        override fun onClickListener(position: Int, model: BaseModel) {
            TODO()
        }

        override fun onLongClickListener(position: Int, model: BaseModel) {
            TODO()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    var MovieId: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var bundle = this.arguments
        recyclerViewDetailMovie =
            view.findViewById(R.id.recyclerView_fragment_detail) as RecyclerView
        recyclerAdapterDetailMovie=AppRecyclerViewAdapter(detailMovieList,recyclerViewClickListener = recyclerViewItemClickListener)
        recyclerViewDetailMovie.layoutManager=LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerViewDetailMovie.adapter=recyclerAdapterDetailMovie

        linearLayoutManager = LinearLayoutManager(context)

        arguments?.let {
            if (it.getInt("id") != null) {
                MovieId = it.getInt("id", 0)
            }
        }

        var getMovieAccordingToId =
            RetrofitMovieFactory.createMovie().getMovieAccordingToId(MovieId)

        getMovieAccordingToId.enqueue(object : Callback<ModelDetailMovie> {
            override fun onFailure(call: Call<ModelDetailMovie>, t: Throwable) {
                Log.d("Başarısız", "Başarısız")
            }

            override fun onResponse(
                call: Call<ModelDetailMovie>,
                response: Response<ModelDetailMovie>
            ) {
                Log.d("Başarılı", "Başarılı")
                response.body().let {
                    var detailMovieObject = DetailFragmentContentDTO(
                        backdrop_path = it!!.backdrop_path,
                        poster_path = it.poster_path,
                        title = it.title,
                        overview = it.overview,
                        vote_average = it.vote_average,
                        name = it.genres.name
                    )
                    detailMovieList.add(detailMovieObject)
                    recyclerAdapterDetailMovie.notifyDataSetChanged()
                }
            }
        })
    }
}
