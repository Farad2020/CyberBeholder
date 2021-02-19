package com.example.cyberbeholder.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes_table")
data class HeroModel(
    @PrimaryKey
    val id: Int,
    val image_url: String,
    val name: String,
    val difficulty: Int,
    val portrait_url: String,
    val real_name: String,
    val role: String,
    val slug: String
) {
}
