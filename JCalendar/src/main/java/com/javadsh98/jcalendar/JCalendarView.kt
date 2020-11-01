package com.javadsh98.jcalendar

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class JCalendarView :ConstraintLayout {

    private var nameOfWeekTextColorSelected: Int = -1
    private var dayOfMonthTextColorSelected: Int = -1
    private var backgroundResSelected: Drawable? = null

    private var nameOfWeekTextColorNormal: Int = -1
    private var dayOfMonthTextColorNormal: Int = -1
    private var backgroundResNormal: Drawable? = null

    private var nameOfMonthTextColor: Int = -1

    private var gregorianListener: JGregorianListener? = null
    private var jalaliListener: JJalaliListener? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setNameOfWeekTextColorNormal(textcolor: Int): JCalendarView{
        nameOfWeekTextColorNormal = textcolor
        return this
    }

    fun setNameOfWeekTextColorSelected(textcolor: Int): JCalendarView{
        nameOfWeekTextColorSelected = textcolor
        return this
    }

    fun setDayOfMonthTextColorSelected(textcolor: Int): JCalendarView{
        dayOfMonthTextColorSelected = textcolor
        return this
    }

    fun setDayOfMonthTextColorNormal(textcolor: Int): JCalendarView{
        dayOfMonthTextColorNormal = textcolor
        return this
    }

    fun setBackgroundResSelected(resBackground: Drawable): JCalendarView{
        backgroundResSelected = resBackground
        return this
    }
    fun setBackgroundResNormal(resBackground: Drawable): JCalendarView{
        backgroundResNormal = resBackground
        return this
    }
    fun setNameOfMonthTextColor(textColor: Int): JCalendarView{
        nameOfMonthTextColor = textColor
        return this
    }

    fun setJalaliListener(jalaliListener: JJalaliListener): JCalendarView{
        this.jalaliListener = jalaliListener
        return this
    }

    fun setGregorianListener(gregorianListener: JGregorianListener): JCalendarView{
        this.gregorianListener = gregorianListener
        return this
    }

    fun init(){

        inflate(context, R.layout.view_jcalendar, this)
        val daysOfMonth = findViewById<JCalendarRecycler>(R.id.recycler_day_of_month)
        val nameOfMonth =  findViewById<TextView>(R.id.textView_name_of_month)
        if(backgroundResNormal != null && backgroundResSelected != null)
        {
            daysOfMonth.init(context
                , nameOfWeekTextColorSelected
                , dayOfMonthTextColorSelected
                , backgroundResSelected!!
                , nameOfWeekTextColorNormal
                , dayOfMonthTextColorNormal
                , backgroundResNormal!!
            ){model ->

                nameOfMonth.text = model.monthName

                val gregorian = model.intoGregorian()
                val jalali = model.intoJalali()

                jalaliListener?.let {
                    it.onJalali(jalali)
                }

                gregorianListener?.let {
                    it.onGregorian(gregorian)
                }

            }
        }
        nameOfMonth.setTextColor(ContextCompat.getColor(context, nameOfMonthTextColor))
    }

}