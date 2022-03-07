/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryan.cashflow_forecast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ryanf
 */
public class Month {
    
    public void Month(){
    }
    
    public static ArrayList<String> getMonths(){
        ArrayList<String> months = new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");
        return months;
    }
    
    public static ArrayList<String> monthSorter(){
        
        Date now = Calendar.getInstance().getTime();
        Calendar calNow = Calendar.getInstance();
        calNow.setTime(now);
        int thisMonth = calNow.get(Calendar.MONTH);
        
        //creates a list of months in order starting from january
        ArrayList<String> months = new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");
        
        int startMthIdx = thisMonth;
        

        
        // creat a new list with months re-ordered with supplied month 1st
        ArrayList<String> reOrderedMonths = new ArrayList<>();
        
        for (int i = 0; i < months.size(); i++){
            if (startMthIdx < 12){
                reOrderedMonths.add(months.get(startMthIdx));
                startMthIdx ++;
            }
            
            else{
                startMthIdx = startMthIdx - 12;
                reOrderedMonths.add(months.get(startMthIdx));
                startMthIdx ++;
            }
        
        }
        
        reOrderedMonths.add(0, " ");
        return reOrderedMonths;
}
        public static ArrayList<Integer> monthIntSorter(){
        
        Date now = Calendar.getInstance().getTime();
        Calendar calNow = Calendar.getInstance();
        calNow.setTime(now);
        int thisMonth = calNow.get(Calendar.MONTH);
        
        //creates a list of months in order starting from january
        ArrayList<Integer> months = new ArrayList<>();
        months.add(1);
        months.add(2);
        months.add(3);
        months.add(4);
        months.add(5);
        months.add(6);
        months.add(7);
        months.add(8);
        months.add(9);
        months.add(10);
        months.add(11);
        months.add(12);
        
        int startMthIdx = thisMonth;
        

        
        // creat a new list with months re-ordered with supplied month 1st
        ArrayList<Integer> reOrderedMonths = new ArrayList<>();
        
        for (int i = 0; i < months.size(); i++){
            if (startMthIdx < 12){
                reOrderedMonths.add(months.get(startMthIdx));
                startMthIdx ++;
            }
            
            else{
                startMthIdx = startMthIdx - 12;
                reOrderedMonths.add(months.get(startMthIdx));
                startMthIdx ++;
            }
        
        }
        
        return reOrderedMonths;
}
}
