package com.example.roomapp.list

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.UserViewModel
import com.example.roomapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


@Suppress("UNREACHABLE_CODE")
class ListFragment : Fragment() {

    lateinit var mUserViewModel: UserViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val adapter = MyAdapter()
        val recycleView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)

        })
        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener() {

            findNavController().navigate(R.id.action_listFragment_to_addFraagment)

        }



        val searchView = view.findViewById<SearchView>(R.id.searchView)
        searchView.apply {
            isIconified = false
            isFocusable = true
            requestFocusFromTouch()
            queryHint = "Search .."
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    // Handle query submission if needed
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText != null) {
                        mUserViewModel.searchDatabase(newText).observe(viewLifecycleOwner) { user ->
                            adapter.setData(user)
                        }
                    } else {
                        // Show all data if query is empty
                        mUserViewModel.readAllData.observe(viewLifecycleOwner) { user ->
                            adapter.setData(user)
                        }
                    }
                    return true
                }
            })
        }
                    return view

                }
            }



