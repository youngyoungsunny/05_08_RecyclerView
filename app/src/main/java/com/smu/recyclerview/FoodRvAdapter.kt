package com.smu.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class FoodRvAdapter(val context: Context, val foodList : ArrayList<Food> ):
        RecyclerView.Adapter<FoodRvAdapter.Holder>(){
    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(foodList[position],context) //food 몇번째를 이 view에 씌우겠다는 역할임.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int): Holder {
        val view = LayoutInflater.from(context).inflate(    //레이아웃 인플레이터뷰를 가져오는 역할.//context는 부모가 접근할 수 있게끔 //
            R.layout.item_food,parent,false
        )
        return Holder(view)
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val foodImage: ImageView = itemView.findViewById<ImageView>(R.id.iv_food)
        val foodName: TextView = itemView.findViewById<TextView>(R.id.tv_name)

        fun bind(food : Food, context: Context){

            if(food.image != ""){   //이미지를 준 경우
                val resourceId = context.resources
                    .getIdentifier(food.image,"drawable",context.packageName)

                foodImage.setImageResource(resourceId)
            }
            else
                foodImage.setImageResource(R.mipmap.ic_launcher)    //이미지를 안 준경우, 이미지를 이걸로 넣어라.

            foodName.text = food.name //text는 NULL받아도 상관 없음. 근데 이미지는 NULL받으면 안됨.
        }

    }


}