package com.lamarck.mymvvm.repositories

import com.lamarck.mymvvm.rest.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {


    fun getAllLives() = retrofitService.getAllLives()


}