package WhereIsMyTransport;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;;


public class Calculator {

    private String getDayString(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ENGLISH);
        LocalDate convertedDate = LocalDate.parse(date, formatter);
        DayOfWeek day = convertedDate.getDayOfWeek();
        return day.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public String calculate_routes(String inputScore, String inputRoutes) {
        // Extract the score from the string
        String scoreString = inputScore.substring(inputScore.length() - 2);
        // Extract the date from the string
        String inputDate = inputScore.substring(0,10);
        // Extract the day of the week from the date, courtesy of https://www.baeldung.com/java-get-day-of-week
        String dayOfWeek = this.getDayString(inputDate);


        String output = "";
        // Discard scores 0 and 10
        if (scoreString.equals("10") || scoreString.equals(" 0")) {
            output = "Insufficient valid scores provided";
        } else {
            output = "Pantitlán - La Paz "+ dayOfWeek + scoreString;
        }
        return output;
    }

}
