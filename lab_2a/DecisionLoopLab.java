
/*
 * DecisionLoopLab.java
 *
 */
package cs209.lab_2a;

import javax.swing.*;

public class DecisionLoopLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String title;       // Value entered by user; string type
        String costStr;     // Value entered by user; string type
        String categoryChoice, categoryStr = ""; 
        double cost, totalcost = 0.00;        // The double form of the user-entered video game cost/s
        int resp = 0;       // The user's response as to whether to continue
        int game_count = 0, category; // Counter to count games chosen by user

        // Initialize the output string to the empty string
        String outputStr = "";
        
        // Initialize output string for showing categories 
        String categoryOut = "\n1 Simulation \n2 Sports \n3 Action \n4 Strategy \n5 Role-Playing";

        // Loop to input information on the user's video game collection
        while (true) {
            ++game_count; // Increment game counter when game is registered
            // Read in video game title from user as a string
            title = JOptionPane.showInputDialog("Enter video game title");

            // Read in cost from user as a string
            costStr = JOptionPane.showInputDialog("Enter video game cost");
            
            // Convert from type String to type double
            cost = Double.parseDouble(costStr);
            totalcost = totalcost + cost;
            
            // Get game category from user as a string
            categoryChoice = JOptionPane.showInputDialog("Choose category from list" + categoryOut);
            category = Integer.parseInt(categoryChoice); // Convert category string to int for switch 
            
            switch(category)
            {
                case 1: // Choose Simulation
                    categoryStr = "Simulation";
                    break;
                case 2: // Choose Sports
                    categoryStr = "Sports";
                    break;
                case 3: // Choose Action
                    categoryStr = "Action";
                    break;
                case 4: // Choose Strategy
                    categoryStr = "Strategy";
                    break;
                case 5: // Choose Role-Playing
                    categoryStr = "Role-Playing";
                    break;
                default:
                    System.out.println("Error in switch(category)");
                    break;
            }
            
            // Add the user-entered values to the output string 
            outputStr = outputStr + game_count + ". Video game title: " + title + ", ";
            outputStr = outputStr + "Category: " + categoryStr + ", ";
            outputStr = outputStr + "Cost: " + cost + ", ";
            outputStr = outputStr + "Total Cost: " + totalcost + "\n";
            
            // Get the user's choice as to whether to continue the loop
            resp = JOptionPane.showConfirmDialog(null, outputStr + "\nContinue?", "Confirm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            // Test whether the user's choice is to continue the loop or not
            if (resp == JOptionPane.NO_OPTION) {
                break;
            }
        }

        // Display final output to the user
        JOptionPane.showMessageDialog(
                null, outputStr, "Video Game List", JOptionPane.INFORMATION_MESSAGE);

    }
}