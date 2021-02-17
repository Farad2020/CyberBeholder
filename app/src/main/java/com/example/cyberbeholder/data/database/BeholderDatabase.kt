//package com.example.cyberbeholder.data.database
//
//import android.content.Context
//import android.util.Log
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import androidx.sqlite.db.SupportSQLiteDatabase
//import com.example.cyberbeholder.data.dao.OWMatchesDao
//import com.example.cyberbeholder.data.entity.OWMatch
//import java.util.concurrent.Executors
//
//
//// Converter at the end - https://blog.mindorks.com/introduction-to-room-persistent-library-in-android
//@Database(entities = arrayOf(OWMatch::class), version = 1)
//abstract class BeholderDatabase : RoomDatabase(){
//    abstract fun matchesDao(): OWMatchesDao
//
//
//    companion object {
//        private var INSTANCE: BeholderDatabase? = null
//
//        //not sure if thats the best way, may change later
//        fun getDatabase(context: Context): BeholderDatabase? {
//            if (INSTANCE == null) {
//
//                synchronized(BeholderDatabase::class) {
//                    INSTANCE = Room.databaseBuilder(
//                        context.getApplicationContext(),
//                        BeholderDatabase::class.java, "beholder.db"
//                    ).addCallback(object : RoomDatabase.Callback() {
//
//                        override fun onCreate(db: SupportSQLiteDatabase) {
//                            super.onCreate(db)
//                            //this part may change since it touches threads
//                            Executors.newSingleThreadScheduledExecutor().execute(object : Runnable {
//                                override fun run() {
//                                    //Following code was from - https://blog.mindorks.com/android-searchview-in-room-database-in-kotlin
//                                    //used to populate db with some data, deprecated for me
//
//                                    //getDatabase(context)!!.().OWMatchesDao.insert(Chapter.populateData())
//                                    //Log.d("DatabaseFilled", "DatabaseFilled")
//                                }
//                            })
//                        }
//                    })
//                        .build()
//                }
//            }
//            return INSTANCE
//        }
//    }
//    //example of getting instance
//
////    val db = Room.databaseBuilder(
////        applicationContext,
////        UserDatabase::class.java, "matches_db"
////    ).build()
//
//    //Room with RXJava - https://blog.mindorks.com/using-room-with-live-data-and-other-third-party-libraries
//}
//
////migrations - https://blog.mindorks.com/room-database-migrations
//
////example project/ clear db work - https://blog.mindorks.com/android-searchview-in-room-database-in-kotlin