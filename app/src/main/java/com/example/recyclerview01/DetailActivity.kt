package com.example.recyclerview01

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview01.MainActivity.Companion.DESC_KEY
import com.example.recyclerview01.MainActivity.Companion.IMAGE_KEY
import com.example.recyclerview01.MainActivity.Companion.NAME_KEY

class DetailActivity : AppCompatActivity() {
//    private val dummy = dummy()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }

        getters()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.favMenu -> {
                val testing = intent.getStringExtra(NAME_KEY)
                var state = intent.getBooleanExtra(DESC_KEY,false)
                if(state){
                    item.setIcon(R.drawable.unfav)
                }else{
                    item.setIcon(R.drawable.fav)
                }
                state = !state
                Toast.makeText(this, "oi......$testing", Toast.LENGTH_SHORT).show()

//                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fastweb.com"))
//                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }//back key clickListener and menu clickListener

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation_menu, menu)
        return true
    }


  fun getters(){
        val name = findViewById<TextView>(R.id.Tv10)
        val image = findViewById<ImageView>(R.id.image10)
        val Gname = intent.getStringExtra(NAME_KEY)
        val Gimage = intent.getIntExtra(IMAGE_KEY,0)

        name.text = Gname
        image.setImageResource(Gimage)

   }
}