package com.techguys.wiprotestapp.ui.models

sealed class UIState<out T: Any>{
    object Loading: UIState<Nothing>()
    data class Success<out T: Any>(val data: T): UIState<T>()
    data class Error(val error: Throwable): UIState<Nothing>()
}