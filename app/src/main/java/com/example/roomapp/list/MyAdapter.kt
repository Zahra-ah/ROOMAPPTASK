package com.example.roomapp.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.User
import com.example.roomapp.R

class MyAdapter():
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var itemList = emptyList<User>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.objectrow,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.itemView.findViewById<TextView>(R.id.text1).text= currentItem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.text2).text= currentItem.firstName
        holder.itemView.findViewById<TextView>(R.id.text3).text= currentItem.course
        holder.itemView.findViewById<TextView>(R.id.text4).text= currentItem.age.toString()

        holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout).setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
    fun setData(user : List<User>)
    {
        this.itemList = user
        notifyDataSetChanged()
    }
}


