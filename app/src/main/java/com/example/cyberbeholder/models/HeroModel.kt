package com.example.cyberbeholder.models

data class HeroModel(
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
