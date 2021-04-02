package io.studyuk.view.list_bab

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.studyuk.R
import io.studyuk.view.list_bab.list_sub_bab.ListSubBabActivity
import io.studyuk.view.list_bab.list_video.ListVideoActivity
import io.studyuk.view.practice.PracticeActivity

class BabAdapter(val context: Context, var list: ArrayList<String>, var activity: String): RecyclerView.Adapter<BabAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.tv_bab_title)

        fun bind(title: String){
            this.title.text = title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_bab, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            if (activity.contains("ListSubBab")) {
                if (list[position].contains("Latihan")) context.startActivity(Intent(context, PracticeActivity::class.java))
                else context.startActivity(Intent(context, ListVideoActivity::class.java))
            }
            else context.startActivity(Intent(context, ListSubBabActivity::class.java))
        }
    }
}