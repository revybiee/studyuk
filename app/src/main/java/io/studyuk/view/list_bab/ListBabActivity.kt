package io.studyuk.view.list_bab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.studyuk.R
import kotlinx.android.synthetic.main.activity_list_bab.*

class ListBabActivity : AppCompatActivity() {

    lateinit var babAdapter: BabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_bab)

        setUpView()
    }

    private fun setUpView(){
        val list = ArrayList<String>()
        list.add("Pertidaksamaan Linear")
        list.add("Sistem Persamaan Linear")
        list.add("Persamaan Garis Lurus")
        list.add("Persamaan Kuadrat")
        list.add("Fungsi Kuadrat")
        rv_bab.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        babAdapter = BabAdapter(this, list, "ListBab")
        rv_bab.adapter = babAdapter

        img_back.setOnClickListener {
            finish()
        }
    }
}
