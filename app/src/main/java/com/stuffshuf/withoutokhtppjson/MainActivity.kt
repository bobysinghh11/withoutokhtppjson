package com.stuffshuf.withoutokhtppjson

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.UiThread
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnData.setOnClickListener {

            val newtworkTask=NetworkTask()
            newtworkTask.execute("https://api.github.com/search/users?q=Pulkit%20Aggarwal")

        }

    }

    inner class NetworkTask:AsyncTask<String,Int, String>() {


        override fun onPostExecute(result: String?) {

           getdata.text=result

       }



        override fun doInBackground(vararg urls: String?): String {

            val googleUrl:URL =URL(urls[0])
            val connection=googleUrl.openConnection() as HttpURLConnection
            val isr=InputStreamReader(connection.inputStream)
            val bufferReader=BufferedReader(isr)
            val sb=StringBuilder()
            var buffer:String? =""
            while (buffer!=null)
            {
                sb.append(buffer)
                buffer = bufferReader.readLine()
            }
            return sb.toString()


        }


    }

}


