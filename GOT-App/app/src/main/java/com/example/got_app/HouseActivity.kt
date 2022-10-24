package com.example.got_app

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import android.content.Intent
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.util.ArrayList

class HouseActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    var rcv: RecyclerView? = null
    var adapter: CharacterAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house)
        val bundle = intent.extras
        val toolbar = findViewById<View>(R.id.tbHouse) as Toolbar
        var house: String? = ""
        var houseId: String? = ""
        if (bundle != null) {
            house = bundle.getString("header")
            houseId = bundle.getString("id")
            Toast.makeText(this@HouseActivity, house, Toast.LENGTH_SHORT).show()
        }
        toolbar.title = house
        setSupportActionBar(toolbar)
        rcv = findViewById<View>(R.id.recview) as RecyclerView
        var chModels = ArrayList<CardCharacterModel>()
        runOnUiThread {
            CoroutineScope(Dispatchers.Main).launch {
                val callHouse = RetrofitClient.getRetrofit().create(ServiceAPI::class.java).getHouse("houses/$houseId")
                val house= callHouse.body()
                val characters = ArrayList<Character>()
                if(callHouse.isSuccessful){
                    if (house != null) {

                        for(url in house.characters!!){
                            val splittedString: List<String> = url.split("characters/")
                            val idCharacter = splittedString[splittedString.count() - 1]
                            Log.d("splittedString: ", idCharacter)
                            val call = RetrofitClient.getRetrofit().create(ServiceAPI::class.java).getCharacter(
                                "characters/$idCharacter"
                            )

                            val character= call.body()
                            if(call.isSuccessful){
                                if (character != null) {
                                    Log.d("character: ", character.toString())
                                    characters.add(character)
                                }
                            }else{
                                showError()
                            }
                        }
                    }
                }else{
                    showError()
                }


                adapter = CharacterAdapter(getCharacterAdapter(characters), applicationContext)
                rcv!!.adapter = adapter
                }
            val gridLayoutManager = GridLayoutManager(this, 1)
            rcv!!.layoutManager = gridLayoutManager
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_house, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.iBack -> {
                val main_activity = Intent(this@HouseActivity, MainActivity::class.java)
                startActivity(main_activity)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun showError(){
        Toast.makeText(this ,"Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    private fun getCharacterAdapter(characters: List<Character>?): ArrayList<CardCharacterModel> {
        val charactersModels = ArrayList<CardCharacterModel>()
        if (characters != null) {
            for(ch in characters){
                if(ch.name != ""){
                    val model = CardCharacterModel()

                    model.header = ch.name
                    if(ch.born == ""){
                        ch.born = "No hay info sobre su nacimiento."
                    }
                    if(ch.died == ""){
                        ch.died = " No hay info sobre su muerte."
                    }
                    val born = ch.born
                    val died = ch.died

                    model.desc = born + died

                    charactersModels.add(model)
                }
            }
        }
        Log.d("characters => ", characters.toString())
        return charactersModels
    }
}