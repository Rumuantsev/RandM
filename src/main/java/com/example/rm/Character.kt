package com.example.rm

data class CharacterResponse(val results: List<Character>)
data class Character(val id: Int, val name: String, val species: String, val image: String) {
    fun getType(): String {
        if (species.lowercase() == "human") {
            return "image"
        } else if (species.lowercase() == "alien") {
            return "name"
        } else return "species"
    }
}

