package com.javadsh98.jcalendar

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class JModelTest {

    //nextday()
    @Test
    fun persian_date_test(){

        val jModel = JModel(2020, 3, 19)//  1398/12/29
        assertEquals(jModel.listOfMonth[11], jModel.monthName)
        assertEquals(29, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)

    }

    @Test
    fun jmodel_next_day_test1(){
        val jModel = JModel(2019, 10, 30)//  1398/8/8
        jModel.nextDay()//  1398/8/9
        jModel.nextDay()//  1398/8/10
        assertEquals(jModel.listOfMonth[7], jModel.monthName)
        assertEquals(10, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_next_day_esfand_to_farvardin_test(){
        val jModel = JModel(2020, 3, 19)//  1398/12/29
        jModel.nextDay()//  1399/1/1
        assertEquals(jModel.listOfMonth[0], jModel.monthName)
        assertEquals(1, jModel.dayOfMonth)
        assertEquals(1399, jModel.year)
    }

    @Test
    fun jmodel_esfand_to_farvardin_leap_year_test(){
        val jModel = JModel(2017, 3, 20)//  1395/12/30
        assertEquals(jModel.listOfMonth[11], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1395, jModel.year)
    }

    @Test
    fun jmodel_next_day_esfand_to_farvardin_leap_year_test(){
        val jModel = JModel(2017, 3, 20)//  1395/12/30
        jModel.nextDay()
        assertEquals(jModel.listOfMonth[0], jModel.monthName)
        assertEquals(1, jModel.dayOfMonth)
        assertEquals(1396, jModel.year)
    }

    @Test
    fun jmodel_nextday_farvardin_to_ordibehesht(){
        val jModel = JModel(2019, 4, 20)//  1398/1/31
        assertEquals(jModel.listOfMonth[0], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)

        jModel.nextDay()//  1398/2/1
        assertEquals(jModel.listOfMonth[1], jModel.monthName)
        assertEquals(1, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }
    @Test
    fun jmodel_nextday_ordibehesht_to_khordad(){
        val jModel = JModel(2019, 5, 21)//  1398/2/31
        assertEquals(jModel.listOfMonth[1], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)

        jModel.nextDay()//  1398/3/1
        assertEquals(jModel.listOfMonth[2], jModel.monthName)
        assertEquals(1, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_nextday_khordad_to_tir(){
        val jModel = JModel(2019, 6, 21)//  1398/3/31
        assertEquals(jModel.listOfMonth[2], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)

        jModel.nextDay()//  1398/4/1
        assertEquals(jModel.listOfMonth[3], jModel.monthName)
        assertEquals(1, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_nextday_tir_to_mordad(){
        val jModel = JModel(2019, 7, 22)//  1398/4/31
        assertEquals(jModel.listOfMonth[3], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)

        jModel.nextDay()//  1398/5/1
        assertEquals(jModel.listOfMonth[4], jModel.monthName)
        assertEquals(1, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_nextday_mordad_to_shahrivar(){
        val jModel = JModel(2019, 8, 22)//  1398/5/31
        assertEquals(jModel.listOfMonth[4], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)

        jModel.nextDay()//  1398/6/1
        assertEquals(jModel.listOfMonth[5], jModel.monthName)
        assertEquals(1, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_nextday_shahrivar_to_mehr(){
            val jModel = JModel(2019, 9, 22)//  1398/6/31
        assertEquals(jModel.listOfMonth[5], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)

        jModel.nextDay()//  1398/7/1
        assertEquals(jModel.listOfMonth[6], jModel.monthName)
        assertEquals(1, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_nextday_mehr_to_aban(){
        val jModel = JModel(2019, 10, 22)//  1398/7/30
        assertEquals(jModel.listOfMonth[6], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)

        jModel.nextDay()//  1398/8/1
        assertEquals(jModel.listOfMonth[7], jModel.monthName)
        assertEquals(1, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_nextday_aban_to_azar(){
        val jModel = JModel(2019, 11, 21)//  1398/8/30
        assertEquals(jModel.listOfMonth[7], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)

        jModel.nextDay()//  1398/9/1
        assertEquals(jModel.listOfMonth[8], jModel.monthName)
        assertEquals(1, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_nextday_azar_to_dey(){
        val jModel = JModel(2019, 12, 21)//  1398/9/30
        assertEquals(jModel.listOfMonth[8], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)

        jModel.nextDay()//  1398/10/1
        assertEquals(jModel.listOfMonth[9], jModel.monthName)
        assertEquals(1, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_nextday_dey_to_bahman(){
        val jModel = JModel(2020, 1, 20)//  1398/10/30
        assertEquals(jModel.listOfMonth[9], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)

        jModel.nextDay()//  1398/11/1
        assertEquals(jModel.listOfMonth[10], jModel.monthName)
        assertEquals(1, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_nextday_bahman_to_esfand(){
        val jModel = JModel(2020, 2, 19)//  1398/11/30
        assertEquals(jModel.listOfMonth[10], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)

        jModel.nextDay()//  1398/12/1
        assertEquals(jModel.listOfMonth[11], jModel.monthName)
        assertEquals(1, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    //previous day
    @Test
    fun jmodel_previouse_day_farvardin_to_esfand(){
        var jModel = JModel(2020, 3, 20)//1399/1/1
        jModel.previousDay()
        assertEquals(jModel.listOfMonth[11], jModel.monthName)
        assertEquals(29, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previouse_day_farvardin_to_esfand_leap_year(){
        var jModel = JModel(2017, 3, 21)//1396/1/1
        jModel.previousDay()//1395/12/30
        assertEquals(jModel.listOfMonth[11], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1395, jModel.year)
    }

    @Test
    fun jmodel_previouse_day_esfand_to_bahman(){
        var jModel = JModel(2020, 2, 20)//1398/12/1
        jModel.previousDay()//1398/11/30
        assertEquals(jModel.listOfMonth[10], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previouse_day_bahman_to_dey(){
        var jModel = JModel(2020, 1, 21)//1398/11/1
        jModel.previousDay()//1398/10/30
        assertEquals(jModel.listOfMonth[9], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previouse_day_dey_to_azar(){
        var jModel = JModel(2019, 12, 22)//1398/10/1
        jModel.previousDay()//1398/9/30
        assertEquals(jModel.listOfMonth[8], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previouse_day_azar_to_aban(){
        var jModel = JModel(2019, 11, 22)//1398/9/1
        jModel.previousDay()//1398/8/30
        assertEquals(jModel.listOfMonth[7], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previouse_day_aban_to_mehr(){
        var jModel = JModel(2019, 10, 23)//1398/8/1
        jModel.previousDay()//1398/7/30
        assertEquals(jModel.listOfMonth[6], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previouse_day_mehr_to_shahrivar(){
        var jModel = JModel(2019, 9, 23)//1398/7/1
        jModel.previousDay()//1398/6/31
        assertEquals(jModel.listOfMonth[5], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previouse_day_shahrivar_to_mordad(){
        var jModel = JModel(2019, 8, 23)//1398/6/1
        jModel.previousDay()//1398/5/31
        assertEquals(jModel.listOfMonth[4], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previouse_day_mordad_to_tir(){
        var jModel = JModel(2019, 7, 23)//1398/5/1
        jModel.previousDay()//1398/4/31
        assertEquals(jModel.listOfMonth[3], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previouse_day_tir_to_khordad(){
        var jModel = JModel(2019, 6, 22)//1398/4/1
        jModel.previousDay()//1398/3/31
        assertEquals(jModel.listOfMonth[2], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previouse_day_khordad_to_ordibehesht(){
        var jModel = JModel(2019, 5, 22)//1398/3/1
        jModel.previousDay()//1398/2/31
        assertEquals(jModel.listOfMonth[1], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previouse_day_ordibehesht_to_farvardin(){
        var jModel = JModel(2019, 4, 21)//1398/2/1
        jModel.previousDay()//1398/1/31
        assertEquals(jModel.listOfMonth[0], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    //next month
    @Test
    fun jmodel_next_month_farfardin_to_ordibehesht(){
        var jModel = JModel(2019, 4, 20)//1398/1/31
        jModel.nextMonth()//1398/2/31
        assertEquals(jModel.listOfMonth[1], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_next_month_farfardin_to_ordibehesht_2(){
        var jModel = JModel(2019, 4, 14)//1398/1/25
        jModel.nextMonth()//1398/2/25
        assertEquals(jModel.listOfMonth[1], jModel.monthName)
        assertEquals(25, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_next_month_ordibehesht_to_khordad(){
        var jModel = JModel(2019, 5, 21)//1398/2/31
        jModel.nextMonth()//1398/3/31
        assertEquals(jModel.listOfMonth[2], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_next_month_khordad_to_tir(){
        var jModel = JModel(2019, 6, 21)//1398/3/31
        jModel.nextMonth()//1398/4/31
        assertEquals(jModel.listOfMonth[3], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }
    @Test
    fun jmodel_next_month_tir_to_mordad(){
        var jModel = JModel(2019, 7, 22)//1398/4/31
        jModel.nextMonth()//1398/5/31
        assertEquals(jModel.listOfMonth[4], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }
    @Test
    fun jmodel_next_month_mordad_to_shahrivar(){
        var jModel = JModel(2019, 8, 22)//1398/5/31
        jModel.nextMonth()//1398/6/31
        assertEquals(jModel.listOfMonth[5], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_next_month_shahrivar_to_mehr(){
        var jModel = JModel(2019, 9, 22)//1398/6/31
        jModel.nextMonth()//1398/7/30
        assertEquals(jModel.listOfMonth[6], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_next_month_mehr_to_aban(){
        var jModel = JModel(2019, 10, 22)//1398/7/30
        jModel.nextMonth()//1398/8/30
        assertEquals(jModel.listOfMonth[7], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_next_month_aban_to_azar(){
        var jModel = JModel(2019, 11, 21)//1398/8/30
        jModel.nextMonth()//1398/9/30
        assertEquals(jModel.listOfMonth[8], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_next_month_azar_to_dey(){
        var jModel = JModel(2019, 12, 21)//1398/9/30
        jModel.nextMonth()//1398/10/30
        assertEquals(jModel.listOfMonth[9], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_next_month_dey_to_bahman(){
        var jModel = JModel(2020, 1, 20)//1398/10/30
        jModel.nextMonth()//1398/11/30
        assertEquals(jModel.listOfMonth[10], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }


    @Test
    fun jmodel_next_month_bahman_to_esfand(){
        var jModel = JModel(2020, 2, 19)//1398/11/30
        jModel.nextMonth()//1398/12/29
        assertEquals(jModel.listOfMonth[11], jModel.monthName)
        assertEquals(29, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }


    @Test
    fun jmodel_next_month_esfand_to_farvardin(){
        var jModel = JModel(2020, 3, 19)//1398/12/29
        jModel.nextMonth()//1399/1/29
        assertEquals(jModel.listOfMonth[0], jModel.monthName)
        assertEquals(29, jModel.dayOfMonth)
        assertEquals(1399, jModel.year)
    }

    @Test
    fun jmodel_next_month_esfand_to_farvardin_leap_year(){
        var jModel = JModel(2017, 3, 19)//1395/12/29
        jModel.nextMonth()//1396/1/29
        assertEquals(jModel.listOfMonth[0], jModel.monthName)
        assertEquals(29, jModel.dayOfMonth)
        assertEquals(1396, jModel.year)
    }

    @Test
    fun jmodel_next_month_esfand_to_farvardin_leap_year_2(){
        var jModel = JModel(2017, 3, 20)//1395/12/30
        jModel.nextMonth()//1396/1/30
        assertEquals(jModel.listOfMonth[0], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1396, jModel.year)
    }
    //previous month
    @Test
    fun jmodel_previous_month_esfand_to_bahman_leap_year(){
        var jModel = JModel(2017, 3, 20)//1395/12/30
        jModel.previousMonth()//1395/11/30
        assertEquals(jModel.listOfMonth[10], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1395, jModel.year)
    }

    @Test
    fun jmodel_previous_month_esfand_to_bahman(){
        var jModel = JModel(2020, 3, 19)//1398/12/29
        jModel.previousMonth()//1398/11/29
        assertEquals(jModel.listOfMonth[10], jModel.monthName)
        assertEquals(29, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previous_month_bahman_to_dey(){
        var jModel = JModel(2020, 2, 19)//1398/11/30
        jModel.previousMonth()//1398/10/30
        assertEquals(jModel.listOfMonth[9], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previous_month_dey_to_azar(){
        var jModel = JModel(2020, 1, 20)//1398/10/30
        jModel.previousMonth()//1398/9/30
        assertEquals(jModel.listOfMonth[8], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previous_month_azar_to_aban(){
        var jModel = JModel(2019, 12, 21)//1398/9/30
        jModel.previousMonth()//1398/8/30
        assertEquals(jModel.listOfMonth[7], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previous_month_aban_to_mehr(){
        var jModel = JModel(2019, 11, 21)//1398/8/30
        jModel.previousMonth()//1398/7/30
        assertEquals(jModel.listOfMonth[6], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previous_month_mehr_to_shahrivar(){
        var jModel = JModel(2019, 10, 22)//1398/7/30
        jModel.previousMonth()//1398/6/30
        assertEquals(jModel.listOfMonth[5], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previous_month_shahrivar_to_mordad(){
        var jModel = JModel(2019, 9, 22)//1398/6/31
        jModel.previousMonth()//1398/5/31
        assertEquals(jModel.listOfMonth[4], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previous_month_mordad_to_tir(){
        var jModel = JModel(2019, 8, 22)//1398/5/31
        jModel.previousMonth()//1398/4/31
        assertEquals(jModel.listOfMonth[3], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previous_month_tir_to_khordad(){
        var jModel = JModel(2019, 7, 22)//1398/4/31
        jModel.previousMonth()//1398/3/31
        assertEquals(jModel.listOfMonth[2], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previous_month_khordad_to_ordibehesht(){
        var jModel = JModel(2019, 6, 21)//1398/3/31
        jModel.previousMonth()//1398/2/31
        assertEquals(jModel.listOfMonth[1], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previous_month_ordibehesht_to_farvardin(){
        var jModel = JModel(2019, 5, 21)//1398/2/31
        jModel.previousMonth()//1398/1/31
        assertEquals(jModel.listOfMonth[0], jModel.monthName)
        assertEquals(31, jModel.dayOfMonth)
        assertEquals(1398, jModel.year)
    }

    @Test
    fun jmodel_previous_month_arvardin_to_esfand(){
        var jModel = JModel(2019, 4, 20)//1398/1/31
        jModel.previousMonth()//1397/11/29
        assertEquals(jModel.listOfMonth[11], jModel.monthName)
        assertEquals(29, jModel.dayOfMonth)
        assertEquals(1397, jModel.year)
    }

    @Test
    fun jmodel_previous_month_arvardin_to_esfand_leap_year(){
        var jModel = JModel(2017, 4, 20)//1396/1/31
        jModel.previousMonth()//1395/11/30
        assertEquals(jModel.listOfMonth[11], jModel.monthName)
        assertEquals(30, jModel.dayOfMonth)
        assertEquals(1395, jModel.year)
    }

    //equal
    @Test
    fun jmodel_equal_date(){
        val jModel1 = JModel(2017, 4, 20)
        val jModel2 = JModel(2017, 4, 20)
        assertEquals(true, jModel1.equal(jModel2))
    }

    @Test
    fun jmodel_not_equal_date(){
        val jModel1 = JModel(2017, 4, 20)
        jModel1.nextDay()
        val jModel2 = JModel(2017, 4, 20)
        assertEquals(false, jModel1.equal(jModel2))
    }

    @Test
    fun jmodel_next_day_of_week_equal_date(){
        val jModel1 = JModel(2017, 4, 28)
        jModel1.nextDayOfWeek()
        assertEquals(jModel1.listOfWeek[0], jModel1.dayOfWeek)
    }

    @Test
    fun jmodel_previous_day_of_week_equal_date(){
        val jModel1 = JModel(2020, 11, 21)
        jModel1.previousDayOfWeek()
        assertEquals(jModel1.listOfWeek[6], jModel1.dayOfWeek)
    }

    @Test
    fun jmodel_into_Gregorian_test(){

        var jModel = JModel(2017, 4, 20)//1396/1/31
        jModel.nextDay()
        jModel.nextDay()
        jModel.nextDay()
        jModel.nextDay()//1396/2/4
        assertEquals("2017-04-24", jModel.intoGregorian())

    }

    @Test
    fun jmodel_into_Jalali_test(){

        var jModel = JModel(2017, 4, 20)//1396/1/31
        jModel.nextDay()
        jModel.nextDay()
        jModel.nextDay()
        jModel.nextDay()//1396/2/4
        assertEquals("1396-2-4", jModel.intoJalali())

    }
}