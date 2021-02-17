package com.workindia.api


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiClient {

    private var retrofit: Retrofit? = null


    val client: Retrofit?
        get() {
            if (retrofit == null) {

                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                val client = OkHttpClient.Builder().addInterceptor { chain ->
                    val newRequest = chain.request().newBuilder().build()
                    chain.proceed(newRequest)
                }.readTimeout(30, TimeUnit.SECONDS).connectTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(interceptor).build()

                retrofit = Retrofit.Builder()
                    .baseUrl("https://run.mocky.io/v3/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit;
        }

}



