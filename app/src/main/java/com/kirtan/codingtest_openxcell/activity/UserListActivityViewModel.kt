package com.kirtan.codingtest_openxcell.activity

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.kirtan.codingtest_openxcell.api.APIObject
import com.kirtan.codingtest_openxcell.db.UserTable
import com.kirtan.codingtest_openxcell.model.APIModel
import com.kirtan.codingtest_openxcell.model.Result
import com.kirtan.codingtest_openxcell.repo.UserRepository
import com.kirtan.codingtest_openxcell.utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserListActivityViewModel(application: Application) : AndroidViewModel(application) {

    init {
        if (Utils.isInternetAvailable(getApplication()))
            APIObject.getInstance().getUsers(100).enqueue(object : Callback<APIModel> {
                override fun onResponse(call: Call<APIModel>, response: Response<APIModel>) {
//                    Log.d(TAG, "onResponse: ${response.body()}")
                    response.body()
                        ?.let { api ->
                            api.results
                                ?.let { models ->
                                    removeAllUsers()
                                    models.forEach { model -> model?.let { insertUserFromAPI(it) } }
                                }
                        }
                }

                override fun onFailure(call: Call<APIModel>, t: Throwable) {
                    Toast.makeText(getApplication(), "${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        else
            Toast.makeText(getApplication(), "No internet available.", Toast.LENGTH_SHORT).show()
    }

    private fun insertUserFromAPI(model: Result) {
        var image = ""
        model.picture?.let {
            image = it.large ?: ""
        }
        model.name?.let {
            val fName = it.first
            val lName = it.last
            insert(UserTable(userName = (fName ?: "") + (lName ?: ""), imageLink = image))
        }
    }

    private val userRepository: UserRepository = UserRepository(application)
    private val users = userRepository.getUsers()

    private fun insert(model: UserTable) = userRepository.insert(model)

    fun getUsers() = users

    fun removeAllUsers() {
        userRepository.removeAllUsers()
    }

}