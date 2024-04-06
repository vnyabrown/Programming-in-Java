package cs209.lab_5;

import java.text.*;

/**
 *
 * @author Mike
 */
public class Taxpayer {

    //Data members for a taxmember
    private String name;
    private int ssNumber;
    private double grossPay;
    private double taxRate;

    private DecimalFormat fm = new DecimalFormat("$#.00"); // variable to create format for taxpayer values

    // constructor for taxpayer
    public Taxpayer(String n, int ssN, double gp, double trate) {
        name = n;
        ssNumber = ssN;
        grossPay = gp;
        taxRate = trate;
    } // end of Taxpayer constructor

    public String getName() {
        return name;
    } // end of getName

    public String getSSNumber() {
        String ssn_temp = Integer.toString(ssNumber); // convert ssn to string
        return ssn_temp;
    } // end of getssN

    public double getGrossPay() {
        return grossPay;
    } // end of getGrossPay

    public double getTaxRate() {
        return taxRate;
    } // end of getTaxRate

    public double computeTax() {
        return (taxRate * grossPay);
    } // end of computeTax

    public String toString() {
        return "Name: " + name + " ssNumber: " + ssNumber + " Gross Pay: " + fm.format(grossPay) + " Tax Rate: " 
                + fm.format(taxRate)
                + " Calculate Tax: " + fm.format(computeTax());
    }

} // end of Taxpayer class
