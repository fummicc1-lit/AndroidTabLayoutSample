package dev.fummicc1.lit.androidtablayoutsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import dev.fummicc1.lit.androidtablayoutsample.databinding.FragmentChildBinding

class ChildFragment : Fragment() {

    private val itemStream: MutableLiveData<List<Article>> = MutableLiveData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentChildBinding.inflate(layoutInflater, container, false)
        binding.apply {
            val adapter = RecyclerViewAdapter(requireContext())
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
            recyclerView.adapter = adapter

            itemStream.observe(viewLifecycleOwner, Observer {
                adapter.configureArticles(it)
            })
        }
        return binding.root
    }

    fun configureArticles(articles: List<Article>) {
        itemStream.postValue(articles)
    }
}