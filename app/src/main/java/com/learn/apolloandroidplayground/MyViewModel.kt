package com.learn.apolloandroidplayground

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.toFlow
import com.apollographql.apollo.exception.ApolloException
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {

    val job = Job(viewModelScope.coroutineContext[Job])
    val repo = Repo()

    fun getData() {
        viewModelScope.launch(job) {
            repo.getData()
                .collect {
                    println(it)
                }
        }
    }

    fun cancel() {
        job.cancelChildren()
    }

}