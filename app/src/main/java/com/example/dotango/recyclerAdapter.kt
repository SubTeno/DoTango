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


class recyclerAdapter(val context: Context,val heroes: Heroes): RecyclerView.Adapter<recyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val uri = "@drawable/${heroes.heroes.get(position).img}"
        val imageresource = context.resources.getIdentifier(uri, null, context.packageName)
        holder.heroImage.setImageResource(imageresource)
        holder.heroTitle.text = heroes.heroes.get(position).localizedName
        holder.layoutCard?.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("heroName", heroes.heroes.get(position).name)
            bundle.putInt("heroImgRes", imageresource)
        it.findNavController().navigate(R.id.action_heropage_to_herodetail, bundle)
        }
    }

    override fun getItemCount(): Int {
        return heroes.heroes.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val layoutCard: View? = itemView.findViewById(R.id.layoutCard)
        val heroImage: ImageView = itemView.findViewById(R.id.heropreviewimg)
        val heroTitle: TextView = itemView.findViewById(R.id.heropreviewtxt)
    }
}