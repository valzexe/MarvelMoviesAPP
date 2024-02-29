package com.example.marvelmovies

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FD4556")))

        val tvDetailName: TextView = findViewById(R.id.tv_marvel_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_description)
        val ivDetailPhoto: ImageView = findViewById(R.id.img_marvel_icon)
        val tvAbilities: TextView =  findViewById(R.id.tv_sinopsis)

        val dataMarvel = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Marvel>(EXTRA_DETAIL, Marvel::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Marvel>(EXTRA_DETAIL)
        }

        if (dataMarvel != null) {
            tvDetailName.text = dataMarvel.name
            tvDetailDescription.text = dataMarvel.description
            Glide.with(this)
                .load(dataMarvel.photos)
                .into(ivDetailPhoto)
            tvAbilities.text = dataMarvel.sinopsis
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_share, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                val shareIntent =  Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Bagikan informasi ini!")
                startActivity(shareIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}