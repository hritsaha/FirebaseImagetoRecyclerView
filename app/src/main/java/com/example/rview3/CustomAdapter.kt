package com.example.rview3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CustomAdapter(val mList : List<ItemsViewModel>, private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val ImageView : ImageView = ItemView.findViewById(R.id.myimageview)
        val TextView : TextView = ItemView.findViewById(R.id.mytextview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.cardview,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
//        holder.ImageView.setImageResource(ItemsViewModel.image)
        Picasso.get().load(mList[position].userImage).into(holder.ImageView)
        holder.TextView.setText(ItemsViewModel.userName.toString())

        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClicked(position,ItemsViewModel.userImage)
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

}