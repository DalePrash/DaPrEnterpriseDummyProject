package com.example.daprenterprisedummyproject.ui.service

import com.example.daprenterprisedummyproject.ui.pojo.MovieList
import com.example.daprenterprisedummyproject.ui.pojo.Movies
import com.example.daprenterprisedummyproject.ui.pojo.User
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIClient {
    @GET("top_rated?api_key=b199eab06bc931ed71cd20c95e4b2bb3")
    fun getMoviesB(): Single<User>
//fun getMovies1(@Query("page") page: Int, @Query("pageSize") pageSize: Int): Single<com.example.pagingtmdbdapr.pojo.MovieList>

    @GET("top_rated?api_key=b199eab06bc931ed71cd20c95e4b2bb3")
    fun getMoviesD(): Call<MovieList>


    @GET("api/")
    fun getMoviesC(
        @Query("page") page: Int,
        @Query("pageSize") key: String = "b199eab06bc931ed71cd20c95e4b2bb3"
    ): Response<MovieList>

    //  20045329-0613298a4e814661c692a9f03  Photo APi
// b199eab06bc931ed71cd20c95e4b2bb3  moviemdb


    /*   @GET("movie/top_rated")
    Call<MovieList> getTopRatedMoviesX(@Query("api_key") String apiKey);

 @GET("top_rated?api_key=b199eab06bc931ed71cd20c95e4b2bb3")
    fun getMovies( ): Single<User>


@GET("movie/{id}")
    Call<MovieList> getMovieDetailsX(@Path("id") int id, @Query("api_key") String apiKey);


  */
    @GET("movie/top_rated")
    fun getTopRatedMoviesX(@Query("api_key") apiKey: String): Call<MovieList>

    //Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
 //   @GET("movie/550?api_key=b199eab06bc931ed71cd20c95e4b2bb3")
   // fun getMovieDetailsX(): Call<MovieList>

 //   fun getMovieDetailsX(@Path("id") id: Int, @Query("api_key") apiKey: String): Call<MovieList>

      @GET("movie/{id}")
  fun getMovieDetailsX(@Path("id") id: Int, @Query("api_key") apiKey: String): Call<MovieList>

      //https://api.themoviedb.org/3/movie/550?api_key=b199eab06bc931ed71cd20c95e4b2bb3





    companion object {
        public fun getService(): APIClient {
          //  val BASE_URL = "http://api.themoviedb.org/3/"
            val BASE_URL = "https://api.themoviedb.org/3/"

// whats BaseUrl here? "https://api.themoviedb.org/3/movie/"

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(APIClient::class.java)
        }

    }
}