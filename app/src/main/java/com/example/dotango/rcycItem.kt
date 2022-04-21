package com.example.dotango

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.lang.NullPointerException


class rcycItem(val context: Context, val items: Items): RecyclerView.Adapter<rcycItem.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Loading image
        Picasso.get().load("https://api.opendota.com${items.items.get(position).img}").into(holder.heroImage)

        holder.heroTitle.text = items.items.get(position).dname
        holder.layoutCard?.setOnClickListener {
            val bundle = Bundle()

                bundle.putString("itemName", items.items.get(position).dname)
                bundle.putStringArrayList("itemDesc", ArrayList<String>(items.items.get(position).hint))
                bundle.putInt("itemCost", items.items.get(position).cost)
                bundle.putString("itemImg", items.items.get(position).img)




            it.findNavController().navigate(R.id.action_itempage_to_itemdetail, bundle)
        }
    }

    override fun getItemCount(): Int {
        return items.items.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val layoutCard: View? = itemView.findViewById(R.id.layoutCard)
        val heroImage: ImageView = itemView.findViewById(R.id.heropreviewimg)
        val heroTitle: TextView = itemView.findViewById(R.id.heropreviewtxt)
    }
}