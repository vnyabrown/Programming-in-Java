package cs209.lab_3b;

import javax.swing.*;
import java.text.*; // import package for formatting

public class BasicMethodsLab2 {

    public static void main(String[] args) {

        String grossPayStr;     // Value entered by user; string type
        String taxRateStr;      // Value entered by user; string type
        String taxpayerStr;     // Taxpayer type, entered by user;
        char taxpayerType;      // Taxpayer type, stored as char
        double grossPay;        // The double form of the user-entered gross pay
        double taxRate = 0;     // The double form of the user-entered tax rate
        double statetax = 0, fedtax = 0;         // The tax for the pay period
        int resp = 0;           // The user's response as to whether to continue
        int count = 0;          // Keep track number of taxpayers
        DecimalFormat rates = new DecimalFormat("$#.00");

        // Initialize the output string to the empty string
        String outputStr = "";

        while (true) {
            ++count; // set taxpayer number

            // Read in gross pay from user as a string
            grossPayStr = JOptionPane.showInputDialog("Enter gross pay for the pay period");

            // Convert from type String to type double
            grossPay = Double.parseDouble(grossPayStr);

//            // Read in tax rate from user as a string
//            taxRateStr = JOptionPane.showInputDialog("Enter tax rate as a percent");
//
//            // Convert from type String to type double
//            taxRate = Double.parseDouble(taxRateStr);

            // Get tax payer type from user as string
            taxpayerStr = JOptionPane.showInputDialog("Enter taxpayer type (Enter A, B, or C) \n A: Weekly \n B: Bi-Weekly \n C: Monthly");
            taxpayerType = taxpayerStr.charAt(0); // convert to char

            // Calculate tax for the pay period
            statetax = calculateTax(grossPay, taxpayerType); // updated method call for calculateTax
            fedtax = computeFederalTax(grossPay, taxpayerType); // call to compute federal tax

            /*Print data for display*/
            // Print pay rates
            outputStr = outputStr + "\n" + "Taxpayer #" + count + "\n";
            outputStr = outputStr + "Gross pay: " + rates.format(grossPay) + ", ";
            // Print tax payer type
            outputStr = outputStr + "Pay Type: " + getTaxpayerTypeName(taxpayerType);
            // Print the tax and net pay
            outputStr = outputStr + ", " + "State Tax: " + rates.format(statetax) + " Federal tax: " + rates.format(fedtax) + "\n";
            outputStr = outputStr + "Net pay: " + rates.format(calculateNetPay(grossPay, statetax, fedtax)) + "\n";

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

    // method to calculate tax from grosspay, taxrate, and tax payer type, modified for Lab 3B
    public static double calculateTax(double pay, char paytype) {

        switch (paytype) {
            case 'A': // Weekly tax payer, so calculate weekly tax
                return computeWeeklyTax(pay); // return value from computing weekly tax
            case 'B': // Bi-weekly tax payer, so calculate bi-weekly tax
                return computeBiweeklyTax(pay); // return value from computing biweekly tax
            case 'C': // Monthly tax payer, so calculate monthly tax
                return computeMonthlyTax(pay); // return value from computing monthly tax
            default:
                return pay;
        }
    } // end of calculateTax

    // Method to calculate net pay from gross pay and tax amount 
    public static double calculateNetPay(double pay, double statetax, double fedtax) {
        double netPay = (pay - statetax - fedtax); // calculate net pay by subtracting all taxes
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
                taxpayer ="Error";
        }
        return taxpayer; // return tax payer type as string as return value
    } // end of getTaxpayerTypeName

    public static double computeWeeklyTax(double pay) {
        double wtax = pay; // net wages added to weekly tax temporarily

        // Calculate tax for weekly payer based on state rates
        if (pay >= 0 && pay < 154) {
            wtax = (((pay - 0) * 0.04) + 0); // update tax
        } else if (pay >= 154 && pay < 212) {
            wtax = (((pay - 154) * 0.0450) + 6.15); // update tax 
        } else if (pay >= 212 && pay < 250) {
            wtax = (((pay - 212) * 0.0525) + 8.75); // update tax 
        } else if (pay >= 250 && pay < 385) {
            wtax = (((pay - 250) * 0.0590) + 10.77); // update tax 
        } else if (pay >= 385 && pay < 1731) {
            wtax = (((pay - 385) * 0.0685) + 18.71); // update tax 
        } else if (pay >= 1731 && pay < 1923) {
            wtax = (((pay - 1731) * 0.0764) + 110.92); // update tax 
        } else if (pay >= 1923 && pay < 2885) {
            wtax = (((pay - 1923) * 0.0814) + 125.62); // update tax 
        } else if (pay >= 2885) {
            wtax = (((pay - 2885) * 0.0935) + 203.92); // update tax 
        }
        return wtax; // return tax to caller
    } // end of computerWeeklyTax

    public static double computeBiweeklyTax(double pay) {
        double bwtax = pay; // net wages added to biweekly tax temporarily

        // calculate tax given these conditions
        if (pay >= 0 && pay < 308) {
            bwtax = (((pay - 0) * 0.04) + 0); // update tax
        } else if (pay >= 308 && pay < 423) {
            bwtax = (((pay - 308) * 0.0450) + 12.31); // update tax 
        } else if (pay >= 423 && pay < 500) {
            bwtax = (((pay - 423) * 0.0525) + 17.50); // update tax 
        } else if (pay >= 500 && pay < 769) {
            bwtax = (((pay - 500) * 0.0590) + 21.54); // update tax 
        } else if (pay >= 769 && pay < 3462) {
            bwtax = (((pay - 769) * 0.0685) + 37.42); // update tax 
        } else if (pay >= 3462 && pay < 3846) {
            bwtax = (((pay - 3462) * 0.0764) + 221.85); // update tax 
        } else if (pay >= 3846 && pay < 5769) {
            bwtax = (((pay - 3846) * 0.0814) + 251.23); // update tax 
        } else if (pay >= 5769) {
            bwtax = (((pay - 5769) * 0.0935) + 407.85); // update tax 
        }
        return bwtax; // return tax to caller

    } // end of computeBiweeklyTax

    public static double computeMonthlyTax(double pay) {
        double mtax = pay; // net wages added to monthly tax temporarily

        // calculate tax given these conditions
        if (pay >= 0 && pay < 667) {
            mtax = (((pay - 0) * 0.04) + 0); // update tax
        } else if (pay >= 667 && pay < 917) {
            mtax = (((pay - 667) * 0.0450) + 26.27); // update tax 
        } else if (pay >= 917 && pay < 1083) {
            mtax = (((pay - 917) * 0.0525) + 37.92); // update tax 
        } else if (pay >= 1083 && pay < 1667) {
            mtax = (((pay - 1083) * 0.0590) + 46.67); // update tax 
        } else if (pay >= 1667 && pay < 7500) {
            mtax = (((pay - 1667) * 0.0685) + 81.08); // update tax 
        } else if (pay >= 7500 && pay < 8333) {
            mtax = (((pay - 7500) * 0.0764) + 480.67); // update tax 
        } else if (pay >= 8333 && pay < 12500) {
            mtax = (((pay - 8333) * 0.0814) + 544.33); // update tax 
        } else if (pay >= 12500) {
            mtax = (((pay - 12500) * 0.0935) + 883.67); // update tax 
        }
        return mtax;

    } // end of computeMonthlyTax

    public static double computeFederalTax(double pay, char payertype) {
        double fedtax = 0.00;

        // find allowance to subtract from wages
        switch (payertype) {
            case 'A': // weekly allowance to withhold
                fedtax = (pay -= 65.38);
                break;
            case 'B': // biweekly allowance to withhold
                fedtax = (pay -= 130.77);
                break;
            case 'C': // monthly allowance to withhold
                fedtax = (pay -= 283.33);
                break;
            default:
                fedtax = pay;
                break;
        } // end of payertype switch

        // calculate federal tax by state rates and wage amount
        if (fedtax > 0 && fedtax < 51) // calculate tax for these conditions
        {
            fedtax -= 0;
            fedtax = ((fedtax * 0) + 0);
        } else if (fedtax > 51 && fedtax < 195) // calculate tax for these conditions
        {
            fedtax -= 51;
            fedtax = ((fedtax * 0.10) + 0);
        } else if (fedtax > 195 && fedtax < 645) // calculate tax for these conditions
        {
            fedtax -= 195;
            fedtax = ((fedtax * 0.15) + 14.40);
        } else if (fedtax > 645 && fedtax < 1482) // calculate tax for these conditions
        {
            fedtax -= 645;
            fedtax = ((fedtax * 0.25) + 81.90);
        } else if (fedtax > 1482 && fedtax < 3131) // calculate tax for these conditions
        {
            fedtax -= 1482;
            fedtax = ((fedtax * 0.28) + 291.15);
        } else if (fedtax > 3131 && fedtax < 6763) // calculate tax for these conditions
        {
            fedtax -= 3131;
            fedtax = ((fedtax * 0.33) + 752.87);
        } else if (fedtax > 6763) // calculate tax for these conditions
        {
            fedtax -= 6763;
            fedtax = ((fedtax * 0.35) + 1951.43);
        }

        return fedtax; // return calculated tax
    } // end of computeFederalTax

} // end of BasicMethodsLab2
