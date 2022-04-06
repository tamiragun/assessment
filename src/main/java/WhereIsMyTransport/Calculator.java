package WhereIsMyTransport;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;


public class Calculator {

    private String getDayString(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ENGLISH);
        LocalDate convertedDate = LocalDate.parse(date, formatter);
        DayOfWeek day = convertedDate.getDayOfWeek();
        return day.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public String calculate_routes(String inputScore, String inputRoutes) {
        // Create a synchronised map for the weekdays
        Map<String, ArrayList> weekDays = Collections.synchronizedMap(new LinkedHashMap<String, ArrayList>(7));
        weekDays.put("Monday", new ArrayList<Double>());
        weekDays.put("Tuesday", new ArrayList<Double>());
        weekDays.put("Wednesday", new ArrayList<Double>());
        weekDays.put("Thursday", new ArrayList<Double>());
        weekDays.put("Friday", new ArrayList<Double>());
        weekDays.put("Saturday", new ArrayList<Double>());
        weekDays.put("Sunday", new ArrayList<Double>());

        // Split the input scores
        String[] inputScores = inputScore.split(",", 0);
        // Initiate the output string
        String output = "";

        // Iterate over the scores
        for( int i = 0; i < inputScores.length; i++) {
            // Extract the date from the string
            String inputDate = inputScores[i].substring(0,10);
            // Extract the day of the week from the date, courtesy of https://www.baeldung.com/java-get-day-of-week
            String dayOfWeek = this.getDayString(inputDate);
            // Extract the score from the string
            String scoreString = inputScores[i].substring(inputScores[i].length() - 2);
            // Convert it to double
            Double scoreDouble = Double.parseDouble(scoreString);
            // Discard scores 0 and 10 and add others to the sum
            if (scoreDouble != 10.0 && scoreDouble != 0.0) {
                switch (dayOfWeek) {
                    case "Monday":   weekDays.get("Monday").add(scoreDouble);
                        break;
                    case "Tuesday":   weekDays.get("Tuesday").add(scoreDouble);
                        break;
                    case "Wednesday":   weekDays.get("Wednesday").add(scoreDouble);
                        break;
                    case "Thursday":   weekDays.get("Thursday").add(scoreDouble);
                        break;
                    case "Friday":   weekDays.get("Friday").add(scoreDouble);
                        break;
                    case "Saturday":   weekDays.get("Saturday").add(scoreDouble);
                        break;
                    default:            weekDays.get("Sunday").add(scoreDouble);
                                        break;
                }
            }

        }

        // Calculate the average score for each weekday

        Set<String> setOfWeekdays = weekDays.keySet();
        for(String key : setOfWeekdays) {
            Double sum = 0.0;
            int validScores = 0;
            Double average = 0.0;

            // If the score is valid, add to the sum for this weekday
            for (int i = 0; i < weekDays.get(key).size(); i++) {
                Double score = Double.parseDouble(weekDays.get(key).get(i).toString());
                sum += score;
                validScores++;
            }
            // Calculate the average of all valid scores
            if (validScores > 0) {
                average = sum/validScores;
            }

            // Ensure it is formatted to two decimal points
            DecimalFormat df = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance(Locale.US));
            // Formulate the output
            if (average != 0) {
                output += "Pantitlán - La Paz " + key + " " + df.format(average)+"\n";
            }

        };

        return output;
    }

}
