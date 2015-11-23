package com.boomtown.ckesho.playground.Models;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by ckesho on 11/19/2015.
 */
public class Message {

    //constructor
    public Message(){
        GregorianCalendar calendar= new GregorianCalendar();
        date=calendar.getTime();
        timestamp= DateFormat.getTimeInstance().format(date);//Ex: 12:30:48 PM
    }

    public String firstName="First Name";
    public String lastName="Last Name";
    public String timestamp="11:02 AM";
    public String identification="404-873-1555";
    public String message="All my life I thought air was free until I bought a bag of chips";
    public String action="CALL BACK";
    public int viewitemtype=6;
    public Date date;


}
