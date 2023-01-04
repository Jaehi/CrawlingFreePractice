package com.example.crawlingmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        CoroutineScope(Dispatchers.IO).launch {
            val url = "https://movie.naver.com/movie/sdb/rank/rmovie.naver"
            val doc = Jsoup.connect(url).get()
            val ele = doc.select("table[class=list_ranking]").select("tbody").select("tr").select("td[class=title]").select("div[class=tit3]").select("a")

            ele.forEach{
                Log.d("crawling Title","${it.attr("title")}")

                Log.d("crawling Herf","${it.attr("href").split("=")[1]}")
            }
        }

    }
}