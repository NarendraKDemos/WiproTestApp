package com.techguys.wiprotestapp.ui.feeds

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.techguys.wiprotestapp.R
import com.techguys.wiprotestapp.di.components.AppComponent
import com.techguys.wiprotestapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_feeds.*
import javax.inject.Inject

class FeedsActivity : BaseActivity() {

    @Inject
    lateinit var mainViewModelFactory: FeedsViewModel.FeedsViewModelFactory

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plusViewComponent().inject(this)
    }

    override fun getActivityLayout(): Int = R.layout.activity_feeds

    override fun init(savedInstanceState: Bundle?) {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        feedsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@FeedsActivity)
            //adapter = viewAdapter
        }
    }
}
