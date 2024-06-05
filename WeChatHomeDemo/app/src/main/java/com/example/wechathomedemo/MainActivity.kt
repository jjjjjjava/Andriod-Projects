package com.example.wechathomedemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wechathomedemo.adapter.ChatAdapter
import com.example.wechathomedemo.databinding.ActivityMainBinding
import com.example.wechathomedemo.model.ChatItem
import com.example.wechathomedemo.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        fetchChatItems()
    }

    private fun fetchChatItems() {
        RetrofitClient.instance.getChatItems().enqueue(object : Callback<List<ChatItem>> {
            override fun onResponse(call: Call<List<ChatItem>>, response: Response<List<ChatItem>>) {
                if (response.isSuccessful) {
                    val chatItems = response.body() ?: emptyList()
                    binding.recyclerView.adapter = ChatAdapter(chatItems)
                } else {
                    Toast.makeText(this@MainActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ChatItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
