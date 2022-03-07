/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryan.cashflow_forecast;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author ryanf
 */
public class Transaction implements Serializable {
    
    int index;
    int next;  // of 1st payment
    Date end; // final payment date.
    //boolean ongoing;
    String freq; // monthly / weekly / quarterly / yearly
    float amount; // £££££
    String name;  //rent, gas etc...
    String type;  //income or expenditure
    ArrayList<Integer> schedule;
    

    
    public Transaction(int i, int date, String frequency, float amount, String name, String type){
        
        this.index = i;
        this.next = date;
        //this.ongoing = ongoing;
        this.freq = frequency;
        this.amount = this.setAmount(amount);
        this.name = name;
        this.type = type;
        this.schedule = this.newTransactionSchedule(next, freq);
        
        
        
        
        
        
    }
    
    private float setAmount(float amt){
        if (this.freq.equals("weekly")){
            float weeklyAmt = amt * 4.33f;
            return weeklyAmt;
        }
        else{
            return amt;
        }
    }
    
    public ArrayList getTransSched(){
        return schedule;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    //public boolean isOngoing() {
    //    return ongoing;
    //}

    //public void setOngoing(boolean ongoing) {
    //    this.ongoing = ongoing;
    //}

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public float getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private ArrayList newTransactionSchedule(int next, String freq){
        
        ArrayList<Integer> schedule = new ArrayList<>();
        ArrayList<Integer> monthList = Month.monthIntSorter();  // list of integers 1-12
        
        final int MONTHS = 12;
        int startMonth = next;
        
        try{

        // populates transaction schedule
        for (int i = 0; i < MONTHS; i++){
            schedule.add(0);
        }
        if ("monthly".equals(freq) || "weekly".equals(freq)) {          
            
            for (int i = 0; i < MONTHS; i++){
                if (startMonth == monthList.get(i)){
                    
                    for (int p = MONTHS; p > i - 1; p--){
                        schedule.set(p - 1 ,1);
                    }
                    
                    break;       
            }
            }
        }
        
        else if("annually".equals(freq)){
            
            for (int i = 0; i<12; i++){
                if (monthList.get(i) == startMonth){
                    schedule.set(i,1);
                }
            }
            
        }
        
        else if("quarterly".equals(freq)){
        
            for (int i = 0; i<12; i++){
                if (monthList.get(i) == startMonth){
                    schedule.set(i,1);
                    
                    if(i + 3 < 12){
                        schedule.set(i + 3, 1);
                    }
                    else {
                        int m = i + 3 - 12;
                        schedule.set(m,1);
                    }
                    
                    if(i + 6 < 12){
                        schedule.set(i + 6, 1);
                    }
                    else {
                        int m = i + 6 - 12;
                        schedule.set(m,1);
                    }
                    
                    if(i + 9 < 12){
                        schedule.set(i + 9, 1);
                    }
                    else {
                        int m = i + 9 - 12;
                        schedule.set(m,1);
                    }

                }
            } 
        }
        }
        catch(Exception e){
            showMessageDialog(null,"There was an error generating the transaction schedule!");
        }
        return schedule;
        }
       
    
}
