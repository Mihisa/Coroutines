package com.example.coroutines

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.buttonStartActivity)

        button.setOnClickListener {
            lifecycleScope.launch {
                while (true) {
                    delay(1000L)
                    Log.d(TAG, "Still running...")
                }
            }
            GlobalScope.launch {
                delay(5000L)
                Intent(this@MainActivity, SecondActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }

    suspend fun networkCall1(): String {
        delay(3000L)
        return "Answer 1"
    }

    suspend fun networkCall2(): String {
        delay(3000L)
        return "Answer 2"
    }
}



//runBlocking {
//    delay(1000L)
//    GlobalScope.launch {
//        Log.d(TAG, "run 1")
//    }
//    delay(1000L)
//    doSomething()
//    GlobalScope.launch {
//        delay(1000L)
//        Log.d(TAG, "run 2")
//    }
//    Log.d(TAG, "run 3")
//}
//Log.d(TAG, "run 4")


//suspend fun doSomething() {
//    Log.d(TAG, "run 5")
//    delay(1000L)
//}