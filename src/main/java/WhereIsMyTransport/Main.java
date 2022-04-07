package WhereIsMyTransport;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /* Create file objects to read from the files, scanner objects to search
         * the files, formatter to write the output, and an instance of the
         * Calculator class.
         */
        File referenceDataFile = new File("reference-data.txt");
        Scanner referenceDataScanner = null;
        String referenceDataString = "";

        File scoresFile = new File("scores.txt");
        Scanner scoresScanner = null;
        String scoresString = "";

        Calculator calculator = new Calculator();

        Formatter results = null;

        try {
            // Initialise Scanner instance within try/catch block
            referenceDataScanner = new Scanner(referenceDataFile);
            scoresScanner = new Scanner(scoresFile);

            // Read each line of the given file and add to the string
            while(referenceDataScanner.hasNextLine()){

                String line = referenceDataScanner.nextLine();
                referenceDataString += line + ",";
            }
            while(scoresScanner.hasNextLine()){

                String line = scoresScanner.nextLine();
                scoresString += line + ",";
            }

            // Calculate the averages
            String averageScores = calculator.calculateTransportFeedback(scoresString,referenceDataString);

            // Write the averages to the file
            results = new Formatter("results.txt");
            results.format("%s", averageScores);
        }

        // In case there is an error, print to the console instead of crashing
        catch (Exception e) {
            System.out.println("Error");
            System.out.println(e);
        }

        // Close the scanners and formatters
        finally {
            referenceDataScanner.close();
            scoresScanner.close();
            results.close();
        }

    }
}
