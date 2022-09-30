package com.example.goldenmovieticketnew.payload;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDateFormatedSingleton {
    private static GetDateFormatedSingleton instance;
    private GetDateFormatedSingleton(){
    }

    public static GetDateFormatedSingleton getInstance(){
        if(instance == null){
            synchronized (GetDateFormatedSingleton.class){
                if(instance == null){
                    instance = new GetDateFormatedSingleton();
                }
            }
        }
        return instance;
    }

    public String getDate(String formatString){
        Format dateFormat = new SimpleDateFormat(formatString);
        return dateFormat.format(new Date());
    }
}