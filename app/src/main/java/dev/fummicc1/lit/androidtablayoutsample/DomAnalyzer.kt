package dev.fummicc1.lit.androidtablayoutsample

import org.jsoup.Jsoup
import java.lang.IllegalArgumentException

class DomAnalyzer(val url: String): DomAnalyzerInterface {

    val document = Jsoup.connect(url).get()

    override fun getTitle(): String {
        return document.title()
    }

    override fun getOGPImageUrl(): String {
        val metaTag = document.head().getElementsByTag("meta")
        val image = metaTag.filter {
            if (it.hasAttr("property").not()) {
                return@filter false
            }
            val contentValue = it.attr("content")
            return@filter contentValue.contains("og:image")
        }.firstOrNull()
        if (image == null) {
            throw IllegalArgumentException()
        }
        var imageUrl = image.attr("content")
        imageUrl = imageUrl.replace("og:image", "")
        return imageUrl
    }

}