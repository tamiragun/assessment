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

        // Split the input scores
        String[] inputScores = inputScore.split(",", 0);
        System.out.println(inputScores[0]);
        // Initiate the weekday variable
        String dayOfWeek = "";
        // Initiate the sum and total valid scores
        Double sumOfScores = 0.0;
        int validScores = 0;

        // Iterate over the scores
        for( int i = 0; i < inputScores.length; i++) {
            // Extract the score from the string
            String scoreString = inputScores[i].substring(inputScores[i].length() - 2);
            // Convert it to double
            Double scoreDouble = Double.parseDouble(scoreString);
            // Discard scores 0 and 10 and add others to the sum
            if (scoreDouble != 10.0 && scoreDouble != 0.0) {
                sumOfScores += scoreDouble;
                validScores++;
            }
            // Extract the date from the string
            String inputDate = inputScore.substring(0,10);
            // Extract the day of the week from the date, courtesy of https://www.baeldung.com/java-get-day-of-week
            dayOfWeek = this.getDayString(inputDate);
        }

        // Calculate the average score
        Double average = sumOfScores/validScores;
        // Ensure it is formatted to two decimal points
        DecimalFormat df = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance(Locale.US));

        // Formulate the output
        String output = "";
        if (Double.isNaN(average)) {
            output = "Insufficient valid scores provided";
        } else {
            output = "Pantitlán - La Paz " + dayOfWeek + " " + df.format(average);
        }

        return output;
    }

}
