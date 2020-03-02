package com.example.movieapp.ui.television

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
import com.example.movieapp.dto.TelevisionFragmentPopularSeriesDTO
import com.example.movieapp.dto.TelevisionFragmentTopRatedDTO
import com.example.movieclone.model.BaseModel
import com.example.movieclone.model.ModelMovie
import com.example.movieclone.network.RetrofitMovieFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelevisionFragment : Fragment() {

    //TopRatedSeries
    lateinit var recyclerAdapterTopRatedSeries: AppRecyclerViewAdapter
    lateinit var recyclerTopRatedSeries: RecyclerView

    //PopularSeries
    lateinit var recyclerAdapterPopularSeries:AppRecyclerViewAdapter
    lateinit var recyclerPopularSeries:RecyclerView

    private val topRatedList = mutableListOf<BaseModel>()
    private val popularSeriesList= mutableListOf<BaseModel>()

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var dashboardViewModel: TelevisionViewModel

    var recyclerViewClickListener = object : RecyclerViewClickListener {
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
        dashboardViewModel =
            ViewModelProviders.of(this).get(TelevisionViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_television, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getRecyclerViewAdapter()



        val apiServiceTopRated = RetrofitMovieFactory.createMovie().getTelevisionTopRatedSeries()
        apiServiceTopRated.enqueue(object : Callback<ModelMovie> {
            override fun onFailure(call: Call<ModelMovie>, t: Throwable) {
                Log.d("Başarısız", "Başarısız")
            }

            override fun onResponse(call: Call<ModelMovie>, response: Response<ModelMovie>) {
                Log.d("Başarılı", "Başarılı")
                response.body().let {
                    it!!.results.forEach {
                        var televisionTopRatedObject = TelevisionFragmentTopRatedDTO(
                            it.name,
                            it.poster_path
                        )
                        topRatedList.add(televisionTopRatedObject)
                    }
                recyclerAdapterTopRatedSeries.notifyDataSetChanged()
                }
            }
        })

        val apiServicePopular=RetrofitMovieFactory.createMovie().getTelevisionPopularSeries()
        apiServicePopular.enqueue(object : Callback<ModelMovie>{
            override fun onFailure(call: Call<ModelMovie>, t: Throwable) {
                Log.d("Başarısız","Başarısız")

            }

            override fun onResponse(call: Call<ModelMovie>, response: Response<ModelMovie>) {
                Log.d("Başarılı","Başarılı")
                response.body().let {
                    it!!.results.forEach {
                        var televisionPopularObject=TelevisionFragmentPopularSeriesDTO(
                            it.name,
                            it.poster_path,
                            it.vote_average
                        )
                        popularSeriesList.add(televisionPopularObject)
                    }
                    recyclerAdapterPopularSeries.notifyDataSetChanged()
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

        recyclerTopRatedSeries =
            view!!.findViewById(R.id.item_fragment_television_top_rated_recyclerView) as RecyclerView
        recyclerAdapterTopRatedSeries =
            AppRecyclerViewAdapter(topRatedList, recyclerViewClickListener)
        recyclerTopRatedSeries.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerTopRatedSeries.adapter=recyclerAdapterTopRatedSeries



        recyclerPopularSeries=view!!.findViewById(R.id.item_fragment_television_popular_recyclerView)
        recyclerAdapterPopularSeries=
            AppRecyclerViewAdapter(popularSeriesList,recyclerViewClickListener)
        recyclerPopularSeries.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerPopularSeries.adapter=recyclerAdapterPopularSeries
    }
}