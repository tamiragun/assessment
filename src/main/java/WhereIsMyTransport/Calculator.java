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
        // Create a map of the routes and their names
        Hashtable<String,String> routesAndNames = new Hashtable<>();
        // Create a map of each route and the weekdays
        Map<String,Map<String, ArrayList<Double>>> routesAndWeekdays = Collections.synchronizedMap(new LinkedHashMap<String,Map<String, ArrayList<Double>>>());
        // Split the input routes
        String[] inputRouteList = inputRoutes.split(",");
        // Add each route info to the hashtable
        for (int i = 0; i< inputRouteList.length; i++) {
            String[] routeElements = inputRouteList[i].split(";");
            String routeName = routeElements[1];
            String[] routeIdElements = routeElements[0].split(" ");
            String RouteId = routeIdElements[0];
            routesAndNames.put(RouteId, routeName);

            // Create a synchronised map for the weekdays
            Map<String, ArrayList<Double>> weekDays = Collections.synchronizedMap(new LinkedHashMap<String, ArrayList<Double>>(7));
            routesAndWeekdays.put(RouteId, weekDays);
            routesAndWeekdays.get(RouteId).put("Monday", new ArrayList<Double>());
            routesAndWeekdays.get(RouteId).put("Tuesday", new ArrayList<Double>());
            routesAndWeekdays.get(RouteId).put("Wednesday", new ArrayList<Double>());
            routesAndWeekdays.get(RouteId).put("Thursday", new ArrayList<Double>());
            routesAndWeekdays.get(RouteId).put("Friday", new ArrayList<Double>());
            routesAndWeekdays.get(RouteId).put("Saturday", new ArrayList<Double>());
            routesAndWeekdays.get(RouteId).put("Sunday", new ArrayList<Double>());
        }

       // Split the input scores
        String[] inputScores = inputScore.split(",", 0);

        // Initiate the output string
        String output = "";

        // Iterate over the scores
        for( int i = 0; i < inputScores.length; i++) {
            // Split the score into date, rote, and score
            String[] inputScoreArray = inputScores[i].split(";");
            // Extract the date
            String inputDate = inputScoreArray[0];
            // Extract the day of the week from the date, courtesy of https://www.baeldung.com/java-get-day-of-week
            String dayOfWeek = this.getDayString(inputDate);
            // Extract the route
            String[] routeScoreArray = inputScoreArray[1].split(" ");
            String route = routeScoreArray[0];
            String routeName = routesAndNames.get(route);
            // Extract the score from the string
            String scoreString = routeScoreArray[1];
            // Convert it to double
            Double scoreDouble = Double.parseDouble(scoreString);
            // Discard scores 0 and 10 and add others to the sum
            if (scoreDouble != 10.0 && scoreDouble != 0.0) {
                switch (dayOfWeek) {
                    case "Monday":   routesAndWeekdays.get(route).get("Monday").add(scoreDouble);
                        break;
                    case "Tuesday":   routesAndWeekdays.get(route).get("Tuesday").add(scoreDouble);
                        break;
                    case "Wednesday":   routesAndWeekdays.get(route).get("Wednesday").add(scoreDouble);
                        break;
                    case "Thursday":   routesAndWeekdays.get(route).get("Thursday").add(scoreDouble);
                        break;
                    case "Friday":   routesAndWeekdays.get(route).get("Friday").add(scoreDouble);
                        break;
                    case "Saturday":   routesAndWeekdays.get(route).get("Saturday").add(scoreDouble);
                        break;
                    default:            routesAndWeekdays.get(route).get("Sunday").add(scoreDouble);
                                        break;
                }
            }



        }

        // Calculate the average score for each weekday on each route

        // Iterate over each route
        Set<String> setOfRoutes = routesAndWeekdays.keySet();
        for(String route : setOfRoutes) {
            // Iterate over each weekday
            Set<String> setOfWeekdays = routesAndWeekdays.get(route).keySet();

            //String weekDayAverage = "";

            for(String weekday : setOfWeekdays) {
                Double sum = 0.0;
                int validScores = 0;
                Double average = 0.0;
                // If the score is valid, add to the sum for this weekday
                for (int j = 0; j < routesAndWeekdays.get(route).get(weekday).size(); j++) {
                    Double score = Double.parseDouble(routesAndWeekdays.get(route).get(weekday).get(j).toString());
                    sum += score;
                    validScores++;
                }
                // Calculate the average of all valid scores
                if (validScores > 0) {
                    average = sum/validScores;
                }

                // Ensure it is formatted to two decimal points
                DecimalFormat df = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance(Locale.US));
                String formattedAverage = df.format(average);
                // Formulate the output
                if (average != 0) {
                    output+= routesAndNames.get(route) + " " + weekday + " " +formattedAverage+"\n";
                };

            };
        }




        System.out.println(output);
        return output;
    }

}
