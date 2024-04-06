package cs209.lab03a;

import javax.swing.*;
import java.text.*; // import package for formatting

public class BasicMethodsLab {

    public static void main(String args[]) {

        String grossPayStr;     // Gross pay entered by user as a string
        String taxRateStr;      // Tax rate entered by user as a string
        String taxpayerStr;     // Taxpayer type, entered by user as a string;
        char taxpayerType;      // Taxpayer type, stored as char from value entered by user
        double grossPay;        // The double form of the user-entered gross pay
        double taxRate = 0;     // The double form of the user-entered tax rate
        double tax = 0;         // The tax for the pay period
        int resp = 0;           // The user's response as to whether to continue
        int count = 0;          // Keep track number of taxpayers
        DecimalFormat rates = new DecimalFormat("$#.00"); // set decimal formatting for money/double values

        // Initialize the output string to the empty string
        String outputStr = "";

        while (true) {
            ++count; // set taxpayer number

            // Read in gross pay from user as a string
            grossPayStr = JOptionPane.showInputDialog("Enter gross pay for the pay period");

            // Convert from type String to type double
            grossPay = Double.parseDouble(grossPayStr);

            // Read in tax rate from user as a string
            taxRateStr = JOptionPane.showInputDialog("Enter tax rate as a percent");

            // Convert from type String to type double
            taxRate = Double.parseDouble(taxRateStr);

            // Get tax payer type from user as string
            taxpayerStr = JOptionPane.showInputDialog("Enter taxpayer type (Enter A, B, or C) \n A: Weekly \n B: Bi-Weekly \n C: Monthly");
            taxpayerType = taxpayerStr.charAt(0); // convert to char

            // Calculate tax for the pay period
            tax = calculateTax(grossPay, taxRate, taxpayerType);

            /*Print data for display*/
            // Print pay rates
            outputStr = outputStr + "\n" + "Taxpayer #" + count + "\n";
            outputStr = outputStr + "Gross pay: " + rates.format(grossPay) + ", ";
            outputStr = outputStr + "Tax rate: " + taxRate + "%, ";
            // Print tax payer type
            outputStr = outputStr + "Pay Type: " + getTaxpayerTypeName(taxpayerType);
            // Print the tax and net pay
            outputStr = outputStr + ", " + "Tax: " + rates.format(tax) + "\n";
            outputStr = outputStr + "Net pay: " + rates.format(calculateNetPay(grossPay, tax)) + "\n";

            // Determine whether the user wants to continue the loop
            resp = JOptionPane.showConfirmDialog(null, outputStr + "\nContinue?", "Confirm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (resp == JOptionPane.NO_OPTION) {
                break;
            }
        }

        // Display final output to the user
        JOptionPane.showMessageDialog(
                null, outputStr, "Final Results", JOptionPane.INFORMATION_MESSAGE);

    } // end of main 

    // method to calculate tax from grosspay, taxrate, and tax payer type
    public static double calculateTax(double pay, double rate, char paytype) {
        double getTax = pay * (rate / 100.0); // calculate tax from pay and tax rate
        return getTax; // return tax as return value 
    } // end of calculateTax

    // Method to calculate net pay from gross pay and tax amount 
    public static double calculateNetPay(double pay, double tax) {
        double netPay = (pay - tax); // calculate net pay
        return netPay; // return net pay as return value
    } // end of calculateNetPay

    // Method to define tax payer type given char code by user
    public static String getTaxpayerTypeName(char payertype) {
        String taxpayer = "";
        switch (payertype) {
            case 'A':
                taxpayer = "Weekly";
                break;
            case 'B':
                taxpayer = "Bi-Weekly";
                break;
            case 'C':
                taxpayer = "Monthly";
                break;
            default:
        }
        return taxpayer; // return tax payer type as string as return value
    } // end of getTaxpayerTypeName
}
