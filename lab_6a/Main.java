package cs209.lab_6a;

import javax.swing.*;
import java.text.*;

public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {
        final int MAX_NUMBER = 5;
        Taxpayer t1 = null;   // Variable to hold an instance of the Taxpayer class
        Taxpayer t2 = null;   // Same as above
        Taxpayer t3 = null;   // Same
        Taxpayer t4 = null;   // Same
        Taxpayer t5 = null;   // Same
       
        
        Taxpayer t = null;
        DecimalFormat prec2 = new DecimalFormat("$#.00");
        DecimalFormat prec1 = new DecimalFormat("#.0%");
        String nameStr = "";   // Holds taxpayer name entered by user
        String ssNumStr = "";  // Holds taxpayer's SSNnumber as string, entered by user
        int ssNum = 0;         // Taxpayer's ssnumber as int
        String taxPayerTypeStr = ""; // Taxpayers taxpayer type entered by user
        char taxPayerType = ' '; // Taxpater's taxpayer type stored as a char
        
        String grossStr = "";  // Taxpayer's gross pay as string, entered by user
        double grossPay = 0.0; // Taxpayer's gross pay as double
               
        int count = 0;         // The number of taxpayers created
        String outputStr = ""; // String for output display to user
        String outputStr2 = "";// String for output display to user
        String msgStr = "";    // Holds message for display to user
        int resp = 0;          // User's response from showConfirmDialog method
        
        while (true) {   // Loop to input data on each taxpayer
            count++;
            
            // Read in name from user as a string
            nameStr = JOptionPane.showInputDialog("Enter taxpayer name");
            
            // Read in ID number from user as a string
            ssNumStr = JOptionPane.showInputDialog("Enter SSN number");
            // Convert from type String to type int
            ssNum = Integer.parseInt(ssNumStr.trim());
            
            taxPayerTypeStr = JOptionPane.showInputDialog("Enter Taxpayer Type - Enter A, B, or C for: "
                    + "\nA. Weekly Taxpayer \nB. Biweekly Taxpayer \nC. Monthly Taxpayer");
            taxPayerType = taxPayerTypeStr.charAt(0); // convert to char
            
            // Read in gross pay from user as a string
            grossStr = JOptionPane.showInputDialog("Enter gross pay");
            // Convert from type String to type double
            grossPay = Double.parseDouble(grossStr.trim());
            
            // Create Taxpayer instance based on payer type
            switch (taxPayerType) {
                case 'A': 
                    t = new WeeklyTaxpayer(nameStr, ssNum, grossPay);
                    break;
                case 'B': 
                    //t = new BiweeklyTaxpayer(nameStr, ssNum, grossPay);
                    break;
                case 'C':
                    //t = new MonthlyTaxpayer(nameStr, ssNum, grossPay);
                    break;
            }
            
            // Assign new Taxpayer object to next available Taxpayer variable
            switch (count) {
                case 1:  t1 = t; break;
                case 2:  t2 = t; break;
                case 3:  t3 = t; break;
                case 4:  t4 = t; break;
                case 5:  t5 = t; break;
               
            }
            outputStr += count + ". " + t.toString() + "\n";
            
            if (count < MAX_NUMBER) {
                msgStr = "\nMax number of allowed taxpayers is: " + MAX_NUMBER + "\nContinue?";
                
                resp = JOptionPane.showConfirmDialog(null, outputStr + msgStr, "Confirm",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.NO_OPTION)
                    break;
            } else {
                msgStr = "Program cannot handle any more additional taxpayers.";
                JOptionPane.showMessageDialog(null, outputStr + msgStr, "Results",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        } // end of while
        
        outputStr2 = "Taxpayer list:\n";
        for (int i = 1; i <= count; i++){
            switch (i) {
                case 1:  t = t1; break;
                case 2:  t = t2; break;
                case 3:  t = t3; break;
                case 4:  t = t4; break;
                case 5:  t = t5; break;
               
            }
            outputStr2 += "\n" + i + ". " + t.getName() +
                    "\n    SSN: " + t.getSSNumber() + 
                    "\n    Gross Pay: " + prec2.format(t.getGrossPay()) +
                    "\n    Taxpayer Type: " + t.getClass().getSimpleName() + 
                    "\n    Tax for Pay Period: " + prec2.format(t.computeTax()) + "\n";
        }
        JOptionPane.showMessageDialog(null, outputStr2, "TAXPAYERS",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

