package com.example.iosfirebaseissue.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import com.example.iosfirebaseissue.dao.Dao
import com.example.iosfirebaseissue.model.CommentResponseModel
import com.example.iosfirebaseissue.model.IosFirebaseIssueResponseModel
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import java.util.Collections.emptyList
import com.google.gson.reflect.TypeToken
import java.util.Collections.emptyList





@Database(entities = [IosFirebaseIssueResponseModel::class, CommentResponseModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): Dao
}

object database {
    var databaseInstance: AppDatabase? = null
    fun getDatabaseInstance(context: Context): AppDatabase {
        databaseInstance?.let {
            return it
        }?:kotlin.run {
            databaseInstance = Room.databaseBuilder(
                context,
                AppDatabase::class.java, "database-name"
            ).build()
            return databaseInstance as AppDatabase
        }
    }
}

//class LabelTypeConverters {
//    internal var gson = Gson()
//    companion object {
//        @TypeConverter
//        fun stringToLabelObjectList(data: String?): List<> {
//            if (data == null) {
//                return Collections.emptyList()
//            }
//            val listType = object : TypeToken<List<SomeObject>>() {
//            }.type
//            return gson.fromJson(data, listType)
//        }
//
//        @TypeConverter
//        fun someObjectListToString(someObjects: List<SomeObject>): String {
//            return gson.toJson(someObjects)
//        }
//    }
//}
