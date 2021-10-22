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

class Level1 : AppCompatActivity() {
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.universal)
        //set screen on whole screen - start
        val w: Window = getWindow()
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //set screen on whole screen - end

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




    }
}