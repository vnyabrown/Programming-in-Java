/**
 *
 * @author Mike
 */

import java.util.*;
import javax.swing.*;
 import java.text.*;

public class aClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DecimalFormat prec2 = new DecimalFormat ("$#.00"); 
        
        String title;       // Value entered by user; string type
        String costStr;     // Value entered by user; string type
        String categoryChoice, categoryStr = ""; 
        String purchaseCostLevel = "", totalCostLevel = ""; 
        String Discount ="";
        double cost, totalcost = 0.00, finalcost = 0.00;        // The double form of the user-entered video game cost/s
        double discountPercent = 0.00;
        int resp = 0;       // The user's response as to whether to continue
        int game_count = 0, category; // Counter to count games chosen by user

        // Initialize the output string to the empty string
        String outputStr = "", outputStr2 = "";
        
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
                    System.out.println("Error in switch (category)");
                    break;
            }
            
            // Determine Cost level for game
            if (cost < 40)
                purchaseCostLevel = "Low";
            else if (cost >= 40 && cost < 80)
                purchaseCostLevel = "Medium";
            else if (cost >= 80 && cost < 120)
                purchaseCostLevel = "High";
            else if (cost >= 120)
                purchaseCostLevel = "Very High";
            
            // Add the user-entered values to the output string 
            outputStr = outputStr + game_count + ". Video game title: " + title + ", ";
            outputStr = outputStr + "Category: " + categoryStr + ", ";
            outputStr = outputStr + "Cost: " + prec2.format(cost) + ", ";
            outputStr = outputStr + "Total Cost: " + prec2.format(totalcost) + "\n";
            outputStr = outputStr + "Cost level: " + purchaseCostLevel + "\n";
            
            // Get the user's choice as to whether to continue the loop
            resp = JOptionPane.showConfirmDialog(null, outputStr + "\nContinue?", "Confirm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            // Test whether the user's choice is to continue the loop or not
            if (resp == JOptionPane.NO_OPTION) {
                break;
            }
        }

        //Calculate final costs
        // Determine cost level for all games & discount level for purchase
             if (totalcost < 40)
             {
                totalCostLevel = "Low";
                discountPercent = 0.0;
                Discount = "0%";
             }
            else if ((totalcost >= 40) && (totalcost < 80))
            {
                totalCostLevel = "Medium";
                discountPercent = 0.05;
                Discount = "5%";
            }
            else if ((totalcost >= 80) && (totalcost < 120))
            {
                totalCostLevel = "High";
                discountPercent = 0.10;
                Discount = "10%";
            }
            else if (totalcost >= 120)
            {
                totalCostLevel = "Very High";
                discountPercent = 0.20;
                Discount = "20%";
            }
        
        finalcost = totalcost - (discountPercent * totalcost);
             
        outputStr2 = outputStr2 + "Total cost level: " + totalCostLevel + "\n";
        outputStr2 = outputStr2 + "You will save " + prec2.format((discountPercent * totalcost)) + " on your order total of " + prec2.format(totalcost) + "with discount rate " + Discount + "\n";
        outputStr2 = outputStr2 + "Final cost: " + prec2.format(finalcost) + "\n";
        
        // Display final output to the user
        JOptionPane.showMessageDialog(
                null, outputStr + outputStr2, "Video Game List", JOptionPane.INFORMATION_MESSAGE);

    }
    
}
