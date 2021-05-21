package com.emu.contactlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.emu.contactlist.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
      private lateinit var binding: ActivityCategoryBinding
    private val adapter = CategoryAdapter { catItem: Category -> itemClicked(catItem) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.categoryRv.adapter = adapter

        binding.categoryRv.layoutManager = GridLayoutManager(this, 2)


        val cat = CategoryItem.cat
        adapter.setUpCategory(cat)



    }

     fun itemClicked(catItem : Category){
         val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)

    }

}


