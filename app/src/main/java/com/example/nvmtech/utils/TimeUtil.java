package com.example.nvmtech.utils;

import android.text.TextUtils;

import com.example.nvmtech.constants.TimeConstant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {
    public static String parsePubDateToTimeStamp(String pubDate) {
        if (TextUtils.isEmpty(pubDate)){
            return "";
        }

        try {
            final Date datePub = new SimpleDateFormat(TimeConstant.PATTERN_PUB_DATE, Locale.ENGLISH).parse(pubDate);
            return new SimpleDateFormat(TimeConstant.FORMAT_TIME_DD_MM_YYYY).format(datePub);
        }
        catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
