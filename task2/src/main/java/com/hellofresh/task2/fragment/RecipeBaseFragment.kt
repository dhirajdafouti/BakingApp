package com.hellofresh.task2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class RecipeBaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}