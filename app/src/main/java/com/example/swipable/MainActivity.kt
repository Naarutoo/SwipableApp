package com.example.swipable

import Data
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var adapter: TextAdapter
    var manager: LinearLayoutManager? = null

    lateinit var list: ArrayList<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val strData = StringBuffer()


        CoroutineScope(Dispatchers.IO).launch {
            val data = Network.getRetrofitInstance().create(ApiService::class.java).getData()


            for (i in data.indices) {
                if (data[i] == '/') {
                    continue
                } else {
                    strData.append(data[i])
                }
            }
            Log.d("shubham", strData.toString())

            try {

                val jsonObject = JSONObject(strData.toString())
                val jsonArrayData = jsonObject.getJSONArray("data")
                Log.d(TAG, "buildResponseModel: ${jsonArrayData.get(0)}")
                val dataList: ArrayList<Data> = ArrayList()
                for (i in 0 until jsonArrayData.length()) {
                    val dataResponse = jsonArrayData.getJSONObject(i)
                    val id = dataResponse.getString("id")
                    val text = dataResponse.getString("text")
                    val data = Data(id, text)
                    dataList.add(data)

                }
                for(i in dataList) {
                    Log.d("saurabh", "create: ${i.id}")
                }




            } catch (e: JSONException) {
                Log.d("shubham", e.toString())
            }


        }
        setrecycleview()
    }

    private fun setrecycleview() {
        recycleview.apply {
            adapter = TextAdapter(list)
           manager = LinearLayoutManager(this@MainActivity)
        }
        }
    }


