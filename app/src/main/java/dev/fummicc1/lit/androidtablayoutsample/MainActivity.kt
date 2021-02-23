package dev.fummicc1.lit.androidtablayoutsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import dev.fummicc1.lit.androidtablayoutsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        title = "AndroidTabLayoutSample"

        val collectionFragment = supportFragmentManager.findFragmentById(R.id.fragment2) as CollectionFragment
        binding.viewPager.adapter = CollectionAdapter(collectionFragment)

        // TabLayoutとViewPager2のリンク
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = "Tab ${position}"
        }.attach()
    }
}