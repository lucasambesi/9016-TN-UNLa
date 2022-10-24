package com.example.got_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Response

class MainActivity3 : AppCompatActivity() {
    lateinit var tvServiceRest : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val api = RetrofitClient.retrofit.create(MyAPI::class.java)
        val callGetPost = api.getPost()

        callGetPost.enqueue(object : retrofit2.Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts = response.body()
                Log.d("ESTO DEVOLVIO", posts.toString())
                if(posts != null){
                    tvServiceRest = findViewById(R.id.tvServiciosRest)
                    tvServiceRest.text = posts.toString()
                    Log.d("REST okey", posts.toString())
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e("REST", t.message ?:"")
            }
        })
    }
}