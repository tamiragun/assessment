package WhereIsMyTransport;

public class Calculator {

    public String calculate_routes(String input_score, String input_routes) {
        String score_string = input_score.substring(input_score.length() - 2);
        return "Pantitlán - La Paz Thursday" + score_string;
    }

}
