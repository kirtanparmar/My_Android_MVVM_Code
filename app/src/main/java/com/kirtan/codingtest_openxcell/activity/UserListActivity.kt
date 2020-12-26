package com.kirtan.codingtest_openxcell.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirtan.codingtest_openxcell.adapter.UserListAdapter
import com.kirtan.codingtest_openxcell.databinding.ActivityMainBinding
import com.kirtan.codingtest_openxcell.db.UserTable

class UserListActivity : AppCompatActivity(), UserListAdapter.Callback {

    private lateinit var screen: ActivityMainBinding
    private lateinit var adapter: UserListAdapter
    private lateinit var viewModel: UserListActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screen = ActivityMainBinding.inflate(layoutInflater)
        setContentView(screen.root)

        screen.rv.layoutManager = LinearLayoutManager(this)
        adapter = UserListAdapter(object : DiffUtil.ItemCallback<UserTable>() {
            override fun areItemsTheSame(oldItem: UserTable, newItem: UserTable): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: UserTable, newItem: UserTable): Boolean {
                return oldItem.toString() == newItem.toString()
            }

        }, this)
        screen.rv.adapter = adapter

        viewModel =
            ViewModelProvider(
                this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
            ).get(UserListActivityViewModel::class.java)
        viewModel.getUsers().observe(this@UserListActivity, { adapter.submitList(it) })
    }

    override fun itemClicked(model: UserTable) {
        Toast.makeText(this, model.userName, Toast.LENGTH_SHORT).show()
    }

}