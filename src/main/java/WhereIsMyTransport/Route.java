package WhereIsMyTransport;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class Route {
    private String routeId;
    private String routeName;
    private Hashtable<String, ArrayList<Double>> scoresByWeekDay = new Hashtable<String, ArrayList<Double>>(7);
    private Hashtable<String, Double> averageScoresByWeekDay = new Hashtable<String, Double>(7);

    public Route(String routeId, String routeName) {
            this.routeId = routeId;
            this.routeName = routeName;

            // Create a private hashtable for the scores per weekday
            this.scoresByWeekDay.put("Monday", new ArrayList<Double>());
            this.scoresByWeekDay.put("Tuesday", new ArrayList<Double>());
            this.scoresByWeekDay.put("Wednesday", new ArrayList<Double>());
            this.scoresByWeekDay.put("Thursday", new ArrayList<Double>());
            this.scoresByWeekDay.put("Friday", new ArrayList<Double>());
            this.scoresByWeekDay.put("Saturday", new ArrayList<Double>());
            this.scoresByWeekDay.put("Sunday", new ArrayList<Double>());

            // Create a publicly accessible hashtable for the average scores per weekday
            this.averageScoresByWeekDay.put("Monday", 0.0);
            this.averageScoresByWeekDay.put("Tuesday", 0.0);
            this.averageScoresByWeekDay.put("Wednesday", 0.0);
            this.averageScoresByWeekDay.put("Thursday", 0.0);
            this.averageScoresByWeekDay.put("Friday", 0.0);
            this.averageScoresByWeekDay.put("Saturday", 0.0);
            this.averageScoresByWeekDay.put("Sunday", 0.0);
    }

    public void addScoreToRoute(Score score) {
        if (score.getScoreRoute().equals(this.routeId)) {
            // Check if the score is valid
            if (score.getScoreDouble() != 10.0 && score.getScoreDouble() != 0.0) {
                // Add the score to the corresponding weekday's array of scores
                switch (score.getDayOfWeek()) {
                    case "Monday":   this.scoresByWeekDay.get("Monday").add(score.getScoreDouble());
                        break;
                    case "Tuesday":   this.scoresByWeekDay.get("Tuesday").add(score.getScoreDouble());
                        break;
                    case "Wednesday":   this.scoresByWeekDay.get("Wednesday").add(score.getScoreDouble());
                        break;
                    case "Thursday":   this.scoresByWeekDay.get("Thursday").add(score.getScoreDouble());
                        break;
                    case "Friday":   this.scoresByWeekDay.get("Friday").add(score.getScoreDouble());
                        break;
                    case "Saturday":   this.scoresByWeekDay.get("Saturday").add(score.getScoreDouble());
                        break;
                    default:            this.scoresByWeekDay.get("Sunday").add(score.getScoreDouble());
                        break;
                }
                // Update the publicly accessible average
                calculateRouteAverages();
            }
        }

    }

    private void calculateRouteAverages() {
        // Iterate over each weekday
        Set<String> setOfWeekdays = this.averageScoresByWeekDay.keySet();
        for(String weekday : setOfWeekdays) {
            Double sum = 0.0;
            int validScores = 0;
            Double average = 0.0;
            // If the score is valid, add to the sum for this weekday
            for (int i = 0; i < this.scoresByWeekDay.get(weekday).size(); i++) {
                if (this.scoresByWeekDay.get(weekday).size() > 0) {
                    Double score = this.scoresByWeekDay.get(weekday).get(i);
                    sum += score;
                    validScores++;
                }
            }
            // Calculate the average of all valid scores
            if (validScores > 0) {
                average = sum/validScores;
            }
            this.averageScoresByWeekDay.put(weekday, average);
        }
    }

    public Map<String, String> orderScores() {
        // Order the hashtable by top scores, courtesy of https://www.javacodeexamples.com/sort-hashtable-by-values-in-java-example/3169
        // Get all the entries from the hashtable and put them in a List
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(this.averageScoresByWeekDay.entrySet());
        // Sort the entries based on the value, using a custom Comparator
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>(){

            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o2.getValue().compareTo( o1.getValue() );
            }

        });

        // Ensure the average score is formatted to two decimal points
        DecimalFormat df = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance(Locale.US));

        // Put all the sorted entries in a LinkedHashMap, which keeps the order in which the entries were added
        Map<String, String> mapSortedByScores = new LinkedHashMap<String, String>();

        for( Map.Entry<String, Double> entry : list  ){
            mapSortedByScores.put(entry.getKey(), df.format(entry.getValue()));
        }
        // System.out.println(mapSortedByScores);
        return mapSortedByScores;
    }

    public String getRouteId() {
        return routeId;
    }
    public String getRouteName() {
        return routeName;
    }

}


