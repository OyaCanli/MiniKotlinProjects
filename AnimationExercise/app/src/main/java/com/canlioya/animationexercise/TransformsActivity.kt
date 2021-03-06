package com.canlioya.animationexercise

import android.graphics.Rect
import android.os.Bundle
import android.transition.*
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tranforms.*

class TransformsActivity : AppCompatActivity() {

    lateinit var root: ViewGroup
    var magnified = false
    var scaleTypeChanged = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tranforms)

        root = findViewById(android.R.id.content)

        scale_transform_btn.setOnClickListener { changeScale() }

        scale_type_transform.setOnClickListener { changeScaleType() }

        clip_bounds_btn.setOnClickListener { clipBoundsAndScaleUp() }
    }

    private fun changeScale() {
        if (!magnified) {
            TransitionManager.beginDelayedTransition(root, ChangeTransform())
            tour_image.scaleX = 1.5f
            tour_image.scaleY = 1.5f
            magnified = true
        } else {
            TransitionManager.beginDelayedTransition(root, ChangeTransform())
            tour_image.scaleX = 1f
            tour_image.scaleY = 1f
            magnified = false
        }
    }

    private fun changeScaleType() {
        if (!scaleTypeChanged) {
            TransitionManager.beginDelayedTransition(root, ChangeImageTransform())
            tour_image.scaleType = ImageView.ScaleType.CENTER_INSIDE
            scaleTypeChanged = true
        } else {
            TransitionManager.beginDelayedTransition(root, ChangeImageTransform())
            tour_image.scaleType = ImageView.ScaleType.CENTER_CROP
            scaleTypeChanged = false
        }
    }

    private fun clipBoundsAndScaleUp() {
        val set = TransitionSet()
        set.addTransition(ChangeClipBounds())
            .addTransition(ChangeTransform())
        with(tour_image){
            clipBounds = Rect(300, 200, 800, 800)
            scaleX = 1.5f
            scaleY = 1.5f
        }
        TransitionManager.beginDelayedTransition(root, set)
    }
}
