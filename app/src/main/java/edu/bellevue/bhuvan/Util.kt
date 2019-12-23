package edu.bellevue.bhuvan

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import edu.bellevue.bhuvan.database.Weight
import java.text.SimpleDateFormat


    /**
     * Take the Long milliseconds returned by the system and stored in Room,
     * and convert it to a nicely formatted string for display.
     *
     * EEEE - Display the long letter version of the weekday
     * MMM - Display the letter abbreviation of the nmotny
     * dd-yyyy - day in month and full year numerically
     * HH:mm - Hours and minutes in 24hr format
     */
    @SuppressLint("SimpleDateFormat")
    fun convertLongToDateString(systemTime: Long): String {
        return SimpleDateFormat("EEEE MMM-dd-yyyy' Time: 'HH:mm")
            .format(systemTime).toString()
    }

     fun convertDateStringToLong(date: String): Long {
         if(date=="")
             return 0
        return SimpleDateFormat("EEEE MMM-dd-yyyy' Time: 'HH:mm").parse(date).time
    }


fun formatWeight(weights: List<Weight>): Spanned {
    val sb = StringBuilder()
    sb.apply {
        append("Histroy")
        weights.forEach {
            append("<br>")
            append("Date")
            append("\t${convertLongToDateString(it.date)}<br>")
            append("Weight")
            append("\t${it.weight}<br>")
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}