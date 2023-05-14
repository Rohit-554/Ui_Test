package `in`.jadu.uitest.screens

import android.content.ContentResolver
import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import `in`.jadu.uitest.R
import `in`.jadu.uitest.adapters.UserDisplayAdapter
import `in`.jadu.uitest.databinding.FragmentExploreBinding
import `in`.jadu.uitest.models.User
import `in`.jadu.uitest.viewmodel.ExploreFragViewModel

class ExploreFrag : Fragment() {
    private lateinit var binding: FragmentExploreBinding
    private lateinit var userList: List<User>
    private lateinit var exploreFragViewModel: ExploreFragViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding  = FragmentExploreBinding.inflate(inflater, container, false)
        exploreFragViewModel = ViewModelProvider(this)[ExploreFragViewModel::class.java]
        setupRecycleViewAndAdapter()
        userList = emptyList()
        return binding.root
    }

    private fun setupRecycleViewAndAdapter() {
        userList = exploreFragViewModel.getUserList(requireContext())
        val userDisplayAdapter = UserDisplayAdapter(userList)
        binding.userRecyclerView.adapter = userDisplayAdapter
        binding.userRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
    }




}