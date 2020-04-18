package com.tsongkha.random.feature.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tsongkha.random.R
import com.tsongkha.random.common.application.ApplicationScope
import com.tsongkha.random.feature.list.epoxy.PagedUserController
import toothpick.ktp.KTP
import javax.inject.Inject

class UserListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: UserListViewModel

    private val epoxyController: PagedUserController by lazy {
        PagedUserController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        KTP.openScopes(ApplicationScope::class.java)
            .inject(this)

        val recyclerView = findViewById<RecyclerView>(R.id.usersRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = epoxyController.adapter

        viewModel.pagedList.observe(this, Observer { newList -> epoxyController.submitList(newList) })
    }
}