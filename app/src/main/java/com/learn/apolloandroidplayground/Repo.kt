package com.learn.apolloandroidplayground

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.toFlow
import kotlinx.coroutines.flow.Flow

class Repo {

    fun getData(): Flow<Response<TestQuery.Data>> {
        val client = ApolloClient.builder().serverUrl("https://api.kivaws.org/graphql").build()
        return client.query(TestQuery.builder().build()).toFlow()
    }

}
