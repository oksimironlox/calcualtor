package com.example.application

import android.view.View
import androidx.lifecycle.ViewModel

public class Calculator {

    private var result: Int = 0

    public fun plus(first: Int, second: Int): Int{
        result = first + second
        return result
    }

    public fun minus(first: Int, second: Int): Int{
        result = first - second
        return result
    }

    public fun share(first: Int, second: Int): Int{
        result = first / second
        return result
    }

    public fun multyply(first: Int, second: Int): Int{
        result = first * second
        return result
    }

    public fun equals(first: Int, second: Int): Int {
        var num: Int = result
        result = 0
        return num
    }
}