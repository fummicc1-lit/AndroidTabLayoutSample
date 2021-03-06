package dev.fummicc1.lit.androidtablayoutsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.fummicc1.lit.androidtablayoutsample.databinding.FragmentCollectionBinding

class CollectionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!isAdded) {
            return null
        }
        val binding = FragmentCollectionBinding.inflate(inflater, container, false)
        return binding.root
    }
}