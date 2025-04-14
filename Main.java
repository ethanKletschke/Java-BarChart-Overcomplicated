import java.util.Scanner;

/**
 * The <code>Main</code> class is the class which contains the
 * <code>main()</code> method.
 *
 * @author EthanKletschke
 */
public class Main {
    public static void main(String[] args) {
        try {
            String userIn; // The user input variable.
            int sizeOfBarChart; // The size of the bar chart
            // Initialise a scanner.
            Scanner sc = new Scanner(System.in);

            // Take input for the number of players/size of the bar chart.
            System.out.print("Enter the number of players to chart: ");
            
            // Taken as a string to simplify exception handling.
            userIn = sc.nextLine();
            
            // Test if the user didn't enter a number at all.
            if (!userIn.matches(".*\\d.*")) {
                throw new IllegalArgumentException("You did not enter a number!");
            }
            
            // Store the actual integer entered in the string input.
            sizeOfBarChart = Integer.parseInt(userIn);
            
            // Display a separator for readability
            System.out.println("=============");
            
            // Initialise the bar chart object.
            BarChart bc = new BarChart(sizeOfBarChart);

            try {
                // Take input for the players' scores.
                bc.takeInput();
            } catch (IllegalArgumentException e) {
                // catch the potential exception thrown by the "takeInput()" method
                System.err.println(e.getMessage());
                System.exit(-1);
            } catch (Exception e) {
                // Display a message and exit with status -1.
                System.err.println("Unspecified error. Exiting...");
                System.exit(-1);
            }

            // Display the bar chart
            bc.displayChart();

        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input entered.\nExiting...");
            System.exit(-1);
        } catch (Exception e) {
            System.err.println("Unspecified Exception Occured.\nExiting...");
            System.exit(-1);
        }
    }
}
