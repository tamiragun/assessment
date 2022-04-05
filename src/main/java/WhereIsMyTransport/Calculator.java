package WhereIsMyTransport;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;


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
        // Convert it to double
        Double scoreDouble = Double.parseDouble(scoreString);
        // Ensure it is formatted to two decimal points
        DecimalFormat df = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance(Locale.US));
        // Extract the date from the string
        String inputDate = inputScore.substring(0,10);
        // Extract the day of the week from the date, courtesy of https://www.baeldung.com/java-get-day-of-week
        String dayOfWeek = this.getDayString(inputDate);


        String output = "";
        // Discard scores 0 and 10
        if (scoreDouble == 10.0 || scoreDouble == 0.0) {
            output = "Insufficient valid scores provided";
        } else {
            output = "Pantitlán - La Paz " + dayOfWeek + " " + df.format(scoreDouble);
        }
        return output;
    }

}
