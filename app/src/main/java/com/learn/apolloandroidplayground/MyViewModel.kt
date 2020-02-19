package com.learn.apolloandroidplayground

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.toFlow
import com.apollographql.apollo.exception.ApolloException
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

class MyViewModel: ViewModel() {

    val repo = Repo()

    val scope = CoroutineScope(Dispatchers.Main)

    fun getData() {
        scope.launch {
            repo.getData()
                .collect {
                    println(it)
                }
        }
    }

    fun cancel() {
        scope.cancel()
    }

}