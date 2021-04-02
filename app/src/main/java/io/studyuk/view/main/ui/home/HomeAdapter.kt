package io.studyuk.view.main.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.studyuk.R
import io.studyuk.view.list_bab.ListBabActivity
import java.util.*
import kotlin.collections.ArrayList

class HomeAdapter(val context: Context, var list: ArrayList<String>, var activity: String) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (activity == "Home") {
            val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_new_course, parent, false)
            return ViewHolder(v)
        } else {
            val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_course, parent, false)
            return ViewHolder(v)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtTitle.text = list[position]
        if (list[position].toLowerCase(Locale.getDefault()).contains("ilmu pengetahuan alam")) {
            holder.imgItem.setImageResource(R.mipmap.science)
        } else if (list[position].toLowerCase(Locale.getDefault()).contains("matematika")) {
            holder.imgItem.setImageResource(R.mipmap.math)
        } else {
            holder.imgItem.setImageResource(R.mipmap.history)
        }

        holder.itemView.setOnClickListener {
//            context.startActivity(Intent(context, ListBabActivity::class.java))
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtTitle = itemView.findViewById<TextView>(R.id.tv_title)
        val txtCategory = itemView.findViewById<TextView>(R.id.tv_category)
        val imgItem = itemView.findViewById<ImageView>(R.id.img_course)
    }
}

