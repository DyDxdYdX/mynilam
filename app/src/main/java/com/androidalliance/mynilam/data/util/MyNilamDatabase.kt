package com.androidalliance.mynilam.data.util

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.androidalliance.mynilam.data.dao.ProfileDao
import com.androidalliance.mynilam.data.dao.ReadingMaterialDao
import com.androidalliance.mynilam.data.dao.RecordDao
import com.androidalliance.mynilam.data.dao.ReviewDao
import com.androidalliance.mynilam.data.dao.UserDao
import com.androidalliance.mynilam.data.models.Profile
import com.androidalliance.mynilam.data.models.ReadingMaterial
import com.androidalliance.mynilam.data.models.Record
import com.androidalliance.mynilam.data.models.Review
import com.androidalliance.mynilam.data.models.User

@Database(
    entities = [
        User::class,
        Profile::class,
        Record::class,
        Review::class,
        ReadingMaterial::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MyNilamDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun profileDao(): ProfileDao
    abstract fun recordDao(): RecordDao
    abstract fun reviewDao(): ReviewDao
    abstract fun readingMaterialDao(): ReadingMaterialDao

    companion object {
        @Volatile
        private var Instance: MyNilamDatabase? = null

//        fun getDatabase(context: Context): MyNilamDatabase{
//            return Instance ?: synchronized(this){
//                databaseBuilder(
//                    context = context,
//                    klass = MyNilamDatabase::class.java,
//                    name = "mynilam_database"
//                )
//                    .createFromAsset("databases/mynilam_database.db")
//                    .fallbackToDestructiveMigration()
//                    .build()
//                    .also { Instance = it }
//            }
//        }
        fun getDatabase(context: Context): MyNilamDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context = context,
                    klass = MyNilamDatabase::class.java,
                    name = "mynilam_database"
                ).createFromAsset("databases/mynilam_database.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}