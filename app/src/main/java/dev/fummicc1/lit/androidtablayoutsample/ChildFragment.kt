package dev.fummicc1.lit.androidtablayoutsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.fummicc1.lit.androidtablayoutsample.databinding.FragmentChildBinding

class ChildFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentChildBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}