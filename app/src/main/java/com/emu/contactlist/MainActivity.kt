package com.emu.contactlist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.emu.contactlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val adapter = ContactAdapter()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpData(binding)


//        supportActionBar?.title =


    }

   private fun setUpData(binding: ActivityMainBinding){
       binding.contactRv.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        binding.contactRv.adapter = adapter
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.add_contact_dialog,null)
        builder.setView(view)

        val name = view.findViewById<TextView>(R.id.nameEt)
        val num = view.findViewById<TextView>(R.id.numberEt)
        val button = view.findViewById<TextView>(R.id.saveEt)

        num.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               button.isEnabled = p0?.length == 11
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        val alertDialog = builder.create()
        button.setOnClickListener {
            val contact = Contact(name.text.toString(),num.text.toString())
            val contacts = mutableListOf(contact)
            adapter.setUpContact(contacts)

        }


        binding.fab.setOnClickListener{
            alertDialog.show()
        }
    }
}