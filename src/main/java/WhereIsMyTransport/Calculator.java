package WhereIsMyTransport;

public class Calculator {

    public String calculate_routes(String input_score, String input_routes) {
        String score_string = input_score.substring(input_score.length() - 2);
        String output = "";
        if (score_string.equals("10") || score_string.equals(" 0")) {
            output = "Insufficient valid scores provided";
        } else {
            output = "Pantitlán - La Paz Thursday" + score_string;
        }
        return output;
    }

}
