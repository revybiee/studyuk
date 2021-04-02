package io.studyuk.view.list_bab.list_sub_bab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.studyuk.R
import io.studyuk.view.list_bab.BabAdapter
import kotlinx.android.synthetic.main.activity_list_sub_bab.*

class ListSubBabActivity : AppCompatActivity() {

    lateinit var babAdapter: BabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_sub_bab)

        setUpView()
    }

    private fun setUpView(){
        val list = ArrayList<String>()
        list.add("Sistem Persamaan Linear Dua Variabel (SPLDV)")
        list.add("Metode grafik")
        list.add("Metode eliminasi")
        list.add("Metode substitusi")
        list.add("Sistem Persamaan Linear Tiga Variabel (SPLTV)")
        list.add("Latihan Soal")
        rv_sub_bab.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        babAdapter = BabAdapter(this, list, "ListSubBab")
        rv_sub_bab.adapter = babAdapter

        img_back.setOnClickListener {
            finish()
        }
    }
}
