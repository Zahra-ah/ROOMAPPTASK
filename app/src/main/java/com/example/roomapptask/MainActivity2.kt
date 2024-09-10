package com.example.roomapptask

import MyAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapp.R

class MainActivity2 : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<LanguageData>
    lateinit var imageId:Array<Int>
    lateinit var heading :Array<String>
    lateinit var ins: Array<String>
    lateinit var price:Array<String>
    lateinit var hour:Array<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        imageId= arrayOf(R.drawable.java, R.drawable.kotlin, R.drawable.cplusplus, R.drawable.csharp,R.drawable.swift , R.drawable.html,R.drawable.javascript, R.drawable.python, )

        heading= arrayOf( "Course: Java", "Course: Kotlin","Course: C++" ,"Course: C#" , "Course: Swift","Course: HTML","Course: JavaScript","Course: Python" )
        price=arrayOf( "Price: 200L.E", "Price: 200L.E","Price: 200L.E" ,"Price: 200L.E", "Price: 200L.E","Price: 200L.E","Price: 200L.E","Price: 200L.E")
        ins=arrayOf( "Instructor: Ahmed magdi", "Instructor: Ahmed magdi","Instructor: Ahmed magdi" ,"Instructor: Ahmed magdi" , "Instructor: Ahmed magdi","Instructor: Ahmed magdi","Instructor: Ahmed magdi","Instructor: Ahmed magdi","Instructor: Ahmed magdi" )
        hour=arrayOf( "Hours: 30", "Hours: 30","Hours: 30" ,"Hours: 30" , "Hours: 30","Hours: 30","Hours: 30","Hours: 30" )
        newRecyclerView=findViewById(R.id.recyclerview1)
        newRecyclerView.layoutManager= LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList= arrayListOf<LanguageData>()
        getAndroidData()
        findViewById<Button>(R.id.btnhandie).setOnClickListener(){

            val intent= Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
    private fun getAndroidData()
    {
        for(i in imageId.indices )
        {
            val and=LanguageData(imageId[i],heading[i],ins[i],price[i],hour[i])
            newArrayList.add(and)
        }
        newRecyclerView.adapter=MyAdapter(newArrayList)
    }

}