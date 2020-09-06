package com.example.fantasyleague.model

data class Match(var teams: Pair<Team,Team>? = null, var isOver: Boolean = false)
