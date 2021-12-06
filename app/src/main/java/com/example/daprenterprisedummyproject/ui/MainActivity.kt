package com.example.daprenterprisedummyproject.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.daprenterprisedummyproject.R
import com.example.daprenterprisedummyproject.ui.pojo.MovieList
import com.example.daprenterprisedummyproject.ui.pojo.Movies
import com.example.daprenterprisedummyproject.ui.service.APIClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val Movie_API_KEY = "b199eab06bc931ed71cd20c95e4b2bb3"
    private val Movie_id = 550

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // pushing in Github
        val coroutineScope =
            CoroutineScope(Dispatchers.Main)

        coroutineScope.launch(Dispatchers.Main) {
            serviceCall()
        }
    }


    fun serviceCall()
    {
        val networkService = APIClient.getService()
        val callx = networkService.getMovieDetailsX(Movie_id,Movie_API_KEY)
        callx.enqueue(object : Callback<MovieList> {
            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                Log.d("aaa", "Number of movies received: ")
                val statusCode = response.code()
                // val moviesx: List<Movies> = response.body()
                val moviesx = response.body()
                //?.movies
                //var n = moviesx?.get(0)
                var n = moviesx

                val coroutineScope =
                    CoroutineScope(Dispatchers.Main)

                coroutineScope.launch(Dispatchers.Main) {
                    /*    var movieDataBase: MovieDataBase? = null
                    var movieDao: MovieOrigDao? = null
                    movieDataBase = MovieDataBase.getDatabase(this@MainActivity)
                    movieDao = movieDataBase.movieAbs()
                    // pojoa = new pojo()
                    movieDao.insert(n)

                 */
                }


                //        recyclerView.adapter = MovieAdapter(
                //          moviesx, this@MainActivity
                //      )


            }

            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                Log.d("aaa", "Number of movies received: ")
            }

        })


    }

    }
