package kr.edcan.retrofitpractice

import com.squareup.moshi.Json
import retrofit2.http.Query

data class Meal(
    val date : Int,
    val breakfast : List<String>,
    val lunch : List<String>,
    val dinner : List<String>,
)

data class MealApiResult(
    @Json(name="server_message")
    val server_message : List<String>,
    val menu : List<Meal>
)
