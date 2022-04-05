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
        String output = "Pantitlán - La Paz Thursday 2.00";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with single score of 3 returns that score for that route on that weekday")
    void single_route_single_weekday_single_score_value_3() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 3";
        String inputRoutes = "";
        String output = "Pantitlán - La Paz Thursday 3.00";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with single score of 10 returns insufficient scores msg")
    void single_route_single_weekday_single_score_value_10() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 10";
        String inputRoutes = "";
        String output = "Insufficient valid scores provided";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with single score of 0 returns insufficient scores msg")
    void single_route_single_weekday_single_score_value_0() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 0";
        String inputRoutes = "";
        String output = "Insufficient valid scores provided";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on different weekday with single score returns that score for that route on that weekday")
    void single_route_single_weekday_single_score_value_Wednesday() {
        String inputScore = "2021/11/17;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 2";
        String inputRoutes = "";
        String output = "Pantitlán - La Paz Wednesday 2.00";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with multiple scores returns the average score for that route on that weekday")
    void single_route_single_weekday_multiple_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/11;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 6";
        String inputRoutes = "";
        String output = "Pantitlán - La Paz Thursday 5.00";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with multiple scores returns the average score for that route on that weekday")
    void single_route_single_weekday_multiple_score_values_b() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/11;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 6,route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 10";
        String inputRoutes = "";
        String output = "Pantitlán - La Paz Thursday 5.00";
        assertEquals(output, calculator.calculate_routes(inputScore, inputRoutes));
    }

}
