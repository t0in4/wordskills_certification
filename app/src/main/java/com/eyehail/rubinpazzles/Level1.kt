package com.eyehail.rubinpazzles

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.properties.Delegates
import kotlin.random.Random

class Level1 : AppCompatActivity() {
    lateinit var dialog: Dialog
    lateinit var dialogEnd: Dialog
    var numLeft: Int = 0 // variable for left picture
    var numRight: Int = 0 //variable for right picture
    var count: Int = 0  //variable for counter

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.universal)
        //making text levels variable - start
        val text_levels = findViewById<TextView>(R.id.text_levels)
        text_levels.setText(R.string.level1) //setting text

        //making text levels variable - end

        //set screen on whole screen - start
        val w: Window = getWindow()
        w.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
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
        dialog.getWindow()
            ?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) // making dialog window background transparent
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

        //progress bar - start
        var progress = mutableListOf(R.id.point1, R.id.point2, R.id.point3, R.id.point4,
        R.id.point5, R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
        R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15, R.id.point16,
        R.id.point17, R.id.point18, R.id.point19, R.id.point20)



        //progress bar - end

        //switch on animation - start
        val a: Animation = AnimationUtils.loadAnimation(this, R.anim.alpha)
        //switch on animation - end

        //button "Continue" - start
        val btncontinue = dialog.findViewById<Button>(R.id.btncontinue)
        btncontinue.setOnClickListener {
            dialog.dismiss() //closing dialog window
        }
        //button "Continue" - end

        dialog.show() // show dialog window

        //______________________________
        //end dialog window - start
        //calling dialog window - start
        dialogEnd = Dialog(this) //creating new dialog window
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE) //we don't need to use title
        dialogEnd.setContentView(R.layout.dialogend)// path to dialog window
        dialogEnd.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) // making dialog window background transparent
        dialogEnd.getWindow()?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
        dialogEnd.setCancelable(false) // prevent user to close dialog window by system back button
        //button which closes the dialog window - start
        val btnclose2 = dialogEnd.findViewById<TextView>(R.id.btnclose)
        btnclose2.setOnClickListener {
            val intent = Intent(this, Level2::class.java)
            startActivity(intent)
            finish() //close this class
            dialogEnd.dismiss() //close the dialog window
        }
        //button which closes the dialog window - end

        //progress bar - start
       /* var progress = mutableListOf(R.id.point1, R.id.point2, R.id.point3, R.id.point4,
            R.id.point5, R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
            R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15, R.id.point16,
            R.id.point17, R.id.point18, R.id.point19, R.id.point20)*/



        //progress bar - end

        /*//switch on animation - start
        val a: Animation = AnimationUtils.loadAnimation(this, R.anim.alpha)
        //switch on animation - end*/

        //button "Continue" - start
        val btncontinue2 = dialogEnd.findViewById<Button>(R.id.btncontinue)
        btncontinue2.setOnClickListener {
            var intent = Intent(this, Level2::class.java)
                    startActivity(intent)
                    finish()
            dialogEnd.dismiss() //closing dialog window
        }
        //button "Continue" - end



        //end dialog window - end
        //___________________________________________

        numLeft = (0 until 10).random()

        findViewById<ImageView>(R.id.image_left).setImageResource(Array.images1[numLeft]) // set image to left
        findViewById<TextView>(R.id.text_left).setText(Array.texts1[numLeft]) // set left text under image


        numRight = (0 until 10).random()
        while (numLeft == numRight) {
            numRight = (0 until 10).random()
        }
        findViewById<ImageView>(R.id.image_right).setImageResource(Array.images1[numRight])
        findViewById<TextView>(R.id.text_right).setText(Array.texts1[numRight])

        //making left picture clickable - start
        findViewById<ImageView>(R.id.image_left).setOnTouchListener { view, motionEvent ->
           if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                findViewById<ImageView>(R.id.image_right).setEnabled(false)
                if (numLeft > numRight) {
                    findViewById<ImageView>(R.id.image_left).setImageResource(R.drawable.img_true)
                } else {
                    findViewById<ImageView>(R.id.image_left).setImageResource(R.drawable.img_false)
                }
            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                if (numLeft > numRight) {
                    if (count < 20) {
                        count = count+1
                    }
                    for (i in 0 until 20) {
                        var tv = findViewById<TextView>(progress[i])
                            tv.setBackgroundResource(R.drawable.style_points)
                    }
                    for (i in 0 until count) {
                        var tv = findViewById<TextView>(progress[i])
                            tv.setBackgroundResource(R.drawable.style_points_green)
                    }
                } else {
                    //if left image is smaller
                    if (count > 0) {
                        if (count == 1) {
                            count = 0
                        } else {
                            count = count - 2
                        }
                    }
                    for (i in 0 until 19) {
                        var tv = findViewById<TextView>(progress[i])
                        tv.setBackgroundResource(R.drawable.style_points)
                    }
                    for (i in 0 until count) {
                        var tv = findViewById<TextView>(progress[i])
                        tv.setBackgroundResource(R.drawable.style_points_green)
                    }
                }
                    //exit from level - start
                    if (count == 20) {
                        dialogEnd.show() // showing end dialog and continue to level 2

                    } else {
                        numLeft = (0 until 10).random() //generating random

                        findViewById<ImageView>(R.id.image_left).setImageResource(Array.images1[numLeft]) // set image to left
                        findViewById<ImageView>(R.id.image_left).startAnimation(a)
                        findViewById<TextView>(R.id.text_left).setText(Array.texts1[numLeft]) // set left text under image


                        numRight = (0 until 10).random()
                        while (numLeft == numRight) {
                            numRight = (0 until 10).random()
                        }
                        findViewById<ImageView>(R.id.image_right).setImageResource(Array.images1[numRight])
                        findViewById<ImageView>(R.id.image_right).startAnimation(a)
                        findViewById<TextView>(R.id.text_right).setText(Array.texts1[numRight])
                        findViewById<ImageView>(R.id.image_right).setEnabled(true) //enable right image

                    }
                    //exit from level - end



            }
            //return@setOnTouchListener true
            true // as in https://stuff.mit.edu/afs/sipb/project/android/docs/reference/android/view/MotionEvent.html
        }


        //making left picture clickable - end

        //making right picture clickable - start
        findViewById<ImageView>(R.id.image_right).setOnTouchListener { view, motionEvent ->
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                findViewById<ImageView>(R.id.image_left).setEnabled(false) //blocking left image
                if (numLeft < numRight) {
                    findViewById<ImageView>(R.id.image_right).setImageResource(R.drawable.img_true)
                } else {
                    findViewById<ImageView>(R.id.image_right).setImageResource(R.drawable.img_false)
                }
            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                if (numLeft < numRight) {
                    if (count < 20) {
                        count = count+1
                    }
                    for (i in 0 until 20) {
                        var tv = findViewById<TextView>(progress[i])
                        tv.setBackgroundResource(R.drawable.style_points)
                    }
                    for (i in 0 until count) {
                        var tv = findViewById<TextView>(progress[i])
                        tv.setBackgroundResource(R.drawable.style_points_green)
                    }
                } else {
                    //if right image is smaller
                    if (count > 0) {
                        if (count == 1) {
                            count = 0
                        } else {
                            count = count - 2
                        }
                    }
                    for (i in 0 until 19) {
                        var tv = findViewById<TextView>(progress[i])
                        tv.setBackgroundResource(R.drawable.style_points)
                    }
                    for (i in 0 until count) {
                        var tv = findViewById<TextView>(progress[i])
                        tv.setBackgroundResource(R.drawable.style_points_green)
                    }
                }
                //exit from level - start
                if (count == 20) {
                    dialogEnd.show() // showing end dialog and continue to level 2

                } else {
                    numLeft = (0 until 10).random() //generating random

                    findViewById<ImageView>(R.id.image_left).setImageResource(Array.images1[numLeft]) // set image to left
                    findViewById<ImageView>(R.id.image_left).startAnimation(a)
                    findViewById<TextView>(R.id.text_left).setText(Array.texts1[numLeft]) // set left text under image


                    numRight = (0 until 10).random()
                    while (numLeft == numRight) {
                        numRight = (0 until 10).random()
                    }
                    findViewById<ImageView>(R.id.image_right).setImageResource(Array.images1[numRight])
                    findViewById<ImageView>(R.id.image_right).startAnimation(a)
                    findViewById<TextView>(R.id.text_right).setText(Array.texts1[numRight])
                    findViewById<ImageView>(R.id.image_left).setEnabled(true) //enable left image

                }
                //exit from level - end



            }
            //return@setOnTouchListener true
            true // as in https://stuff.mit.edu/afs/sipb/project/android/docs/reference/android/view/MotionEvent.html
        }


        //making right picture clickable - end


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


