package com.javadsh98.jcalendar

import com.github.eloyzone.jalalicalendar.DateConverter
import com.github.eloyzone.jalalicalendar.JalaliDate

const val TAG = "JModel"

data class JModel(var yearGregorian: Int, var monthGregorian: Int, var dayGregorian: Int) {

    var dayOfMonth: Int
    var dayOfWeek: String
    var monthName: String
    var year: Int
    var selected: Boolean = false


    var listOfMonth = listOf(
        "فروردین",
        "اردیبهشت",
        "خرداد",
        "تیر",
        "مرداد",
        "شهریور",
        "مهر",
        "آبان",
        "آذر",
        "دی",
        "بهمن",
        "اسفند"
    )

    var listOfWeek = listOf(
        "شنبه", "یکشنبه", "دوشنبه", "سه شنبه", "چهارشنبه", "پنج شنبه", "جمعه"
    )

    init {

        val converter = DateConverter()
        val jalali = converter.gregorianToJalali(yearGregorian, monthGregorian, dayGregorian)
        dayOfMonth = jalali.day
        dayOfWeek = jalali.dayOfWeek.stringInPersian
        monthName = jalali.monthPersian.stringInPersian
        year = jalali.year

    }

    fun getMonthNumber(): Int{
        return when(monthName){
            listOfMonth[0] -> 1
            listOfMonth[1] -> 2
            listOfMonth[2] -> 3
            listOfMonth[3] -> 4
            listOfMonth[4] -> 5
            listOfMonth[5] -> 6
            listOfMonth[6] -> 7
            listOfMonth[7] -> 8
            listOfMonth[8] -> 9
            listOfMonth[9] -> 10
            listOfMonth[10] -> 11
            listOfMonth[11] -> 12
            else -> -1
        }
    }

    fun setNextWeekIndex() {
        dayOfWeek = when (dayOfWeek) {
            listOfWeek[0] -> listOfWeek[1]
            listOfWeek[1] -> listOfWeek[2]
            listOfWeek[2] -> listOfWeek[3]
            listOfWeek[3] -> listOfWeek[4]
            listOfWeek[4] -> listOfWeek[5]
            listOfWeek[5] -> listOfWeek[6]
            listOfWeek[6] -> listOfWeek[0]
            else -> ""
        }
    }

    fun setPreviousWeekIndex() {
        dayOfWeek = when (dayOfWeek) {
            listOfWeek[0] -> listOfWeek[6]
            listOfWeek[1] -> listOfWeek[0]
            listOfWeek[2] -> listOfWeek[1]
            listOfWeek[3] -> listOfWeek[2]
            listOfWeek[4] -> listOfWeek[3]
            listOfWeek[5] -> listOfWeek[4]
            listOfWeek[6] -> listOfWeek[5]
            else -> ""
        }
    }

    fun nextDayOfWeek() {
        setNextWeekIndex()
    }


    fun previousDayOfWeek() {

        setPreviousWeekIndex()
    }

    fun nextDay() {
        when (monthName) {
            listOfMonth[11] -> {
                //کبیسه
                if (JalaliDate(year, 1, dayOfMonth).isLeapYear) {
                    if (dayOfMonth == 30) {
                        monthName = listOfMonth[0]
                        dayOfMonth = 1
                        year++
                    } else {
                        dayOfMonth++
                    }
                    nextDayOfWeek()
                    //کبیسه نیست
                } else if (!JalaliDate(year, 1, dayOfMonth).isLeapYear) {
                    if (dayOfMonth == 29) {
                        monthName = listOfMonth[0]
                        dayOfMonth = 1
                        year++
                    } else {
                        dayOfMonth++
                    }
                    nextDayOfWeek()
                }
            }
            listOfMonth[10] -> {
                if (dayOfMonth == 30) {
                    dayOfMonth = 1
                    monthName = listOfMonth[11]
                } else {
                    dayOfMonth++
                }
                nextDayOfWeek()
            }
            listOfMonth[9] -> {
                if (dayOfMonth == 30) {
                    dayOfMonth = 1
                    monthName = listOfMonth[10]
                } else {
                    dayOfMonth++

                }
                nextDayOfWeek()
            }
            listOfMonth[8] -> {
                if (dayOfMonth == 30) {
                    dayOfMonth = 1
                    monthName = listOfMonth[9]
                } else {
                    dayOfMonth++

                }
                nextDayOfWeek()
            }
            listOfMonth[7] -> {
                if (dayOfMonth == 30) {
                    dayOfMonth = 1
                    monthName = listOfMonth[8]
                } else {
                    dayOfMonth++

                }
                nextDayOfWeek()
            }
            listOfMonth[6] -> {
                if (dayOfMonth == 30) {
                    dayOfMonth = 1
                    monthName = listOfMonth[7]
                } else {
                    dayOfMonth++

                }
                nextDayOfWeek()
            }
            listOfMonth[5] -> {
                if (dayOfMonth == 31) {
                    dayOfMonth = 1
                    monthName = listOfMonth[6]
                } else {
                    dayOfMonth++

                }
                nextDayOfWeek()
            }
            listOfMonth[4] -> {
                if (dayOfMonth == 31) {
                    dayOfMonth = 1
                    monthName = listOfMonth[5]
                } else {
                    dayOfMonth++

                }
                nextDayOfWeek()
            }
            listOfMonth[3] -> {
                if (dayOfMonth == 31) {
                    dayOfMonth = 1
                    monthName = listOfMonth[4]
                } else {
                    dayOfMonth++

                }
                nextDayOfWeek()
            }
            listOfMonth[2] -> {
                if (dayOfMonth == 31) {
                    dayOfMonth = 1
                    monthName = listOfMonth[3]
                } else {
                    dayOfMonth++

                }
                nextDayOfWeek()
            }
            listOfMonth[1] -> {
                if (dayOfMonth == 31) {
                    dayOfMonth = 1
                    monthName = listOfMonth[2]
                } else {
                    dayOfMonth++

                }
                nextDayOfWeek()
            }
            listOfMonth[0] -> {
                if (dayOfMonth == 31) {
                    dayOfMonth = 1
                    monthName = listOfMonth[1]
                } else {
                    dayOfMonth++

                }
                nextDayOfWeek()
            }
        }


    }

