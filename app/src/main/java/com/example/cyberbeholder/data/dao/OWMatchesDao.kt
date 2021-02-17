package com.example.cyberbeholder.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cyberbeholder.data.entity.OWMatch

//Data Access Object to get OWMatches from db to entities
@Dao
interface OWMatchesDao{
    @Query("SELECT * FROM matches_table")
    fun getAll(): LiveData<List<OWMatch>>

// Turned off following method cuz no need, no parts in OWMatch

//    @Query("SELECT * FROM matches_table WHERE id IN (:matchIds)")
//    fun loadAllByIds(matchIds: IntArray): LiveData<List<OWMatch>>

    //All "insert" functions just need to be under the same notation, one after another, and it'll work
    //by using vararg I can insert as many users as I want
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg matches: OWMatch)


    @Delete
    fun delete(match: OWMatch)
}

// save object in object and FK(foreign key) ex.  - https://blog.mindorks.com/entity-relationship-in-room

//how to use tuples A.K.A. use objects to get certain columns - https://blog.mindorks.com/data-access-objects-dao-in-room