package dev.fummicc1.lit.androidtablayoutsample

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kotlinx.coroutines.*
import okhttp3.Dispatcher

class RecyclerViewAdapter(val context: Context): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    val scope = CoroutineScope(Job() + Dispatchers.IO)

    private val articles: MutableList<Article> = mutableListOf()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.articleItemImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]

        scope.launch {
            val domAnalyzer: DomAnalyzerInterface = DomAnalyzer(article.url)

            Log.d("RecyclerViewAdapter", "domAnalyzer title: ${domAnalyzer.getTitle()}")
            Log.d("RecyclerViewAdapter", "domAnalyzer OGPImageUrl: ${domAnalyzer.getOGPImageUrl()}")

            withContext(Dispatchers.Main) {
                holder.imageView.load(domAnalyzer.getOGPImageUrl())
            }
        }
    }

    fun configureArticles(articles: List<Article>) {
        this.articles.clear()
        this.articles.addAll(articles)
        notifyDataSetChanged()
    }
}