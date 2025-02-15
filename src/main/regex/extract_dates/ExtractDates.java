package org.example.regex.extract_dates;
import java.util.regex.*;
import java.util.*;

public class ExtractDates {
    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        //Regex for matching dates in dd/mm/yyyy format
        String regex = "\\b([0-2][0-9]|3[01])\\/(0[1-9]|1[0-2])\\/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> dates = new ArrayList<>();

        //Extract all dates
        while (matcher.find()) {
            dates.add(matcher.group());
        }

        for (String date : dates) {
            System.out.print(date + ", ");
        }
    }
}
