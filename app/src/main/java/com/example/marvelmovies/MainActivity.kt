package com.example.marvelmovies

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelmovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var rvMarvel: RecyclerView
    private val list = arrayListOf<Marvel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FD4556")))

        binding.rvMarvel.setHasFixedSize(true)

        list.addAll(listOfMarvel)
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, AboutPage::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private val listOfMarvel: ArrayList<Marvel>
        get() {
            val dataName = resources.getStringArray(R.array.data_marvel)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.getStringArray(R.array.data_photo)
            val dataSinopsis = resources.getStringArray(R.array.marvel_sinopsis)
            val listMarvel = ArrayList<Marvel>()
            for (i in dataName.indices) {
                val marvel = Marvel(dataName[i], dataDescription[i], dataPhoto[i], dataSinopsis[i])
                listMarvel.add(marvel)
            }
            return listMarvel
        }
    private fun showRecyclerList() {
        binding.rvMarvel.layoutManager = LinearLayoutManager(this)
        val listMarvelAdapter = ListMarvelAdapter(list)
        binding.rvMarvel.adapter = listMarvelAdapter

    }

}