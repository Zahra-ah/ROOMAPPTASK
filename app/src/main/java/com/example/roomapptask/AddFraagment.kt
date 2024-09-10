package com.example.roomapptask

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
import com.example.roomapp.R


class AddFraagment : Fragment() {
    //private val args by navArgs<AddFraagmentArgs>()

    private lateinit var mUserViewModel: UserViewModel
    @SuppressLint("MissingInflatedId")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_fraagment, container, false)
        mUserViewModel= ViewModelProvider(this).get(UserViewModel::class.java)



       /* view.findViewById<EditText>(R.id.nameed).setText(args.currentUser.firstName)
        view.findViewById<EditText>(R.id.courseedit).setText(args.currentUser.course)
        view.findViewById<EditText>(R.id.ageDit).setText(args.currentUser.age.toString())
*/
/*
        view.findViewById<Button>(R.id.update).setOnClickListener()
        {
            updateitem(view)

        }
        view.findViewById<Button>(R.id.delete).setOnClickListener {
            deleteUser()
        }
        view.findViewById<Button>(R.id.deleteallUser).setOnClickListener()
        {
            deleteAllUsers()
        }*/

        view.findViewById<Button>(R.id.save).setOnClickListener(){
            insertDataToDatabase(view)
        }
        return view
    }
    /*
    private fun updateitem(view:View){


        val Name=view.findViewById<EditText>(R.id.nameed).text.toString()
        val course=view.findViewById<EditText>(R.id.courseedit).text.toString()
        val age=Integer.parseInt(view.findViewById<EditText>(R.id.ageDit).text.toString())

        if(CheckInput(Name, course, view.findViewById<EditText>(R.id.ageDit).text ))
        {
            //create instance
            val updatedUser = User(args.currentUser.id,Name,course,age )
            //create updating
            mUserViewModel.updateUser(updatedUser)
            Toast.makeText(requireContext(), "updated successfully", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFraagment_to_listFragment)
        }
        else
        {
            Toast.makeText( requireContext(),"fill it out", Toast.LENGTH_SHORT).show()
        }
    }

*/


    private fun  insertDataToDatabase(view:View)
    {
        val editTextFirstName = view.findViewById<EditText>(R.id.nameed)
        val editTextCourse = view.findViewById<EditText>(R.id.courseedit)
        val editTextAge = view.findViewById<EditText>(R.id.ageDit)
        val firstName = editTextFirstName.text.toString()
        val lastName = editTextCourse.text.toString()
        val age = editTextAge.text
        if(CheckInput(firstName,lastName,age))
        {
            //Creat User Object
            val user= User(0,firstName,lastName,Integer.parseInt(age.toString()))
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"successfully adding", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFraagment_to_listFragment)
        }
        else
        {
            Toast.makeText(requireContext(),"please fill out all fields", Toast.LENGTH_LONG).show()

        }

    }
/*
    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Delete ${args.currentUser.firstName}?")
        builder.setMessage("Are you sure you want to delete ${args.currentUser.firstName}?")
        builder.setPositiveButton("Yes") { _, _ ->
            mUserViewModel.deleteUser(args.currentUser)
            Toast.makeText(requireContext(), "Successfully removed ${args.currentUser.firstName}", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFraagment_to_listFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.create().show()
    }

    private fun deleteAllUsers() {
        val builder = androidx.appcompat.app.AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mUserViewModel.deleteAllUser()
            Toast.makeText(requireContext(), "Successfully removed everything", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFraagment_to_listFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you sure you want to delete everything?")
        builder.create().show()
    }
*/
    private fun CheckInput(firstName:String,lastName:String,age: Editable):Boolean
    {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
}


