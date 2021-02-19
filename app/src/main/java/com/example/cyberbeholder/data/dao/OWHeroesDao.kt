package com.example.cyberbeholder.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cyberbeholder.models.HeroModel
import io.reactivex.Single

@Dao
interface OWHeroesDao {

    @Query("SELECT * FROM heroes_table ORDER BY name")
    fun getAllHeroes(): Single<List<HeroModel>>

    @Query("SELECT * FROM heroes_table WHERE id = (:heroId)")
    fun getHeroByIds(heroId: Int): Single<HeroModel>

    @Query("SELECT * FROM heroes_table WHERE slug LIKE :slug LIMIT 1")
    fun findBySlug(slug: String): Single<HeroModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(heroes: List<HeroModel>)

    @Delete
    fun delete(hero: HeroModel)
}