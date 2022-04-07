package WhereIsMyTransport;

public class Score {

    private String scoreRoute;
    private String dayOfWeek;
    private Double scoreDouble;

    public Score (String inputScore) {
        // Split the score into date, rote, and score
        String[] inputScoreArray = inputScore.split(";");
        // Extract the date
        String inputDate = inputScoreArray[0];
        // Extract the day of the week from the date, courtesy of https://www.baeldung.com/java-get-day-of-week
        dayOfWeek = Calculator.getDayString(inputDate);
        // Extract the route
        String[] routeScoreArray = inputScoreArray[1].split(" ");
        this.scoreRoute = routeScoreArray[0];
        // Extract the score from the string
        String scoreString = routeScoreArray[1];
        // Convert it to a double
        this.scoreDouble = Double.parseDouble(scoreString);
    }

    public String getScoreRoute() {
        return scoreRoute;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public Double getScoreDouble() {
        return scoreDouble;
    }

}
