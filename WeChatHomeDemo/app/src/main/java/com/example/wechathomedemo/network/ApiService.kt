// src/main/java/com/example/wechathomedemo/network/ApiService.kt
package com.example.wechathomedemo.network

import com.example.wechathomedemo.model.ChatItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("path/to/your/json")
    fun getChatItems(): Call<List<ChatItem>>
}