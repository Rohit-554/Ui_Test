package `in`.jadu.uitest.models

import android.net.Uri

data class User(
    val userImage: Uri,
    val userName: String,
    val userLocation: String,
    val userTags: String,
    val userDescription: String,
    val userProgress:Int
)