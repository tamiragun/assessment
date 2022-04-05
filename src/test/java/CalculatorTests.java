import static org.junit.jupiter.api.Assertions.assertEquals;


import WhereIsMyTransport.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CalculatorTests {
    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("Single route on single weekday with single score of 2 returns that score for that route on that weekday")
    void single_route_single_weekday_single_score_value_2() {
        String input_score = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 2";
        String input_routes = "";
        String output = "Pantitlán - La Paz Thursday 2";
        assertEquals(output, calculator.calculate_routes(input_score, input_routes));
    }

}
