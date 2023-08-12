package com.example.narutotrap.narutoViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.narutotrap.network.AllCharacters
import com.example.narutotrap.network.NarutoApi
import com.example.narutotrap.network.NarutoCharacters
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class NarutoViewModel : ViewModel() {
    private val _status = MutableLiveData<NarutoApiStatus>()
    private val _characters = MutableLiveData<List<NarutoCharacters>>()
    val characters: LiveData<List<NarutoCharacters>> = _characters

    enum class NarutoApiStatus { LOADING, ERROR, DONE }
    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            _status.value = NarutoApiStatus.LOADING
            try {
                _characters.value = NarutoApi.retrofitService.getAllСharacter().characters
                _status.value = NarutoApiStatus.DONE
            } catch (e: Exception) {
                _status.value = NarutoApiStatus.ERROR
                _characters.value = listOf()
            }
        }
    }
}