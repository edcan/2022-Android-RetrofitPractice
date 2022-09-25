package kr.edcan.retrofitpractice

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MealListViewHolder(val row : View) : RecyclerView.ViewHolder(row) {
    val txtDate = row.findViewById<TextView>(R.id.txt_mealItem_date)
    val txtMenu = row.findViewById<TextView>(R.id.txt_mealItem_menu)

    fun onBind(mealData: Meal) {
        txtDate.text = "${mealData.date}일"
        txtMenu.text = if(mealData.lunch.isEmpty()) "급식이 없습니다." else mealData.lunch.toString()
    }

    init {
        // 급식 리스트 클릭하면 해당 급식을 공유하는 기능
        row.setOnClickListener {
            val intent = Intent()
        }
    }
}