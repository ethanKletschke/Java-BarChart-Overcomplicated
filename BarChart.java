import java.util.Scanner;

/**
 * The <code>BarChart</code> class defines a CLI-based bar chart made with
 * asterisks, utilising parallel arrays.
 * @author Ethan Kletschke
 */
public final class BarChart {
    /// The names of each player.
    private final String[] names;
    /// The scores for each player.
    private final int[] scores;
    /// The size of the bar chart (length of the parallel arrays).
    private final int size;
    
    /**
     * The constructor initialises the arrays, and the size of the
     * bar chart.
     * @param size The size of the BarChart.
     */
    public BarChart(int size) {
        // Initialise arrays to have a specified number of members.
        names = new String[size];
        scores = new int[size];
        // Set the overall size as a final field.
        this.size = size;
        
        // Initialise array members.
        for (int i = 0; i < size; i++) {
            names[i] = "";
            scores[i] = 0;
        }
    }
    
    /**
     * The <code>printBars()</code> method is a private method which displays
     * a single bar on the chart.
     * 
     * @see BarChart#displayChart()
     * @param name The name of the player to enter the <code>score</code>.
     * @param score The score of the player specified in the <code>name</code>
     * parameter.
     */
    private void printBars(String name, int score) {
        // Display the names on the y-axis.
        System.out.print(name + "\t|  ");
        
        // Print an asterisk for each point in the score.
        for (int i = 0; i < score; i++) {
            System.out.print("*");
        }
        
        /*
        Displays the score in brackets after the bar, to make the score
        more readable
        */
        System.out.println(" (" + score + ")");
    }
    
    /**
     * The <code>takeInput()</code> method takes input for each player 
     * up to the size of the bar chart specified in the constructor. It throws 
     * an exception if the user inputs invalid data.
     * @throws IllegalArgumentException
     */
    public void takeInput() throws IllegalArgumentException {
        // Initialise a Scanner object.
        Scanner sc = new Scanner(System.in);
        
        /*
        Take user input for each player, up to the specified size of the 
        array.
        */
        for (int i = 0; i < size; i++) {
            System.out.print("Name #" + (i + 1) + ": ");
            names[i] = sc.next();
            
            if (names[i].matches(".*\\d.*")) {
                throw new IllegalArgumentException("Names cannot contain numbers!");
            }
            
            System.out.print("Score for " + names[i] + ": ");
            scores[i] = sc.nextInt();
        }
        
        // Close the scanner.
        sc.close();
    }
    
    /**
     * The <code>displayChart()</code> method displays the chart in a 
     * formatted manner.
     */
    public void displayChart() {
        // Display the heading of the bar chart.
        System.out.println("\n\t\t\tPoints for Game:\n");
        
        // Print each bar.
        for (int i = 0; i < size; i++) {
            printBars(names[i], scores[i]);
        }
        
        // Display the x-axis separator.
        System.out.println("\t-------------------------------------------------");
        
        // Display the x-axis title.
        System.out.println("\t\tBasketball score (* = 1 point)");
        
        // Skip a line for readability.
        System.out.println();
    }
}
