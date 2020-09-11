package com.example.fantasyleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.fantasyleague.adapters.ViewPagerAdapter
import com.example.fantasyleague.fragments.GroupFragment
import com.example.fantasyleague.fragments.MatchesFragment
import com.example.fantasyleague.fragments.ProfileFragment
import com.example.fantasyleague.model.Match
import com.example.fantasyleague.model.Player
import com.example.fantasyleague.viewmodel.TeamViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {

    private val model: TeamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(MatchesFragment(),"Matches")
        adapter.addFragment(ProfileFragment(),"Profile")
        adapter.addFragment(GroupFragment(),"Group")

        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)


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
