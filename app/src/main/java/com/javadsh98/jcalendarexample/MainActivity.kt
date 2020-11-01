package com.javadsh98.jcalendarexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.javadsh98.jcalendar.JGregorianListener
import com.javadsh98.jcalendar.JJalaliListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jcalendar
            .setBackgroundResNormal(ResourcesCompat.getDrawable(resources, R.drawable.frm_item_normal, null)!!)
            .setBackgroundResSelected(ResourcesCompat.getDrawable(resources, R.drawable.frm_item_selected, null)!!)
            .setNameOfMonthTextColor(R.color.black_all)
            .setNameOfWeekTextColorNormal(R.color.black_all)
            .setDayOfMonthTextColorNormal(R.color.black_all)
            .setNameOfWeekTextColorSelected(R.color.white_all)
            .setDayOfMonthTextColorSelected(R.color.white_all)
            .setJalaliListener(object : JJalaliListener {
                override fun onJalali(date: String) {
                    textView_jalali.text = date
                }
            })
            .setGregorianListener(object : JGregorianListener {
                override fun onGregorian(date: String) {
                    textView_gregorian.text = date
                }
            })
            .init()

    }
}