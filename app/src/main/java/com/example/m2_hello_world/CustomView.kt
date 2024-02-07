package com.example.m2_hello_world

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

class CustomView @JvmOverloads constructor(
    context:Context,
    attrs: AttributeSet? = null,
    attributeStyle: Int = 0
) : RelativeLayout(context, attrs, attributeStyle){

    private var topTextView: TextView? = null
    private var bottomTextView: TextView? = null

    init {
        val padding = dpToPx(15)

        // Создаем первый контейнер
        val firstContainer = LinearLayout(context).apply {
            id = generateViewId()
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            orientation = LinearLayout.HORIZONTAL
            setPadding(padding, padding, padding, padding)
        }

        // Создаем черный квадрат внутри первого контейнера
        val imageProfile = ImageView(context).apply {
            layoutParams = LayoutParams(dpToPx(150), dpToPx(150))
            setBackgroundColor(Color.BLACK)
        }
        firstContainer.addView(imageProfile)

        // Создаем второй контейнер внутри первого
        val textContainer = LinearLayout(context).apply {
            layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            orientation = LinearLayout.VERTICAL
            setPadding(padding, 0, 0, 0)
        }

        // Создаем текстовые поля
        topTextView = TextView(context).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 25f
            setPadding(0, dpToPx(25), 0, 0)
            setTextColor(Color.BLACK)
        }
        textContainer.addView(topTextView)

        bottomTextView = TextView(context).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            setPadding(0, dpToPx(25), 0, 0)
            textSize = 25f
            setTextColor(Color.BLACK)
        }
        textContainer.addView(bottomTextView)

        firstContainer.addView(textContainer)
        addView(firstContainer)

        // Создаем нижний контейнер
        val bottomContainer = LinearLayout(context).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            setPadding(padding, 0, padding, padding)
        }

        // Добавляем изображение внутри нижнего контейнера
        val greyBack = ImageView(context).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            setBackgroundColor(Color.GRAY)
        }
        bottomContainer.addView(greyBack)

        val bottomContainerParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        bottomContainerParams.addRule(BELOW, firstContainer.id)
        bottomContainer.layoutParams = bottomContainerParams

        addView(bottomContainer)
    }

    fun setTopText(text: String) {
        topTextView?.text = text
    }

    fun setBottomText(text: String) {
        bottomTextView?.text = text
    }

    private fun dpToPx(dp: Int): Int {
        return (dp * resources.displayMetrics.density).toInt()
    }
}