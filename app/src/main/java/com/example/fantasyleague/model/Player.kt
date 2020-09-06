package com.example.fantasyleague.model

data class Player(var name:String, var runs:Int=0, var wickets:Int=0, var fours:Int=0, var sixes:Int=0) {

    override fun toString(): String {
        return "name: $name runs: $runs wickets: $wickets fours: $fours sixes: $sixes";
    }

}