    fun previousDay() {
        when (monthName) {
            listOfMonth[11] -> {
                if (dayOfMonth == 1) {
                    dayOfMonth = 30
                    monthName = listOfMonth[10]
                } else {
                    dayOfMonth--
                }
                previousDayOfWeek()
            }
            listOfMonth[10] -> {
                if (dayOfMonth == 1) {
                    dayOfMonth = 30
                    monthName = listOfMonth[9]
                } else {
                    dayOfMonth--
                }
                previousDayOfWeek()
            }
            listOfMonth[9] -> {
                if (dayOfMonth == 1) {
                    dayOfMonth = 30
                    monthName = listOfMonth[8]
                } else {
                    dayOfMonth--
                }
                previousDayOfWeek()
            }
            listOfMonth[8] -> {
                if (dayOfMonth == 1) {
                    dayOfMonth = 30
                    monthName = listOfMonth[7]
                } else {
                    dayOfMonth--
                }
                previousDayOfWeek()
            }
            listOfMonth[7] -> {
                if (dayOfMonth == 1) {
                    dayOfMonth = 30
                    monthName = listOfMonth[6]
                } else {
                    dayOfMonth--
                }
                previousDayOfWeek()
            }
            listOfMonth[6] -> {
                if (dayOfMonth == 1) {
                    dayOfMonth = 31
                    monthName = listOfMonth[5]
                } else {
                    dayOfMonth--
                }
                previousDayOfWeek()
            }
            listOfMonth[5] -> {
                if (dayOfMonth == 1) {
                    dayOfMonth = 31
                    monthName = listOfMonth[4]
                } else {
                    dayOfMonth--
                }
                previousDayOfWeek()
            }
            listOfMonth[4] -> {
                if (dayOfMonth == 1) {
                    dayOfMonth = 31
                    monthName = listOfMonth[3]
                } else {
                    dayOfMonth--
                }
                previousDayOfWeek()
            }
            listOfMonth[3] -> {
                if (dayOfMonth == 1) {
                    dayOfMonth = 31
                    monthName = listOfMonth[2]
                } else {
                    dayOfMonth--
                }
                previousDayOfWeek()
            }
            listOfMonth[2] -> {
                if (dayOfMonth == 1) {
                    dayOfMonth = 31
                    monthName = listOfMonth[1]
                } else {
                    dayOfMonth--
                }
                previousDayOfWeek()
            }
            listOfMonth[1] -> {
                if (dayOfMonth == 1) {
                    dayOfMonth = 31
                    monthName = listOfMonth[0]
                } else {
                    dayOfMonth--
                }
                previousDayOfWeek()
            }
            listOfMonth[0] -> {
                if (JalaliDate(year, 1, dayOfMonth).isLeapYear) {
                    if (dayOfMonth == 1) {
                        dayOfMonth = 29
                        monthName = listOfMonth[11]
                        year--
                    } else {
                        dayOfMonth--
                    }
                    previousDayOfWeek()
                } else if (!JalaliDate(year, 1, dayOfMonth).isLeapYear) {
                    if (dayOfMonth == 1) {
                        year--
                        monthName = listOfMonth[11]
                        if (JalaliDate(year, 1, dayOfMonth).isLeapYear) {
                            dayOfMonth = 30
                        } else if (!JalaliDate(year, 1, dayOfMonth).isLeapYear) {
                            dayOfMonth = 29
                        }
                    } else {
                        dayOfMonth--
                    }
                    previousDayOfWeek()
                }
            }
        }


    }

