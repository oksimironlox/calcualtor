package com.example.application

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.application.databinding.FragmentCalculatorBinding
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorFragment : Fragment() {
    private var binding: FragmentCalculatorBinding? = null
    private var action: String? = null
    private enum class Actions (val symbol: String) {
        PLUS("+"), MINUS("-"), MULT("*"), SHARE("/"), EQUALS("=")
    }
    private var expression: String? = null
    private var result: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculatorBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getExpression(view)
    }

    private fun getExpression(view: View){
        val keyboard: ConstraintLayout = binding!!.keyboard

        for (i in 0 until keyboard.childCount) {
            val key: View = keyboard.getChildAt(i)
            if(key is Button){
                key.setOnClickListener {
                    if (key.text == "AC") {
                        expression = null
                        result = null
                    } else if (key.text == "=") {
                        try{
                            val ex = ExpressionBuilder(expression).build()
                            result = ex.evaluate().toLong().toString()
                        } catch (e: Exception){
                            Log.d("ошибка", "сообщение: ${e.message}")
                        }
                    } else {
                        if (expression == null)
                            expression = key.text.toString()
                        else
                            expression += key.text.toString()

                    }
                    binding!!.inputText.text = expression
                    binding!!.resultText.text = result
                }
            }
        }


    }


}