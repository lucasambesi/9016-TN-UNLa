package com.example.got_app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val toolbar = findViewById<View>(R.id.tbYesNo) as Toolbar
        toolbar.title = "Yes/No"
        setSupportActionBar(toolbar)

        val ivYesNo = findViewById<ImageView>(R.id.ivYesNo)
        val tvYesNo = findViewById<TextView>(R.id.tvYesNo)
        val btnRecargar = findViewById<Button>(R.id.btnRecargar)

        runOnUiThread {
            CoroutineScope(Dispatchers.Main).launch {
                val call = YesNoClient.getRetrofit().create(ServiceAPI::class.java).getYesNo("/api")
                val yesno = call.body()
                if(call.isSuccessful){
                    Log.d("YesNo: ", yesno.toString())
                    if (yesno != null) {
                        Log.d("YesNo image: ", yesno.image.toString())
                        Glide.with(this@MainActivity3)
                            .load(yesno.image.toString())
                            .into(ivYesNo)
                        Thread.sleep(6500)
                        tvYesNo.setText(yesno.answer.toString())
                    }
                }else{

                }

            }

        }

        btnRecargar.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View) {
                    val main_activity = Intent(this@MainActivity3, MainActivity3::class.java)
                    startActivity(main_activity)
                    finish()
                }
            })
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_house, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.iBack -> {
                val main_activity = Intent(this@MainActivity3, MainActivity::class.java)
                startActivity(main_activity)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}