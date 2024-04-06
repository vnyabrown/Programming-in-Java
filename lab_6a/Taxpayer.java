package cs209.lab_6a;

import java.text.*;

/**
 *
 * @author Mike
 */
public class Taxpayer {

    //Data members for a taxmember
    protected String name;
    protected int ssNumber;
    protected double grossPay;

    private DecimalFormat fm = new DecimalFormat("$#.00"); // variable to create format for taxpayer values

    // constructor for taxpayer
    public Taxpayer(String n, int ssN, double gp) {
        name = n;
        ssNumber = ssN;
        grossPay = gp;
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

    public double computeTax() {
        return 0.0;
    } // end of computeTax

    public String toString() {
        return "Name: " + name + " ssNumber: " + ssNumber + " Gross Pay: " + fm.format(grossPay) + 
                " Taxpayer Type: " + this. getClass().getSimpleName() + " Calculate Tax: " + fm.format(computeTax());
    }

} // end of Taxpayer class
