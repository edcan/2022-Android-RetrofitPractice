package kr.edcan.retrofitpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class MainActivity : AppCompatActivity() {
    val BASE_URL = "https://schoolmenukr.ml"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()

        val mealApiService = retrofit.create(MealApiService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val result = mealApiService.getMeal()

            withContext(Dispatchers.Main) {
                val adapter = MealListAdapter(result.menu)
                findViewById<RecyclerView>(R.id.recycler_main_mealList).adapter = adapter
                findViewById<RecyclerView>(R.id.recycler_main_mealList).layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}