    fun nextMonth() {
        when (monthName) {
            listOfMonth[11] -> {//اسفند
                ++year
                monthName = listOfMonth[0]
            }
            listOfMonth[10] -> {//بهمن
                monthName = listOfMonth[11]

                if (!JalaliDate(year, 1, dayOfMonth).isLeapYear && dayOfMonth > 29)
                    dayOfMonth = 29
            }
            listOfMonth[9] -> {//دی
                monthName = listOfMonth[10]
            }
            listOfMonth[8] -> {//آذر
                monthName = listOfMonth[9]
            }
            listOfMonth[7] -> {//آبان
                monthName = listOfMonth[8]
            }
            listOfMonth[6] -> {//مهر
                monthName = listOfMonth[7]
            }
            listOfMonth[5] -> {//شهریور
                monthName = listOfMonth[6]
                if (dayOfMonth > 30)
                    dayOfMonth = 30
            }
            listOfMonth[4] -> {//مرداد
                monthName = listOfMonth[5]
            }
            listOfMonth[3] -> {//تیر
                monthName = listOfMonth[4]
            }
            listOfMonth[2] -> {//خرداد
                monthName = listOfMonth[3]
            }
            listOfMonth[1] -> {//اردیبهشت
                monthName = listOfMonth[2]
            }
            listOfMonth[0] -> {//فروردین
                monthName = listOfMonth[1]
            }
        }

    }

    fun previousMonth() {

        when (monthName) {
            listOfMonth[11] -> {
                monthName = listOfMonth[10]
            }
            listOfMonth[10] -> {
                monthName = listOfMonth[9]
            }
            listOfMonth[9] -> {
                monthName = listOfMonth[8]
            }
            listOfMonth[8] -> {
                monthName = listOfMonth[7]
            }
            listOfMonth[7] -> {
                monthName = listOfMonth[6]
            }
            listOfMonth[6] -> {
                monthName = listOfMonth[5]
            }
            listOfMonth[5] -> {
                monthName = listOfMonth[4]
            }
            listOfMonth[4] -> {
                monthName = listOfMonth[3]
            }
            listOfMonth[3] -> {
                monthName = listOfMonth[2]
            }
            listOfMonth[2] -> {
                monthName = listOfMonth[1]
            }
            listOfMonth[1] -> {
                monthName = listOfMonth[0]
            }
            listOfMonth[0] -> {
                year--
                monthName = listOfMonth[11]
                if (!JalaliDate(year, 1, dayOfMonth).isLeapYear && dayOfMonth > 29) {
                    dayOfMonth = 29
                } else if (JalaliDate(year, 1, dayOfMonth).isLeapYear && dayOfMonth > 30) {
                    dayOfMonth = 30
                }
            }
        }

    }

    fun equal(jModel: JModel): Boolean {
        return jModel.dayOfMonth == this.dayOfMonth
                && jModel.monthName.equals(this.monthName, false)
                && jModel.year == this.year
    }

    fun getTwoMonth(): MutableList<JModel> {

        val list = mutableListOf<JModel>()
        list.add(this)

        val nextMonth = this.copy()
        nextMonth.nextMonth()

        val previousMonth = this.copy()
        previousMonth.previousMonth()

        //add next month
        do {
            val nextDay = list[0].myCopy(JModel(yearGregorian, monthGregorian, dayOfMonth))
            nextDay.nextDay()
            nextDay.selected = false
            list.add(0, nextDay)
        } while (!nextDay.equal(nextMonth))

        //add previous month
        do {
            val previousDay =
                list[list.size - 1].myCopy(JModel(yearGregorian, monthGregorian, dayOfMonth))
            previousDay.previousDay()
            previousDay.selected = false
            list.add(list.size, previousDay)
        } while (!previousDay.equal(previousMonth))


        return list
    }

    fun myCopy(jModel: JModel): JModel {
        jModel.dayOfMonth = this.dayOfMonth
        jModel.monthName = this.monthName
        jModel.year = this.year
        jModel.dayOfWeek = this.dayOfWeek
        return jModel
    }

    fun intoGregorian(): String{
        var dateConverter = DateConverter()
        val gregorian = dateConverter.jalaliToGregorian(year, getMonthNumber(), dayOfMonth)

        //set gregorian year, month, day
        //you can update these in the next/previous day function
        //to delete these lines of code
        yearGregorian = gregorian.year
        monthGregorian = gregorian.monthValue
        dayGregorian = gregorian.dayOfMonth

        return gregorian.toString()
    }


    fun intoJalali(): String{
        var dateConverter = DateConverter()
        val jalali = dateConverter.gregorianToJalali(yearGregorian, monthGregorian, dayGregorian)

        //we dont want to update jalali year, month, day
        //becase we update it in the next/previous day

        return jalali.toString()
    }

    override fun toString(): String {
        return "JModel(dayOfMonth=$dayOfMonth, dayOfWeek='$dayOfWeek')"
    }


}