package com.canlioya.customviewexercise.donut

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.canlioya.customviewexercise.R


class PizzaView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var pizzaStrokeWidth = 6f
    var numberOfPieces = 6
    var pizzaColor = Color.MAGENTA

    val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        attrs?.let{
            val array : TypedArray = context.obtainStyledAttributes(it,
                R.styleable.PizzaView
            )
            pizzaStrokeWidth = array.getDimensionPixelSize(R.styleable.PizzaView_stroke_width, 6).toFloat()
            pizzaColor = array.getColor(R.styleable.PizzaView_pizza_color, pizzaColor)
            numberOfPieces = array.getInt(R.styleable.PizzaView_num_pieces, 6)
            array.recycle()
        }
            paint.apply {
                style = Paint.Style.STROKE
                strokeWidth = pizzaStrokeWidth
                color = pizzaColor
            }
    }

    override fun onDraw(canvas: Canvas?) {
        val width = width - paddingStart - paddingEnd
        val height = height - paddingTop - paddingBottom
        val centerX = (width / 2 + paddingStart).toFloat()
        val centerY = (height / 2 + paddingEnd).toFloat()
        val radius = (width.coerceAtMost(height) - pizzaStrokeWidth).toFloat() / 2
        canvas?.drawCircle(centerX, centerY, radius, paint)
        drawPizzaCuts(canvas, centerX, centerY, radius)
    }

    fun drawPizzaCuts(canvas : Canvas?, cX : Float, cY : Float, radius : Float){
        val rotationAngle = 360f / numberOfPieces
        canvas?.save()
        for( i in 0 until numberOfPieces){
            canvas?.rotate(rotationAngle, cX, cY)
            canvas?.drawLine(cX, cY, cX, cY + radius, paint)
        }
        canvas?.restore()
    }
}