package com.lamarck.mymvvm.viewmodel.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lamarck.mymvvm.model.Live
import com.lamarck.mymvvm.repositories.MainRepository
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainViewModel constructor(private val repository: MainRepository): ViewModel() {

    val liveList = MutableLiveData<List<Live>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllLives(){
        val request = repository.getAllLives()
        request.enqueue(object: retrofit2.Callback<List<Live>>{
            override fun onResponse(call: Call<List<Live>>, response: Response<List<Live>>) {
                //Quando houver uma resposta
                liveList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Live>>, t: Throwable) {
                //Quando houver uma falha na chamada
                errorMessage.postValue(t.message)
            }

        })

    }

}