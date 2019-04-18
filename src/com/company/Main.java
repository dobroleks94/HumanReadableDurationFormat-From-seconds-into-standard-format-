package com.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(formatDuration(3662));
    }

    public static String formatDuration(int seconds) {
        if( seconds == 0)
            return "now";
        int SS = seconds%60;
        int MM = ((seconds-SS)/60)%60;
        int HH = ((seconds-MM*60-SS)/3600)%24;
        int DD = ((seconds-HH*3600-MM*60-SS)/(24*3600))%365;
        int YY = ((seconds - DD*24*3600 - HH*3600 - MM*60 - SS)/(365*24*3600));

        LinkedHashMap<String, Integer> forms = new LinkedHashMap<>();
        forms.put("year", YY);
        forms.put("day", DD);
        forms.put("hour", HH);
        forms.put("minute", MM);
        forms.put("second", SS);
        List<String> format = new ArrayList<>();
        for(String i : forms.keySet())
            if(forms.get(i) != 0) {
                if(forms.get(i) == 1)
                    format.add(String.format("%d %s", forms.get(i), i));
                else
                    format.add(String.format("%d %ss", forms.get(i), i));
            }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<format.size(); i++) {
            res.append(format.get(i));
            if(i<format.size() - 1) {
                if (i == format.size() - 2) {
                    res.append(" and ");
                    continue;
                }
                res.append(", ");
            }
        }
        return res.toString();
    }
}
