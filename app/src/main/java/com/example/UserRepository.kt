package com.example

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> =userDao.readAllData()
    suspend fun addUser(user: User)
    {
        userDao.addUser(user)
    }
    suspend fun updateUser(user:User)
    {
        userDao.updateUser(user)
    }
    suspend fun deleteUser(user:User){
        userDao.deleteUser(user)
    }
    suspend fun deleteAllUser()
    {
        userDao.deleteAllUser()
    }
    suspend fun  insertUser(user:User)
    {
        userDao.insertUser(user)
    }
    fun searchDatabase(searchQuery: String): LiveData<List<User>> {
        return userDao.searchDatabase(searchQuery)
    }
}