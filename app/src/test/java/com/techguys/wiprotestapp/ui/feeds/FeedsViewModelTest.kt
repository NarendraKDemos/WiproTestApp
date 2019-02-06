package com.techguys.wiprotestapp.ui.feeds

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.techguys.wiprotestapp.data.remote.models.FeedsResponse
import com.techguys.wiprotestapp.data.repositories.IFeedsRepository
import com.techguys.wiprotestapp.ui.models.Feed
import com.techguys.wiprotestapp.ui.models.Feeds
import com.techguys.wiprotestapp.ui.models.UIState
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class FeedsViewModelTest{

    @Mock lateinit var liveDataObserver: Observer<UIState<Feeds>>

    @Mock lateinit var iFeedsRepository: IFeedsRepository

    private lateinit var feedsViewModel: FeedsViewModel

    @Rule @JvmField
    var rule: TestRule = InstantTaskExecutorRule()


    @Before
    fun setUp(){
        feedsViewModel = FeedsViewModel(iFeedsRepository)
    }

    @Test
    fun fetchFeedsShouldShowLoadingState() {
        feedsViewModel.getFeeds().observeForever(liveDataObserver)
        val feedsResponse = FeedsResponse()
        `when`(iFeedsRepository.fetchFeeds()).thenReturn(Single.create {
            it.onSuccess(feedsResponse)
        })
        feedsViewModel.fetchFeeds()
        verify(liveDataObserver).onChanged(UIState.Loading)
    }

    @Test
    fun fetchFeedsOnSuccessShouldShowFeeds(){
        feedsViewModel.getFeeds().observeForever(liveDataObserver)
        val rows = mutableListOf<Feed>()
        val feedsResponse = FeedsResponse("title", rows)
        `when`(iFeedsRepository.fetchFeeds()).thenReturn(Single.create {
            it.onSuccess(feedsResponse)
        })
        feedsViewModel.fetchFeeds()
        verify(liveDataObserver).onChanged(UIState.Loading)
        verify(liveDataObserver).onChanged(UIState.Success(Feeds("title", rows)))
    }

    @Test
    fun fetchFeedsOnErrorShouldShowError(){
        feedsViewModel.getFeeds().observeForever(liveDataObserver)
        val exception = RuntimeException("Some error occurred")
        `when`(iFeedsRepository.fetchFeeds()).thenReturn(Single.create {
            it.onError(exception)
        })
        feedsViewModel.fetchFeeds()
        verify(liveDataObserver).onChanged(UIState.Loading)
        verify(liveDataObserver).onChanged(UIState.Error(exception))
    }


}