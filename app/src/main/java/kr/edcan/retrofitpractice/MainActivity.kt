package kr.edcan.retrofitpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class MainActivity : AppCompatActivity() {
    val BASE_URL = "https://schoolmenukr.ml"
    val API_KEY = "6b56737c3eba4001bb5214d0df9b92b0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        val mealApiService = retrofit.create(MealApiService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val result = mealApiService.getMeal()

            withContext(Dispatchers.Main) {
                findViewById<TextView>(R.id.txt_main_mealData).text = result
            }
        }
    }
}