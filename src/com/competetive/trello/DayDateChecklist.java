package com.competetive.trello;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DayDateChecklist {

    public static void main(String[] args) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        // year += 1;
        for (int month = 1; month <= 12; month++) {
            int daysInMonth = getDaysInMonth(year, month);
            for (int day = 1; day <= daysInMonth; day++) {
                String date = String.format("%d-%02d-%02d", year, month, day);
                String dayOfWeek = getDayOfWeek(year, month, day);
                String 
                subjects =   "Mathematics" + "\n";
                subjects +=  "Physics" + "\n";
                subjects +=  "Chemistry" + "\n";
                subjects +=  "Informatics Practices" + "\n";
                subjects +=  "English" + "\n";
                subjects +=  "Lab Chemistry" + "\n";
                subjects +=  "Lab Physics" + "\n";
                subjects +=  "Lab Computer" + "\n";

                String checklistItem = "3 SUBJECTS DONE for today ? " + String.format("%s (%s)", date, dayOfWeek);
                // String checklistItemEve = "Evening:: " + String.format("%s (%s)", date, dayOfWeek);  
                System.out.println(subjects + checklistItem);
                // System.out.println(checklistItemEve);
                // You can add code here to create the checklist item in Trello using API or other methods
            }
        }
    }

    private static int getDaysInMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    private static String getDayOfWeek(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        return dateFormat.format(calendar.getTime());
    }
}
