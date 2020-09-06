package com.example.fantasyleague.repository

import com.example.fantasyleague.api.JsoupDocument
import com.example.fantasyleague.model.Player
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

object MatchRepository {

    // dummy player generator
    // to be removed.
    private fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }

    private var job: CompletableJob? = null

    fun getLiveMatchDetails(): Player {

        job = Job()

        // TODO: Update the player list according to body scrapped.
        CoroutineScope(IO+ job!!).launch {
            println(JsoupDocument.builder.body().text())
        }

        // random string so that a new key is added to the map.
        // temp to test viewmodel.
        return Player(getRandomString(6), Math.random().toInt(), 0, 1, 2)
    }

    fun cancelJob() {
        job?.cancel()
    }
}
