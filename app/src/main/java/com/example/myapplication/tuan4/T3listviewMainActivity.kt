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

        var  lv=findViewById<ListView>(R.id.t3Listview)//anh xa
        //them du lieu vao listview
        ls.add(T3Contact("Elina","22",R.drawable.a))
        ls.add(T3Contact("AOHI","23",R.drawable.b))
        ls.add(T3Contact("NSITS","17",R.drawable.c))
        ls.add(T3Contact("LIHINU","18",R.drawable.d))
        ls.add(T3Contact("FUEN","20",R.drawable.e))
        ls.add(T3Contact("BYWNF","19",R.drawable.f))
        ls.add(T3Contact("QIASD","21",R.drawable.w))
        //TAO ADAPTER
        adapter=T3Adapter(ls,this)
        //gan du lieu len ;istview
        lv!!.adapter=adapter
    }
}