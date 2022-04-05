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

    public String calculate_routes(String input_score, String input_routes) {
        // Extract the score from the string
        String score_string = input_score.substring(input_score.length() - 2);
        // Extract the date from the string
        String inputDate = input_score.substring(0,10);
        // Extract the day of the week from the date, courtesy of https://www.baeldung.com/java-get-day-of-week
        String dayOfWeek = this.getDayString(inputDate);


        String output = "";
        // Discard scores 0 and 10
        if (score_string.equals("10") || score_string.equals(" 0")) {
            output = "Insufficient valid scores provided";
        } else {
            output = "Pantitlán - La Paz "+ dayOfWeek + score_string;
        }
        return output;
    }

}
