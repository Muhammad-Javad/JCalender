package com.javadsh98.jcalendar

import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_jcalendar_normal.view.*
import kotlinx.android.synthetic.main.item_jcalendar_selcted.view.*
import java.time.LocalDateTime

typealias onJItemClickListener = (JModel) -> Unit

class JCalendarAdapter(
    val nameOfWeekTextColorSelected: Int,
    val dayOfMonthTextColorSelected: Int,
    val backgroundResSelected: Drawable,
    val nameOfWeekTextColorNormal: Int,
    val dayOfMonthTextColorNormal: Int,
    val backgroundResNormal: Drawable,
    val onJItemClickListener: onJItemClickListener
) : ListAdapter<JModel, RecyclerView.ViewHolder>(diff) {

    var selected: JModel
    lateinit var selectedViewHolder: RecyclerView.ViewHolder
    var selectedIndex = 0

    init {

        var localDateTime = LocalDateTime.now()
        val today = JModel(localDateTime.year, localDateTime.monthValue, localDateTime.dayOfMonth)
        today.selected = true

        selected = today
        val data = today.getTwoMonth()
        submitList(data)

        val item = data.filter { it.selected }[0]
        selectedIndex = data.indexOf(item)

        //send selected item's model into callback
        onJItemClickListener.invoke(today)
    }

    companion object {
        val diff = object : DiffUtil.ItemCallback<JModel>() {
            override fun areItemsTheSame(oldItem: JModel, newItem: JModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: JModel, newItem: JModel): Boolean {
                return oldItem.year == newItem.year
                        && TextUtils.equals(oldItem.monthName, newItem.monthName)
                        && TextUtils.equals(oldItem.dayOfWeek, newItem.dayOfWeek)
                        && oldItem.dayOfMonth == newItem.dayOfMonth
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            SELECTED -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_jcalendar_selcted, parent, false)
                selectedViewHolder = SelectedViewHolder(view)
                selectedViewHolder
            }
            NORMAL -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_jcalendar_normal, parent, false)
                NormalViewHolder(view)
            }
            else -> {
                throw IllegalStateException("exception occurred in onCreateViewHolder method ")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (holder is SelectedViewHolder) {
            holder.onBind(
                currentItem,
                nameOfWeekTextColorSelected,
                dayOfMonthTextColorSelected,
                backgroundResSelected,
            )

        } else if (holder is NormalViewHolder) {
            holder.onBind(
                currentItem,
                nameOfWeekTextColorNormal,
                dayOfMonthTextColorNormal,
                backgroundResNormal,
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.selected) {
            selected = item
            SELECTED
        } else {
            NORMAL
        }

    }


    inner class SelectedViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        lateinit var daysOfMonth: TextView
        lateinit var daysOfWeek: TextView
        lateinit var model: JModel

        fun onBind(
            jModel: JModel,
            nameOfWeekTextColor: Int,
            dayOfMonthTextColor: Int,
            backgroundRes: Drawable
        ) = with(itemView) {


            daysOfMonth = textView_days_of_month_selected
            daysOfWeek = textView_day_of_week_selected
            model = jModel

            //first ui of selected item//pink
            textView_days_of_month_selected.text = jModel.dayOfMonth.toString()
            textView_day_of_week_selected.text = jModel.dayOfWeek

            textView_days_of_month_selected.setTextColor(
                ContextCompat.getColor(
                    context,
                    dayOfMonthTextColor
                )
            )
            textView_day_of_week_selected.setTextColor(
                ContextCompat.getColor(
                    context,
                    nameOfWeekTextColor
                )
            )
            background = backgroundRes

            //logic of selection
            var holder = this@SelectedViewHolder
            setOnClickListener {
                //if selected item is not previous item
                if (selectedViewHolder !== holder) {

                    //send model into callback
                    onJItemClickListener.invoke(jModel)

                    //set ui of selecting item

                    with(holder.itemView) {
                        textView_days_of_month_selected.setTextColor(
                            ContextCompat.getColor(
                                context,
                                dayOfMonthTextColorSelected
                            )
                        )
                        textView_day_of_week_selected.setTextColor(
                            ContextCompat.getColor(
                                context,
                                nameOfWeekTextColorSelected
                            )
                        )
                        background = backgroundResSelected
                    }
                    //set ui of previous selected item
                    if (selectedViewHolder is SelectedViewHolder) {
                        with(selectedViewHolder.itemView) {
                            textView_days_of_month_selected.setTextColor(
                                androidx.core.content.ContextCompat.getColor(
                                    context,
                                    dayOfMonthTextColorNormal
                                )
                            )
                            textView_day_of_week_selected.setTextColor(
                                androidx.core.content.ContextCompat.getColor(
                                    context,
                                    nameOfWeekTextColorNormal
                                )
                            )
                            background = backgroundResNormal
                        }
                    } else if (selectedViewHolder is NormalViewHolder) {
                        with(selectedViewHolder.itemView) {
                            textView_days_of_month_normal.setTextColor(
                                androidx.core.content.ContextCompat.getColor(
                                    context,
                                    dayOfMonthTextColorNormal
                                )
                            )
                            textView_day_of_week_normal.setTextColor(
                                androidx.core.content.ContextCompat.getColor(
                                    context,
                                    nameOfWeekTextColorNormal
                                )
                            )
                            background = backgroundResNormal
                        }
                    }

                    selectedViewHolder = holder
                    notifyDataSetChanged()
                }

            }

        }

    }


    inner class NormalViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        lateinit var daysOfMonth: TextView
        lateinit var daysOfWeek: TextView
        lateinit var model: JModel

        fun onBind(
            jModel: JModel,
            nameOfWeekTextColor: Int,
            dayOfMonthTextColor: Int,
            backgroundRes: Drawable
        ) = with(itemView) {

            textView_day_of_week_normal.text = jModel.dayOfWeek
            textView_days_of_month_normal.text = jModel.dayOfMonth.toString()

            textView_day_of_week_normal.setTextColor(ContextCompat.getColor(context, nameOfWeekTextColor))
            textView_days_of_month_normal.setTextColor(ContextCompat.getColor(context, dayOfMonthTextColor))
            background = backgroundRes

            setOnClickListener {

                jModel.selected = true
                selected.selected = false
                selected = jModel

                onJItemClickListener.invoke(selected)
                notifyDataSetChanged()

            }


        }

    }

}