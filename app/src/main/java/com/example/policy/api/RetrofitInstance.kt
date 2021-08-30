package com.example.policy.api

import com.example.policy.fragments_and_activities.jwtToken
import com.example.policy.util.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
    var client = OkHttpClient.Builder()
        .addInterceptor {

            val newRequest = it.request().newBuilder()
                .addHeader("Cookie", "jwt="+ jwtToken)
                .build()
            it.proceed(newRequest)

        }
        .addInterceptor(interceptor)
        .build();

    val retrofit = Retrofit.Builder()
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(Constants.BASE_URL)
        .build()
    val userAPIService = retrofit.create(UserAPIService::class.java)
    val companyAPIService = retrofit.create(CompanyAPIService::class.java)


}