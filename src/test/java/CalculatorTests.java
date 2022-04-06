import static org.junit.jupiter.api.Assertions.assertEquals;


import WhereIsMyTransport.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CalculatorTests {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("Single route on single weekday with single score of 2 returns that score for that route on that weekday")
    void single_route_single_weekday_single_score_value_2() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 2";
        String inputRoutes = "";
        String output = "Pantitlán - La Paz Thursday 2.00\n";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with single score of 3 returns that score for that route on that weekday")
    void single_route_single_weekday_single_score_value_3() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 3";
        String inputRoutes = "";
        String output = "Pantitlán - La Paz Thursday 3.00\n";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with single score of 10 returns insufficient scores msg")
    void single_route_single_weekday_single_score_value_10() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 10";
        String inputRoutes = "";
        String output = "";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with single score of 0 returns insufficient scores msg")
    void single_route_single_weekday_single_score_value_0() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 0";
        String inputRoutes = "";
        String output = "";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on different weekday with single score returns that score for that route on that weekday")
    void single_route_single_weekday_single_score_value_Wednesday() {
        String inputScore = "2021/11/17;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 2";
        String inputRoutes = "";
        String output = "Pantitlán - La Paz Wednesday 2.00\n";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with 2 valid scores returns the average score for that route on that weekday")
    void single_route_single_weekday_two_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/11;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 6";
        String inputRoutes = "";
        String output = "Pantitlán - La Paz Thursday 5.00\n";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with multiple valid scores returns the average score for that route on that weekday")
    void single_route_single_weekday_multiple_valid_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/11;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 6,2021/11/04;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 7";
        String inputRoutes = "";
        String output = "Pantitlán - La Paz Thursday 5.67\n";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with multiple valid and invalid scores returns the average score for that route on that weekday")
    void single_route_single_weekday_multiple_valid_and_invalid_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/11;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 6,2021/11/04;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 10";
        String inputRoutes = "";
        String output = "Pantitlán - La Paz Thursday 5.00\n";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with only invalid scores returns insufficient scores msg")
    void single_route_single_weekday_multiple_invalid_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 0,2021/11/11;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 10";
        String inputRoutes = "";
        String output = "";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on two weekdays with multiple scores returns the average score for that route on each weekday")
    void single_route_multiple_weekday_multiple_valid_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/11;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 6,2021/11/10;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/17;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 9";
        String inputRoutes = "";
        String output = "Pantitlán - La Paz Wednesday 6.50\nPantitlán - La Paz Thursday 5.00\n";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on multiple weekdays with multiple valid and invalid scores returns the average score for that route on each weekday")
    void single_route_multiple_weekday_multiple_valid_and_invalid_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/11;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 10,2021/11/10;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/10;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 9,2021/11/04;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 6,2021/11/16;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 0,2021/11/15;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/14;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 0";
        String inputRoutes = "";
        String output = "Pantitlán - La Paz Monday 4.00\nPantitlán - La Paz Wednesday 6.50\nPantitlán - La Paz Thursday 5.00\n";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }
}
