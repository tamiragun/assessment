# Transport feedback assessment

### To run this project on your local computer:
To install and run this programme on your local computer, you will need JDE and JRE 17, and Maven.
1. Clone the repository to your local computer and navigate to the directory where you saved the repository.
3. Inside the repository, start a terminal window. Type `mvn install` and wait for the process to run. This will ensure that you have JUnit installed, which is what I used for testing.
5. Run the programme and check the root directory of the project, where the output file should appear.

### Notes on my implementation:
* I made use of TDD to build out the main logic in the Calculator class - see src/main/test/java/CalculatorTests.java.
* I used different classes to separate concerns.
* If hosting a database were not a concern for submitting this task, I would probably have gone that route.
* I researched solutions online for converting dates into weekdays and for ordering a hashtable by values.

### Given more time, I would:
* Include more error handling in the classes and methods.
* Refactor my code so there is less reliance on hash tables and iterating over them.
* Write unit tests for the other classes' methods as well.
* Add a database with tables for routes, scores, and route names, populate the database based on the file input, and use SQL to tabulate and sort the results accordingly.
* Refactor my test code to group related tests together and remove duplication.
* Add Javadoc documentation.