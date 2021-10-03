package com.example.rview3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() , OnItemClickListener{
    var myList =  ArrayList<ItemsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.myrecyclerview)
        rv.layoutManager = LinearLayoutManager(this)

//        for(i in 1..10){
////            myList.add(ItemsViewModel(R.drawable.call,"Item "+i))
//        }
//        val adapter = CustomAdapter(myList,this)
        fetchData(rv)
//        rv.adapter=adapter

    }

    override fun onItemClicked(position: Int,image:String) {
        Toast.makeText(this,"CLICKED on ITEM "+position,Toast.LENGTH_SHORT).show()
        val intent = Intent(this@MainActivity,SecondActivity::class.java)
        intent.putExtra("IT",image)
        startActivity(intent)
    }

    private fun fetchData(rv: RecyclerView){
        FirebaseFirestore.getInstance().collection("users")
            .get()
            .addOnSuccessListener { documents ->
                run {
                    for (document in documents) {
                        val u = documents.toObjects(ItemsViewModel::class.java)
                        rv.adapter=CustomAdapter(u,this)
                        myList.addAll(u)
                    }
                }

            }
            .addOnFailureListener {
                Toast.makeText(this,"Failed to load",Toast.LENGTH_SHORT)

            }
    }

}
