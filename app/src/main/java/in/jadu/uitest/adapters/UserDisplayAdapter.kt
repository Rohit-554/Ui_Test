package `in`.jadu.uitest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import `in`.jadu.uitest.R
import `in`.jadu.uitest.models.User

class UserDisplayAdapter(private val userList:List<User>): RecyclerView.Adapter<UserDisplayAdapter.UserDisplayViewHolder>(){

    class UserDisplayViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val userImage = view.findViewById<ImageView>(R.id.user_photo)
        val userName = view.findViewById<TextView>(R.id.tv_user_name)
        val userLocation = view.findViewById<TextView>(R.id.user_location)
        val userTags = view.findViewById<TextView>(R.id.user_tags)
        val userDescription = view.findViewById<TextView>(R.id.user_description)
        val progressBar = view.findViewById<ProgressBar>(R.id.progress_bar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDisplayViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.explore_item, parent, false)
        return UserDisplayViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserDisplayViewHolder, position: Int) {
        val user = userList[position]
        holder.userName.text = user.userName
        holder.userLocation.text = user.userLocation
        holder.userTags.text = user.userTags
        holder.userDescription.text = user.userDescription
        holder.userImage.setImageURI(user.userImage)
        holder.progressBar.progress = user.userProgress
    }

}