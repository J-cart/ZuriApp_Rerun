package com.example.recyclerview01

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), onClick {
    companion object {
        val IMAGE_KEY = "image key"
        val NAME_KEY = "name key"
        val DESC_KEY = "desc key"
        var dummyList = ArrayList<dummy>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycle = findViewById<RecyclerView>(R.id.recycler)
        val dtscall = addDets()
        val adapter = R_Adapter(dtscall, this)
        recycle.adapter = adapter
        supportActionBar?.apply {
            title = "Welcome Folks"
        }
    }

    fun addDets(): ArrayList<dummy> {
        return dummyList
            .apply {
                add(
                    dummy(
                        R.drawable.annotation_2021_10_03_164249,
                        "English premier league 01",
                        "This is Kotlin"
                    )
                )
                add(
                    dummy(
                        R.drawable.ic_launcher_background,
                        "English premier league 02",
                        "This is Kotlin"
                    )
                )
                add(
                    dummy(
                        R.drawable.annotation_2021_10_03_164249,
                        "English premier league 03",
                        "This is Kotlin"
                    )
                )
                add(
                    dummy(
                        R.drawable.annotation_2021_10_03_164249,
                        "English premier league 04",
                        "This is Kotlin"
                    )
                )
                add(
                    dummy(
                        R.drawable.annotation_2021_10_03_164249,
                        "English premier league 05",
                        "This is Kotlin"
                    )
                )

            }
    }

    override fun btnClicked(position: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        val pos = dummyList[position]
        intent.putExtra(IMAGE_KEY, pos.imagesrc)
        intent.putExtra(NAME_KEY, pos.name)
        intent.putExtra(DESC_KEY, pos.favorite)
        startActivity(intent)
    }

    override fun viewClicked(position: Int) {
        Toast.makeText(this, "+++ITEMVIEW clicked+++", Toast.LENGTH_SHORT).show()
    }

}

