package com.example.advancedgraphicsandviewscodelab

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openFanController.setOnClickListener { launchFanControllerActivity() }
        openCanvasEx.setOnClickListener { launchCanvasExample() }
        openFreeWriting.setOnClickListener { launchFreeWritingActivity() }
        openClipPath.setOnClickListener { launchClipPathActivity() }
    }

    private fun launchClipPathActivity() {
        val intent = Intent(this, ClipPathActivity::class.java)
        startActivity(intent)
    }

    private fun launchFreeWritingActivity() {
        val intent = Intent(this, FreeWritingActivity::class.java)
        startActivity(intent)
    }

    private fun launchCanvasExample() {
        val intent = Intent(this, CanvasExampleActivity::class.java)
        startActivity(intent)
    }

    private fun launchFanControllerActivity() {
        val intent = Intent(this, FanControllerActivity::class.java)
        startActivity(intent)
    }
}