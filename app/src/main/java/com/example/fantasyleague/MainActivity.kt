package com.example.fantasyleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.fantasyleague.model.Match
import com.example.fantasyleague.model.Player
import com.example.fantasyleague.viewmodel.TeamViewModel
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {

    private val model: TeamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model.getPlayers().observe(this, Observer<HashMap<String, Player>> {
            println("Change observed.")
            for ((key, value) in it) {
                println(value.toString())
            }

        })

        for (i in 0..10) {
            model.loadPlayers()
        }
    }
}
