package com.eyehail.rubinpazzles

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.properties.Delegates
import kotlin.random.Random

class Level1 : AppCompatActivity() {
    lateinit var dialog: Dialog
    var numLeft: Int = 0 // variable for left picture
    var numRight: Int = 0 //variable for right picture

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.universal)
        //making text levels variable - start
        val text_levels = findViewById<TextView>(R.id.text_levels)
        text_levels.setText(R.string.level1) //setting text


        //making text levels variable - end

        //set screen on whole screen - start
        val w: Window = getWindow()
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //set screen on whole screen - end

        //button to back to main screen - start
        findViewById<Button>(R.id.button_back).setOnClickListener {

            val intent = Intent(this, GameLevels::class.java)
            startActivity(intent)
        }
        //button to back to main screen - end

        //making corners round to image_left - start
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            findViewById<ImageView>(R.id.image_left).setClipToOutline(true)
        }
        //making corners round to image_left - end

        //making corners round to image_left - start
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            findViewById<ImageView>(R.id.image_right).setClipToOutline(true)
        }
        //making corners round to image_left - end

        //calling dialog window - start
        dialog = Dialog(this) //creating new dialog window
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) //we don't need to use title
        dialog.setContentView(R.layout.previewdialog)// path to dialog window
        dialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) // making dialog window background transparent
        dialog.setCancelable(false) // prevent user to close dialog window by system back button
        //button which closes the dialog window - start
        val btnclose = dialog.findViewById<TextView>(R.id.btnclose)
        btnclose.setOnClickListener {
            val intent = Intent(this, GameLevels::class.java)
            startActivity(intent)
            finish() //close this class
            dialog.dismiss() //close the dialog window
        }
        //button which closes the dialog window - end

        //button "Continue" - start
        val btncontinue = dialog.findViewById<Button>(R.id.btncontinue)
        btncontinue.setOnClickListener{
            dialog.dismiss() //closing dialog window
        }
        //button "Continue" - end

        dialog.show() // show dialog window

        numLeft = (0 until 10).random()

        findViewById<ImageView>(R.id.image_left).setImageResource(Array.images1[numLeft]) // set image to left
        findViewById<TextView>(R.id.text_left).setText(Array.texts1[numLeft]) // set left text under image


        numRight = (0 until 10).random()
        while(numLeft==numRight) {
            numRight = (0 until 10).random()
        }
        findViewById<ImageView>(R.id.image_right).setImageResource(Array.images1[numRight])
        findViewById<TextView>(R.id.text_right).setText(Array.texts1[numRight])




    }

    // system back button changed - start
    override fun onBackPressed() {
        super.onBackPressed()
        findViewById<Button>(R.id.button_back).setOnClickListener {

            val intent = Intent(this, GameLevels::class.java)
            startActivity(intent)

        }
    }
    //system back button changed - end
}