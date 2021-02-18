package com.example.turismochile.model.remote

import retrofit2.Retrofit

class RetrofitInstance {

    companion object{
        private const val BASE_URL = "http://demo4470264.mockable.io/"

        fun retrofitInstance(): ApiInterface{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}