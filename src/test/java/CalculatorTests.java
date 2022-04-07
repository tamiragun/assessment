import static org.junit.jupiter.api.Assertions.assertEquals;


import WhereIsMyTransport.Calculator;
import org.junit.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CalculatorTests {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("Single route on single weekday with single score of 2 returns that score for that route on that weekday")
    void single_route_single_weekday_single_score_value_2() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 2";
        String inputRoutes = "route_4ac7ab76-d938-4b27-93a8-f1b678007dfe METRO;Pantitlán - La Paz";
        String output = "Pantitlán - La Paz Thursday 2.00\n";
        assertEquals(output, calculator.calculateRoutes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with single score of 3 returns that score for that route on that weekday")
    void single_route_single_weekday_single_score_value_3() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 3";
        String inputRoutes = "route_4ac7ab76-d938-4b27-93a8-f1b678007dfe METRO;Pantitlán - La Paz";
        String output = "Pantitlán - La Paz Thursday 3.00\n";
        assertEquals(output, calculator.calculateRoutes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with single score of 10 returns an empty string")
    void single_route_single_weekday_single_score_value_10() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 10";
        String inputRoutes = "route_4ac7ab76-d938-4b27-93a8-f1b678007dfe METRO;Pantitlán - La Paz";
        String output = "";
        assertEquals(output, calculator.calculateRoutes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with single score of 0 returns an empty string")
    void single_route_single_weekday_single_score_value_0() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 0";
        String inputRoutes = "route_4ac7ab76-d938-4b27-93a8-f1b678007dfe METRO;Pantitlán - La Paz";
        String output = "";
        assertEquals(output, calculator.calculateRoutes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on different weekday with single score returns that score for that route on that weekday")
    void single_route_single_weekday_single_score_value_Wednesday() {
        String inputScore = "2021/11/17;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 2";
        String inputRoutes = "route_4ac7ab76-d938-4b27-93a8-f1b678007dfe METRO;Pantitlán - La Paz";
        String output = "Pantitlán - La Paz Wednesday 2.00\n";
        assertEquals(output, calculator.calculateRoutes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with 2 valid scores returns the average score for that route on that weekday")
    void single_route_single_weekday_two_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/11;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 6";
        String inputRoutes = "route_4ac7ab76-d938-4b27-93a8-f1b678007dfe METRO;Pantitlán - La Paz";
        String output = "Pantitlán - La Paz Thursday 5.00\n";
        assertEquals(output, calculator.calculateRoutes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with multiple valid scores returns the average score for that route on that weekday")
    void single_route_single_weekday_multiple_valid_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/11;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 6,2021/11/04;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 7";
        String inputRoutes = "route_4ac7ab76-d938-4b27-93a8-f1b678007dfe METRO;Pantitlán - La Paz";
        String output = "Pantitlán - La Paz Thursday 5.67\n";
        assertEquals(output, calculator.calculateRoutes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with multiple valid and invalid scores returns the average score for that route on that weekday")
    void single_route_single_weekday_multiple_valid_and_invalid_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/11;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 6,2021/11/04;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 10";
        String inputRoutes = "route_4ac7ab76-d938-4b27-93a8-f1b678007dfe METRO;Pantitlán - La Paz";
        String output = "Pantitlán - La Paz Thursday 5.00\n";
        assertEquals(output, calculator.calculateRoutes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on single weekday with only invalid scores returns an empty string")
    void single_route_single_weekday_multiple_invalid_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 0,2021/11/11;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 10";
        String inputRoutes = "route_4ac7ab76-d938-4b27-93a8-f1b678007dfe METRO;Pantitlán - La Paz";
        String output = "";
        assertEquals(output, calculator.calculateRoutes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on two weekdays with multiple scores returns the average score for that route on each weekday")
    void single_route_multiple_weekday_multiple_valid_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/11;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 6,2021/11/10;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/17;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 9";
        String inputRoutes = "route_4ac7ab76-d938-4b27-93a8-f1b678007dfe METRO;Pantitlán - La Paz";
        String output = "Pantitlán - La Paz Wednesday 6.50\nPantitlán - La Paz Thursday 5.00\n";
        assertEquals(output, calculator.calculateRoutes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Single route on multiple weekdays with multiple valid and invalid scores returns the average score for that route on each weekday")
    void single_route_multiple_weekday_multiple_valid_and_invalid_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/11;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 10,2021/11/10;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/10;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 9,2021/11/04;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 6,2021/11/16;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 0,2021/11/15;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/14;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 0";
        String inputRoutes = "route_4ac7ab76-d938-4b27-93a8-f1b678007dfe METRO;Pantitlán - La Paz";
        String output = "Pantitlán - La Paz Monday 4.00\nPantitlán - La Paz Wednesday 6.50\nPantitlán - La Paz Thursday 5.00\n";
        assertEquals(output, calculator.calculateRoutes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Two routes on single weekdays with single valid scores returns the average score for each route on that weekday")
    void multiple_routes_single_weekday_single_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/11;route_66d0f0b7-da84-4e1a-b37d-7122248ff9f9 3";
        String inputRoutes = "route_4ac7ab76-d938-4b27-93a8-f1b678007dfe METRO;Pantitlán - La Paz,route_66d0f0b7-da84-4e1a-b37d-7122248ff9f9 METRO;El Rosario - Martín Carrera";
        String output = "Pantitlán - La Paz Thursday 4.00\nEl Rosario - Martín Carrera Thursday 3.00\n";
        assertEquals(output, calculator.calculateRoutes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Two routes on two weekdays with single valid scores returns the score for each route on each weekday")
    void multiple_routes_multiple_weekday_single_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/10;route_66d0f0b7-da84-4e1a-b37d-7122248ff9f9 3";
        String inputRoutes = "route_4ac7ab76-d938-4b27-93a8-f1b678007dfe METRO;Pantitlán - La Paz,route_66d0f0b7-da84-4e1a-b37d-7122248ff9f9 METRO;El Rosario - Martín Carrera";
        String output = "Pantitlán - La Paz Thursday 4.00\nEl Rosario - Martín Carrera Wednesday 3.00\n";
        assertEquals(output, calculator.calculateRoutes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Multiple routes on multiple weekdays with multiple valid scores returns the average score for each route on each weekday")
    void multiple_routes_multiple_weekday_multiple_valid_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/04;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 6,2021/11/10;route_66d0f0b7-da84-4e1a-b37d-7122248ff9f9 3,2021/11/03;route_66d0f0b7-da84-4e1a-b37d-7122248ff9f9 6";
        String inputRoutes = "route_4ac7ab76-d938-4b27-93a8-f1b678007dfe METRO;Pantitlán - La Paz,route_66d0f0b7-da84-4e1a-b37d-7122248ff9f9 METRO;El Rosario - Martín Carrera";
        String output = "Pantitlán - La Paz Thursday 5.00\nEl Rosario - Martín Carrera Wednesday 4.50\n";
        assertEquals(output, calculator.calculateRoutes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Multiple routes on multiple weekdays with multiple valid and invalid scores returns the average score for each route on each weekday")
    void multiple_routes_multiple_weekday_multiple_valid_and_invalid_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 4,2021/11/04;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 6,2021/11/11;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 10,2021/11/10;route_66d0f0b7-da84-4e1a-b37d-7122248ff9f9 3,2021/11/03;route_66d0f0b7-da84-4e1a-b37d-7122248ff9f9 6,2021/11/17;route_66d0f0b7-da84-4e1a-b37d-7122248ff9f9 0";
        String inputRoutes = "route_4ac7ab76-d938-4b27-93a8-f1b678007dfe METRO;Pantitlán - La Paz,route_66d0f0b7-da84-4e1a-b37d-7122248ff9f9 METRO;El Rosario - Martín Carrera";
        String output = "Pantitlán - La Paz Thursday 5.00\nEl Rosario - Martín Carrera Wednesday 4.50\n";
        assertEquals(output, calculator.calculateRoutes(inputScore, inputRoutes));
    }

    @Test
    @DisplayName("Multiple routes on multiple weekdays with only invalid scores returns an empty string")
    void multiple_routes_multiple_weekday_multiple_invalid_score_values() {
        String inputScore = "2021/11/18;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 0,2021/11/04;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 10,2021/11/11;route_4ac7ab76-d938-4b27-93a8-f1b678007dfe 10,2021/11/10;route_66d0f0b7-da84-4e1a-b37d-7122248ff9f9 0,2021/11/03;route_66d0f0b7-da84-4e1a-b37d-7122248ff9f9 10,2021/11/17;route_66d0f0b7-da84-4e1a-b37d-7122248ff9f9 0";
        String inputRoutes = "route_4ac7ab76-d938-4b27-93a8-f1b678007dfe METRO;Pantitlán - La Paz,route_66d0f0b7-da84-4e1a-b37d-7122248ff9f9 METRO;El Rosario - Martín Carrera";
        String output = "";
        assertEquals(output, calculator.calculateRoutes(inputScore, inputRoutes));
    }
}
