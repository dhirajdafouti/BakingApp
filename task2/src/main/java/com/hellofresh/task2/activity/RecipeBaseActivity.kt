package com.hellofresh.task2.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Recipe list Base Activity which will have the all the common implementation
 * and all the activities will extend this base class.
 */
abstract class RecipeBaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onDestroy() {
        super.onDestroy()
    }

}