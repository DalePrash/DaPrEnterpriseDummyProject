package com.example.newspagingdapr.photopagethree


import com.example.daprenterprisedummyproject.ui.pojo.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
interface ApiInterPhoto {
    @GET("api/")
    fun getNewsXx(
        @Query("page")page: Int,
        @Query("pageSize")key: String
    ): Response<User>
//        @Query("pageSize")key: String="20045329-0613298a4e814661c692a9f03"
    companion object{
        fun getXAPi()
            = Retrofit.Builder()
                .baseUrl("https://pixabay.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            .create(ApiInterPhoto.javaClass)

        }

    }
//  https://pixabay.com/api/?page=2&key=20045329-0613298a4e814661c692a9f03
