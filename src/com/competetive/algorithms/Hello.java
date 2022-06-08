//Java Program that is been setup in Sublime Text
// for Competitive Coding
  
// Importing input output classes
import java.io.*;
// Importing Scanner class from java.util package
import java.util.Scanner;
  
// Main Class
class Hello {
  
    // Main driver method
    public static void main(String[] args)
    {
  
        // Setting up the input stream
        // You can use buffered reader too
        Scanner read = new Scanner(System.in);
  
        // If You Are Running Your Code
        // in Sublime Text then set The
        // System Out to output.txt and
        // Input Stream to input.txt
        // otherwise leave it as standard
        // ones for ONLINE JUDGE
        if (System.getProperty("ONLINE_JUDGE") == null) {
            // Try block to check for exceptions
            try {
                // Sets the Output Stream
                // to output.txt
                System.setOut(new PrintStream(
                    new FileOutputStream("output.txt")));
  
                // Change the input stream
                // to input.txt
                read = new Scanner(new File("input.txt"));
            }
  
            // Catch block to handle the exceptions
            catch (Exception e) {
            }
        }
  
        // Your Code Start Here
  
        // Read input
        String inp = read.nextLine();
  
        // Print output
        System.out.println(inp + " World!");
    }
}