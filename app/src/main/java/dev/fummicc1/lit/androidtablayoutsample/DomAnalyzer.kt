package dev.fummicc1.lit.androidtablayoutsample

import android.util.Log
import org.jsoup.Jsoup
import java.lang.IllegalArgumentException

class DomAnalyzer(val url: String): DomAnalyzerInterface {

    val document = Jsoup.connect(url).get()

    override fun getTitle(): String {
        return document.title()
    }

    override fun getOGPImageUrl(): String {
        val metaTag = document.head().getElementsByTag("meta")
        metaTag.forEach { tag ->
            Log.d("DomAnalyzer", "metatag: ${tag.data()}")
        }
        val image = metaTag
            .filter {
            if (it.hasAttr("property").not()) {
                return@filter false
            }
            val propertyValue = it.attr("property")
            return@filter propertyValue.contains("og:image")
        }.firstOrNull()
        if (image == null) {
            throw IllegalArgumentException()
        }
        val imageUrl = image.attr("content")
        return imageUrl
    }

}