package com.hellofresh.task2.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest

fun startNetworkCallback(application: Context): Boolean {
    var isNetworkConnected: Boolean=true
    val cm: ConnectivityManager =
        application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val builder: NetworkRequest.Builder = NetworkRequest.Builder()

    cm.registerNetworkCallback(
        builder.build(),
        object : ConnectivityManager.NetworkCallback() {

            override fun onAvailable(network: Network) {
                isNetworkConnected = true
            }

            override fun onLost(network: Network) {
                isNetworkConnected = false
            }
        })
    return isNetworkConnected
}