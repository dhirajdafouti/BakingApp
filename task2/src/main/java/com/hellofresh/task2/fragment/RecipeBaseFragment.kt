package com.hellofresh.task2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * This class is the base Fragment class which will have the common implementation of all the fragment.
 * The  fragment will only extend this class.
 */
abstract class RecipeBaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}