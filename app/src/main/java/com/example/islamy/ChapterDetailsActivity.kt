package com.example.islamy

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.islamy.databinding.ActivityChapterDetailsBinding
import home.AppConstans
import home.tabs.quran.VersesAdapter
import home.tabs.quran.chapters_adapter
import models.chapter

class ChapterDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChapterDetailsBinding
     var Chapter : chapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        initRecyclerview()

    }

    lateinit var adapter: VersesAdapter
    private fun initRecyclerview() {
        adapter = VersesAdapter(versList)
        binding.content.versesRecycler.adapter = adapter
    }

    fun init(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU) {
            Chapter = intent.getParcelableExtra(
                AppConstans.EXTRA.Extra_CHAPTER,
                chapter::class.java
            )
        }else{
            Chapter = intent.getParcelableExtra(
                AppConstans.EXTRA.Extra_CHAPTER
            )
        }
        binding.toolBar.toolBarTitle.text = Chapter?.titleEN
        binding.content.chapterTitleAR.text = Chapter?.titleAR
        readChapterDetails(Chapter?.index?:0)
    }

    lateinit var versList : List<String>

    fun readChapterDetails(chapterIndex: Int) {
        val content = assets.open("quran/${chapterIndex + 1}.txt")
            .bufferedReader().use { it.readText() }
        versList = content.split("\n")

        adapter = VersesAdapter(versList)
        binding.content.versesRecycler.adapter = adapter
    }
}