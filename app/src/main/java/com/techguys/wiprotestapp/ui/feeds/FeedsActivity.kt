package com.techguys.wiprotestapp.ui.feeds

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.techguys.wiprotestapp.R
import com.techguys.wiprotestapp.di.components.AppComponent
import com.techguys.wiprotestapp.ui.base.BaseActivity
import com.techguys.wiprotestapp.ui.models.Feed
import com.techguys.wiprotestapp.ui.models.UIState
import kotlinx.android.synthetic.main.activity_feeds.*
import javax.inject.Inject

class FeedsActivity : BaseActivity() {

    @Inject
    lateinit var feedsViewModelFactory: FeedsViewModel.FeedsViewModelFactory

    private lateinit var feedsViewModel: FeedsViewModel
    private lateinit var viewAdapter: FeedsRecyclerViewAdapter

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plusViewComponent().inject(this)
    }

    override fun getActivityLayout(): Int = R.layout.activity_feeds

    override fun init(savedInstanceState: Bundle?) {
        setupRecyclerView()
        setupViewModel(savedInstanceState)
    }

    private fun setupRecyclerView() {
        viewAdapter = FeedsRecyclerViewAdapter()
        feedsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@FeedsActivity)
            adapter = viewAdapter
        }
    }


    private fun setupViewModel(savedInstanceState: Bundle?) {

        feedsViewModel = ViewModelProviders.of(this, feedsViewModelFactory).get(FeedsViewModel::class.java)

        if (savedInstanceState == null) feedsViewModel.fetchFeeds()

        feedsViewModel.getFeeds().observe(this, Observer { uiState ->

            when (uiState) {
                is UIState.Loading -> {
                    progressLayout.visibility = View.VISIBLE
                }
                is UIState.Success -> {
                    viewAdapter.addItems(uiState.data.rows!!)
                    progressLayout.visibility = View.GONE
                }
                is UIState.Error -> {
                    progressLayout.visibility = View.GONE
                    val msg = uiState.error.message
                    msg?.let { showToast(msg) }
                }
            }
        })
    }
}
