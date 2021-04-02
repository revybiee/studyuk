package io.studyuk.view.main.ui.course

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import io.studyuk.R
import io.studyuk.view.main.ui.home.HomeAdapter
import kotlinx.android.synthetic.main.courses_fragment.view.*

class CoursesFragment : Fragment() {

    companion object {
        fun newInstance() = CoursesFragment()
    }

    private lateinit var viewModel: CoursesViewModel
    lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.courses_fragment, container, false)

        val list = ArrayList<String>()
        list.add("Ilmu Pengetahuan Alam")
        list.add("Matematika")
        list.add("Sejarah Indonesia")
        root.rv_courses.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        homeAdapter = HomeAdapter(context!!, list, "Course")
        root.rv_courses.adapter = homeAdapter

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CoursesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
