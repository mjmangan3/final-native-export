package com.vereview.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mjmangan on 8/19/17.
 */
public class DateUtils {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm a");

    public static String getDateString(Date date){
        if(date == null){
            return "";
        }
        String strDate = DATE_FORMAT.format(date);
        return strDate;
    }

    public static String getTimeString(Date date){
        if(date == null){
            return "";
        }
        String strDate = TIME_FORMAT.format(date);
        return strDate;
    }


}
