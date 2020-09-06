package com.example.fantasyleague.viewmodel

import androidx.lifecycle.*
import com.example.fantasyleague.model.Player
import com.example.fantasyleague.repository.MatchRepository

class TeamViewModel : ViewModel() {

    // TODO: Have a list of Player containing in the current match. And a map that maps a player to its index.
    private var playerValue = MutableLiveData<HashMap<String,Player>>()

    init {
        loadPlayers()
    }

    fun getPlayers() : LiveData<HashMap<String,Player>> {
        return playerValue
    }

    fun loadPlayers() {

        val player = MatchRepository.getLiveMatchDetails()

        if (playerValue.value == null) {
            val temp = player
            val tt: HashMap<String, Player> = HashMap()
            tt[player.name] = player
            playerValue.value = tt
        } else
            playerValue.value!![player.name] = player
    }
}
