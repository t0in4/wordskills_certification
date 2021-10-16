package com.eyehail.rubinpazzles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button

class GameLevels : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gamelevels)
        val w:Window = getWindow()
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        findViewById<Button>(R.id.button_back).setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }

   // system back button changed - start
    override fun onBackPressed() {
        super.onBackPressed()
        findViewById<Button>(R.id.button_back).setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
    //system back button changed - end




}