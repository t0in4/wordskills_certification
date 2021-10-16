package com.eyehail.rubinpazzles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var backPressedTime: Long = 0L

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

        val w: Window = getWindow()
        w.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
    //Double tap back to exit android - start
    override fun onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {

            super.onBackPressed()
            return
        } else {
            //implement retrieving string from values (for translation in future)
            Toast.makeText(getBaseContext(), getString(R.string.exitTwice), Toast.LENGTH_SHORT).show()
        }
            backPressedTime = System.currentTimeMillis()
        }
    //Double tap back to exit android - end


}