package com.example.mvvm.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class BaseViewModel : ViewModel() {
    /**
     * this is the job for all coroutines started by this viewmodel
     *
     * cancelling this job will cancel all coroutines started
     * by this viewmodel
     * by getValue
     * */
    private val viewModeljob : Job by lazy { Job() }



    private val isShowLoading = MutableLiveData<Boolean>()
    private val showError = MutableLiveData<String>()
    private val compositeDisposable = Com
    fun setLoading(isLoading : Boolean? = true){
        isShowLoading.value = isLoading
    }
    fun showError(error : String?){

    }
    val viewModelScope : CoroutineScope? by lazy {
        CoroutineScope(Dispatchers.Main + viewModeljob as Job)
    }



}