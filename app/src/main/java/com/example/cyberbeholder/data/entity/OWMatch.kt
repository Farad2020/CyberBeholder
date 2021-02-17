package com.example.cyberbeholder.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matches_table")
class OWMatch (){}

//Example entity elements
//@PrimaryKey
//val uid: Int,
//@ColumnInfo(name = "first_name") val firstName: String?,
//@ColumnInfo(name = "last_name") val lastName: String?

//In short, I can define some of the relationships of entities, which later can be used in dao functions
// more about it here - https://blog.mindorks.com/entity-relationship-in-room