package com.example.roomapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.User
import com.example.UserViewModel

class updateFragment : Fragment() {

    private val args by navArgs<updateFragmentArgs>()
    private lateinit var mUserViewModel: UserViewModel



    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_update, container, false)
        mUserViewModel= ViewModelProvider(this).get(UserViewModel::class.java)


         view.findViewById<EditText>(R.id.nameed1).setText(args.currentUser.firstName)
       view.findViewById<EditText>(R.id.courseedit1).setText(args.currentUser.course)
       view.findViewById<EditText>(R.id.ageDit1).setText(args.currentUser.age.toString())
        view.findViewById<Button>(R.id.update1).setOnClickListener()
        {
            updateitem(view)

        }
        view.findViewById<Button>(R.id.delete1).setOnClickListener {
            deleteUser()
        }
        view.findViewById<Button>(R.id.deleteallUser1).setOnClickListener()
        {
            deleteAllUsers()
        }

        return view
    }


    private fun updateitem(view:View){


        val Name=view.findViewById<EditText>(R.id.nameed1).text.toString()
        val course=view.findViewById<EditText>(R.id.courseedit1).text.toString()
        val age=Integer.parseInt(view.findViewById<EditText>(R.id.ageDit1).text.toString())

        if(CheckInput(Name, course, view.findViewById<EditText>(R.id.ageDit1).text ))
        {
            //create instance
            val updatedUser = User(args.currentUser.id,Name,course,age )
            //create updating
            mUserViewModel.updateUser(updatedUser)
            Toast.makeText(requireContext(), "updated successfully", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        else
        {
            Toast.makeText( requireContext(),"fill it out", Toast.LENGTH_SHORT).show()
        }
    }



    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Delete ${args.currentUser.firstName}?")
        builder.setMessage("Are you sure you want to delete ${args.currentUser.firstName}?")
        builder.setPositiveButton("Yes") { _, _ ->
            mUserViewModel.deleteUser(args.currentUser)
            Toast.makeText(requireContext(), "Successfully removed ${args.currentUser.firstName}", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.create().show()
    }

    private fun deleteAllUsers() {
        val builder = androidx.appcompat.app.AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mUserViewModel.deleteAllUser()
            Toast.makeText(requireContext(), "Successfully removed everything", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you sure you want to delete everything?")
        builder.create().show()
    }

    private fun CheckInput(firstName:String,lastName:String,age: Editable):Boolean
    {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
}