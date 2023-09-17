package com.assignment.project.hotelreservation.services;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
        Add Date Service
        ****************************************************************
        Add no of days to some given date to find - date after some days
 */
public class AddDateService {
    public static Date addDate(Date date, int noOfDays){
        String dateFrom = String.valueOf(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(sdf.parse(dateFrom));
        }catch(ParseException e){
            e.printStackTrace();
        }

        cal.add(Calendar.DAY_OF_MONTH, (noOfDays-1));

        String calculatedDate = sdf.format(cal.getTime());

        Date dateAfter=Date.valueOf(calculatedDate);

        return dateAfter;
    }
}
