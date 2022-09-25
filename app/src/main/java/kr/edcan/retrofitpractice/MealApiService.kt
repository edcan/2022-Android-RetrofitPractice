package kr.edcan.retrofitpractice

import retrofit2.http.GET

interface MealApiService {
    @GET("api/middle/B100000658?allergy=hidden")
    suspend fun getMeal() : MealApiResult
}