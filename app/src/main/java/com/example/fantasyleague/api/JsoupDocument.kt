package com.example.fantasyleague.api

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

object JsoupDocument {

    private const val BASE_URL = "https://www.espncricinfo.com/scores"

    val builder: Document by lazy {
        Jsoup.connect(BASE_URL)
            .get()
    }
}
