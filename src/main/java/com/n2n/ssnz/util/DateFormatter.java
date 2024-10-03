package com.n2n.ssnz.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class DateFormatter {

    private static final Logger LOG = Logger.getLogger(DateFormatter.class.getName());

    public static Date getDateFromStr(String source) {
        Date date = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            date = dateFormat.parse(source);
        } catch (Exception e) {
            LOG.info("Exception inside DateFormatter.getDateFromStr()");
            e.printStackTrace();;
        }
        return date;
    }

    public static Date getSqlDateFromStr(String source) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            java.util.Date parsedUtilDate = dateFormat.parse(source);
            return new java.sql.Date(parsedUtilDate.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
