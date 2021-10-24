package com.hellofresh.task2

import android.app.Application
import android.content.Context

class RecipeMainApplication : Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: RecipeMainApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

}