package com.example.listview

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadListView1()
    }

    private fun loadListView1() {

        val data = listOf(
            mapOf(
                KEY_TITLE to "1111",
                KEY_DESCRIPTION to "1122"
            ),
            mapOf(
                KEY_TITLE to "2211",
                KEY_DESCRIPTION to "2222"
            ),
            mapOf(
                KEY_TITLE to "3311",
                KEY_DESCRIPTION to "3322"
            )
        )

        val adapter = SimpleAdapter(
            this,
            data,
            android.R.layout.simple_list_item_2,
            arrayOf(KEY_TITLE, KEY_DESCRIPTION),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        binding.listView.adapter = adapter

        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedItemTitle = data[position][KEY_TITLE]
                val selectedItemDescription = data[position][KEY_DESCRIPTION]

                val dialog = AlertDialog.Builder(this)
                    .setTitle(selectedItemTitle)
                    .setMessage(getString(R.string.item_selected_message, selectedItemDescription))
                    .setPositiveButton("Okey"){dialog, which ->}
                    .setNegativeButton("Cancel"){dialog, which ->}
                    .create()
                dialog.show()
            }

//        val listener = DialogInterface.OnClickListener { dialog, which ->
//            if (which == DialogInterface.BUTTON_POSITIVE){
//
//            }
//        }
//        val dialog = AlertDialog.Builder(this)
//            .setTitle("delete item")
//            .setMessage("зачем хотите удалить")
//            .setNegativeButton("Delete", listener)
//            .setPositiveButton("Cancel", listener)
//            .create()
//        dialog.show()
//    }



    }

    companion object{
        @JvmStatic val KEY_TITLE = "KEY_TITLE"
        @JvmStatic val KEY_DESCRIPTION = "KEY_DESCRIPTION"
    }

}