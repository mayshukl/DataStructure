package org.unnati.companies.cisco;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class WatchAngle {

    static int HOUR=12;
    static float find_angle_for_a_time_on_watch(int hour, int minute) {
        
        hour=hour%HOUR;
        
        float hourHandHour=360/HOUR;
        float hourHandMinute=hourHandHour/60;
        float minuteHand=360/60;
        
        float hourAngle=hourHandHour*hour +hourHandMinute*minute;
        float minuteAngle=minuteHand*minute;
        if(minuteAngle>hourAngle){
            return minuteAngle-hourAngle>180?hourAngle-minuteAngle:minuteAngle-hourAngle;
        }else{
            return hourAngle-minuteAngle>180?minuteAngle-hourAngle:hourAngle-minuteAngle;
        }
    }

    public static void main(String[] args) {
        System.out.println(roundAvoid(15.234,2));
    }
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
    
}
