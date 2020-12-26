package com.kirtan.codingtest_openxcell.repo

import android.app.Application
import com.kirtan.codingtest_openxcell.db.MyRoomDatabase
import com.kirtan.codingtest_openxcell.db.RoomDAO
import com.kirtan.codingtest_openxcell.db.UserTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(context: Application) {

    private var roomDAO: RoomDAO = MyRoomDatabase.getInstance(context).roomDao()
    private var userList = roomDAO.getUsers()

    fun insert(model: UserTable) {
        CoroutineScope(Dispatchers.IO).launch { roomDAO.insertUser(model) }
    }

    fun getUsers() = userList

    fun removeAllUsers() {
        CoroutineScope(Dispatchers.IO).launch { roomDAO.removeAllUsers() }
    }

}