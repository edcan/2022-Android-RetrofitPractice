package kr.edcan.retrofitpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MealListAdapter(val items : List<Meal>) : RecyclerView.Adapter<MealListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_meal_list_item, parent, false)

        return MealListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealListViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}