package com.example.projectlast

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import android.graphics.drawable.TransitionDrawable
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat
import android.graphics.Color

class MainActivity : ComponentActivity() {
    private lateinit var imageView: ImageView
    private var currentDrawableId: Int = R.drawable.image1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageView)
        setupButtonListeners()
        startInitialImageTransition()
    }

    private fun setupButtonListeners() {
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        button1.setOnClickListener { transitionImage(R.drawable.image1) }
        button2.setOnClickListener { transitionImage(R.drawable.image2) }
        button3.setOnClickListener { transitionImage(R.drawable.image3) }
    }

    private fun transitionImage(newDrawableId: Int) {
        val currentDrawable = ContextCompat.getDrawable(this, currentDrawableId)
        val newDrawable = ContextCompat.getDrawable(this, newDrawableId)
        val transitionDrawable = TransitionDrawable(arrayOf(currentDrawable, newDrawable))
        imageView.setImageDrawable(transitionDrawable)
        transitionDrawable.startTransition(500)
        currentDrawableId = newDrawableId
    }

    private fun startInitialImageTransition() {
        val transparentDrawable = ColorDrawable(Color.TRANSPARENT)
        val initialDrawable = ContextCompat.getDrawable(this, currentDrawableId)
        val transitionDrawable = TransitionDrawable(arrayOf(transparentDrawable, initialDrawable))
        imageView.setImageDrawable(transitionDrawable)
        transitionDrawable.startTransition(1000)
    }
}
