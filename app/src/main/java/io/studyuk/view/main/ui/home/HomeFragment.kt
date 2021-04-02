package io.studyuk.view.main.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.studyuk.R
import io.studyuk.view.main.MainActivity
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    lateinit var homeAdapter: HomeAdapter

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val sharedPreference =  context!!.getSharedPreferences("Study", Context.MODE_PRIVATE)
        root.txt_name.text = "Hai, ${sharedPreference.getString("name", "")} :)"

        val list = ArrayList<String>()
        list.add("Ilmu Pengetahuan Alam")
        list.add("Matematika")
        list.add("Sejarah Indonesia")
        root.rv_new_courses.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        homeAdapter = HomeAdapter(context!!, list, "Home")
        root.rv_new_courses.adapter = homeAdapter

        return root
    }
}
