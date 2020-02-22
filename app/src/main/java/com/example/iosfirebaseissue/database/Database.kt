package com.example.iosfirebaseissue.database

import android.content.Context
import androidx.room.*
import com.example.iosfirebaseissue.dao.Dao
import com.example.iosfirebaseissue.model.*
import com.google.gson.Gson
import java.util.Collections.emptyList
import com.google.gson.reflect.TypeToken

@Database(entities = [IosFirebaseIssueResponseModel::class, CommentResponseModel::class], version = 1)
@TypeConverters(LabelTypeConverters::class, PullRequestConverters::class, UserConverters::class)
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

class LabelTypeConverters {
    companion object {
        private var gson = Gson()
        @TypeConverter
        @JvmStatic
        fun stringToLabelObjectList(data: String?): List<Label> {
            data?.let {
                val listType = object : TypeToken<List<Label>>() {
                }.type
                return gson.fromJson(data, listType)
            }?: kotlin.run {
                return emptyList()
            }
        }

        @TypeConverter
        @JvmStatic
        fun labelObjectListToString(labelObjectList: List<Label>): String {
            return gson.toJson(labelObjectList)
        }
    }
}

class PullRequestConverters {
    companion object {
        private var gson = Gson()
        @TypeConverter
        @JvmStatic
        fun stringToPullRequest(data: String?): PullRequest? {
            data?.let {
                val objectType = object : TypeToken<PullRequest>() {
                }.type
                return gson.fromJson(it, objectType)
            }?: kotlin.run {
                return null
            }
        }

        @TypeConverter
        @JvmStatic
        fun pullRequestToString(pullRequest: PullRequest?): String? {
            return gson.toJson(pullRequest)
        }
    }
}

class UserConverters {
    companion object {
        private var gson = Gson()
        @TypeConverter
        @JvmStatic
        fun stringToUser(data: String?): User? {
            data?.let {
                val objectType = object : TypeToken<User>() {
                }.type
                return gson.fromJson(it, objectType)
            }?: kotlin.run {
                return null
            }
        }

        @TypeConverter
        @JvmStatic
        fun userToString(user: User?): String? {
            return gson.toJson(user)
        }
    }
}
