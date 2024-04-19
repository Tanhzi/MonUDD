package com.example.myapplication.tuan4

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class T3listviewMainActivity : AppCompatActivity() {
    var adapter: T3Adapter? = null
    var ls= ArrayList<T3Contact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t3listview_main)
        var  lv=findViewById<ListView>(R.id.t3listview)//anh xa
        //them du lieu vao listview
        ls.add(T3Contact("Elina","18",R.drawable.OIP))
        ls.add(T3Contact("AOHI","18",R.drawable.OIP1))
        ls.add(T3Contact("NSITS","18",R.drawable.OIP2))
        ls.add(T3Contact("LIHINU","18",R.drawable.OIP3))
        ls.add(T3Contact("FUEN","18",R.drawable.OIP4))
        ls.add(T3Contact("BYWNF","18",R.drawable.OIP5))
        ls.add(T3Contact("QIASD","18",R.drawable.OIP6))
        //TAO ADAPTER
        adapter=T3Adapter(ls,this)
        //gan du lieu len ;istview
        lv!!.adapter=adapter

    }
}