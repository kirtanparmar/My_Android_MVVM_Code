package com.kirtan.codingtest_openxcell.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kirtan.codingtest_openxcell.R
import com.kirtan.codingtest_openxcell.databinding.ListViewBinding
import com.kirtan.codingtest_openxcell.db.UserTable

class UserListAdapter(
    diffUtil: DiffUtil.ItemCallback<UserTable>,
    private val listener: Callback
) :
    ListAdapter<UserTable, UserListAdapter.UserListView>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListView =
        UserListView(ListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: UserListView, position: Int) {
        holder.setData(getItem(position), listener)
    }

    class UserListView(private val view: ListViewBinding) : RecyclerView.ViewHolder(view.root) {
        fun setData(model: UserTable, listener: Callback) {
            view.model = model
            Glide.with(view.root).load(model.imageLink).placeholder(R.drawable.ic_person)
                .into(view.iv)
            view.root.setOnClickListener { listener.itemClicked(model) }
        }
    }

    public interface Callback {
        fun itemClicked(model: UserTable)
    }

}