package com.javadsh98.jcalendar

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class JCalendarRecycler : RecyclerView {

    lateinit var adapter: JCalendarAdapter
    lateinit var layoutManager: LinearLayoutManager

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun init(
        context: Context,
        nameOfWeekTextColorSelected: Int,
        dayOfMonthTextColorSelected: Int,
        backgroundResSelected: Drawable,
        nameOfWeekTextColorNormal: Int,
        dayOfMonthTextColorNormal: Int,
        backgroundResNormal: Drawable,
        onJItemClickListener: onJItemClickListener
    ) {

        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        setLayoutManager(layoutManager)
        post{
            adapter = JCalendarAdapter(nameOfWeekTextColorSelected
                , dayOfMonthTextColorSelected
                , backgroundResSelected
                , nameOfWeekTextColorNormal
                , dayOfMonthTextColorNormal
                , backgroundResNormal
                , onJItemClickListener)
            setAdapter(adapter)

            getLayoutManager()?.scrollToPosition(adapter.selectedIndex)

        }

    }


}