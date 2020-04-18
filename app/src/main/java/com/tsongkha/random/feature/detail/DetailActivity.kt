package com.tsongkha.random.feature.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tsongkha.random.R
import com.tsongkha.random.common.domain.User
import com.tsongkha.random.feature.detail.epoxy.DetailController

private const val EXTRA_USER = "user"
private const val EXTRA_BUNDLE = "bundle"

class DetailActivity : AppCompatActivity() {

    companion object {
        fun start(activity: Activity, user: User) {
            activity.startActivity(
                Intent(
                    activity,
                    DetailActivity::class.java
                ).putExtra(
                    EXTRA_BUNDLE, bundleOf(
                        EXTRA_USER to user
                    )
                )
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show()
        val recyclerView = findViewById<RecyclerView>(R.id.contentRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val controller = DetailController()

        val bundle = requireNotNull(intent.getBundleExtra(EXTRA_BUNDLE))
        val user = requireNotNull(bundle.getParcelable<User>(EXTRA_USER))

        recyclerView.adapter = controller.adapter
        controller.setData(
            user
        )
    }
}