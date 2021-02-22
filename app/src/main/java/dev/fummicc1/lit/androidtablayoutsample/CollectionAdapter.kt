package dev.fummicc1.lit.androidtablayoutsample

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CollectionAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        val childFragment = ChildFragment()
        val articles: List<Article> =  when (position) {
            0 -> Constants.firstArticles
            1 -> Constants.secondArticles
            2 -> Constants.thirdArticles
            else -> listOf()
        }
        childFragment.configureArticles(articles)
        return childFragment
    }
}