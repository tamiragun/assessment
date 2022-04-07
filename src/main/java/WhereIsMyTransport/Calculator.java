package WhereIsMyTransport;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;


public class Calculator {

    public static String getDayString(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ENGLISH);
        LocalDate convertedDate = LocalDate.parse(date, formatter);
        DayOfWeek day = convertedDate.getDayOfWeek();
        return day.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public String calculateRoutes(String inputScore, String inputRoutes) {
        // Create route map with the input  routes
        RouteMapping routeMap = new RouteMapping(inputRoutes);
        // Iterate over the scores
        String[] scores = inputScore.split(",");

        for( int i = 0; i < scores.length; i++) {
            // Create a score object
            Score score = new Score(scores[i]);
            String scoreRoute = score.getScoreRoute();

            // Match the score object to the route, then add the score to the route
            routeMap.getRoutesAndNames().get(scoreRoute).addScoreToRoute(score);
        }

        // Create a string for the final output
        String output = "";

        // Iterate over the routes
        Set<String> setOfRoutes = routeMap.getRoutesAndNames().keySet();
        for(String route : setOfRoutes) {
            // Order the weekdays by score
            Map<String, String> orderedScores = routeMap.getRoutesAndNames().get(route).orderScores();
            //System.out.println(orderedScores);
            // Iterate over the weekdays
            Set<String> setOfWeekdays = orderedScores.keySet();
            for(String weekday : setOfWeekdays) {
                // Include only if the average is not zero
                if (!orderedScores.get(weekday).equals(".00")) {
                    // Add the line to the final output string
                    output += routeMap.getRoutesAndNames().get(route).getRouteName() + " " + weekday + " " + orderedScores.get(weekday) + "\n";
                }
            }
        }

        return output;
    }

}
