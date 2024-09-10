
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapp.R
import com.example.roomapptask.LanguageData

import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val itemList:ArrayList<LanguageData>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val curr=itemList[position]
        holder.titleImage.setImageResource(curr.tittleImage)
        holder.TvHeading.text=curr.Heading
        holder.ins.text=curr.instructor
        holder.price.text=curr.price
        holder.hour.text=curr.hours.toString()


    }

    override fun getItemCount(): Int {
        return itemList.size    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleImage:ShapeableImageView=itemView.findViewById(R.id.tittleImage)
        val TvHeading:TextView=itemView.findViewById(R.id.Language)
        val ins :TextView=itemView.findViewById(R.id.Instructor)
        val price:TextView=itemView.findViewById(R.id.price)
        val hour:TextView=itemView.findViewById(R.id.hours)
    }
}