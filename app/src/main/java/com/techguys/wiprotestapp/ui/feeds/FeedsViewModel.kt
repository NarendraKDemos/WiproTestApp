package com.techguys.wiprotestapp.ui.feeds

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.techguys.wiprotestapp.ui.models.Feeds
import com.techguys.wiprotestapp.data.repositories.IFeedsRepository
import com.techguys.wiprotestapp.ui.base.BaseViewModel
import com.techguys.wiprotestapp.ui.models.UIState
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class FeedsViewModel(private val feedsRepository: IFeedsRepository) : BaseViewModel() {

    private val feedsLiveData: MutableLiveData<UIState<Feeds>> = MutableLiveData()
    private var disposable: Disposable? = null


    /*init {
        fetchFeeds()
    }*/

    fun getFeeds(): LiveData<UIState<Feeds>> {
        return feedsLiveData
    }

    fun fetchFeeds() {
        feedsLiveData.postValue(UIState.Loading)
        disposable = feedsRepository
            .fetchFeeds()
            .subscribe(
            {
                feedsLiveData.postValue(UIState.Success(Feeds(it.title, it.rows)))
            },
            {
                feedsLiveData.postValue(UIState.Error(it))
            })
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }


    class FeedsViewModelFactory @Inject constructor(private val feedsRepository: IFeedsRepository) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return FeedsViewModel(feedsRepository) as T
        }

    }
}