package `in`.jadu.uitest.viewmodel

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import `in`.jadu.uitest.R
import `in`.jadu.uitest.models.User

class ExploreFragViewModel:ViewModel() {
    private var userList: List<User> = listOf()

    private fun getUriFromDrawableId(context: Context, drawableId: Int): Uri {
        return Uri.parse(
            ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + context.resources.getResourcePackageName(drawableId) +
                '/' + context.resources.getResourceTypeName(drawableId) +
                '/' + context.resources.getResourceEntryName(drawableId))
    }

    fun getUserList(context: Context): List<User> {
        userList = listOf(
            User(
                userImage = getUriFromDrawableId(context, R.drawable.childboy),
                userName = "Jadu",
                userLocation = "India",
                userTags = "Coffee | Business",
                userDescription = "I am a Android Developer",
                12
            ),
            User(
                userImage = getUriFromDrawableId(context, R.drawable.girls),
                userName = "Ammy",
                userLocation = "Australia",
                userTags = "Coffee | Business | Friendship",
                userDescription = "I am looking for a friend to hang out with. I love coffee, business and friendship",
                50
            ),
            User(
                userImage = getUriFromDrawableId(context, R.drawable.man),
                userName = "Jack",
                userLocation = "America",
                userTags = "Coffee | Business | Hobbies",
                userDescription = "Hi Community! I am Jack, a Student. I am looking for a friend to hang out with. I love coffee, business and friendship. I am also looking for a friend to hang out with. I love coffee, business and friendship.",
                25
            ),
            User(
                userImage = getUriFromDrawableId(context, R.drawable.women),
                userName = "JM",
                userLocation = "London",
                userTags = "Coffee | Business | Hobbies",
                userDescription = "I want to meet some new people and make friends. I love coffee, business and friendship. I am also looking for a friend to hang out with. I love coffee, business and friendship.",
                75
                ),

            User(
                userImage = getUriFromDrawableId(context, R.drawable.women2),
                userName = "Linda",
                userLocation = "Paris",
                userTags = "Dating | Friendship",
                userDescription = "I am looking for a friend to date with, I am more of a Introvert and a little shy but I love to share my thoughts and feelings with people I am comfortable with",
                100
                ),
            )
        return userList
    }
}