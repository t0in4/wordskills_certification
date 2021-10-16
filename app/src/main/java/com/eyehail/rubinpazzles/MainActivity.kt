package com.eyehail.rubinpazzles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonStart = findViewById<Button>(R.id.buttonStart)
        buttonStart.setOnClickListener {
            val intent = Intent(this, GameLevels::class.java)
            startActivity(intent)
        }
        //альтернативный вариант
        /*findViewById<Button>(R.id.buttonStart).setOnClickListener {

            val intent = Intent(this, GameLevels::class.java)
            startActivity(intent)
        }*/

        val w:Window = getWindow()
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
}