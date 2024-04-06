/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs209.lab_6a;
import java.text.*;


/**
 *
 * @author Mike
 */
public class WeeklyTaxpayer extends Taxpayer {
   
    private DecimalFormat fm = new DecimalFormat("$#.00"); // variable to create format for taxpayer values

    WeeklyTaxpayer(String n, int ssN, double gp)
    {
        super(n, ssN, gp); // invoke parent constructor
    } // end of constructor for WeeklyTaxpayer
    
    public double computeStateTax()
    {
        double wtax = grossPay;
        
        // Calculate tax for weekly payer based on state rates
        if (grossPay >= 0 && grossPay < 154) {
            wtax = (((grossPay - 0) * 0.04) + 0); // update tax
        } else if (grossPay >= 154 && grossPay < 212) {
            wtax = (((grossPay - 154) * 0.0450) + 6.15); // update tax 
        } else if (grossPay >= 212 && grossPay < 250) {
            wtax = (((grossPay - 212) * 0.0525) + 8.75); // update tax 
        } else if (grossPay >= 250 && grossPay < 385) {
            wtax = (((grossPay - 250) * 0.0590) + 10.77); // update tax 
        } else if (grossPay >= 385 && grossPay < 1731) {
            wtax = (((grossPay - 385) * 0.0685) + 18.71); // update tax 
        } else if (grossPay >= 1731 && grossPay < 1923) {
            wtax = (((grossPay - 1731) * 0.0764) + 110.92); // update tax 
        } else if (grossPay >= 1923 && grossPay < 2885) {
            wtax = (((grossPay - 1923) * 0.0814) + 125.62); // update tax 
        } else if (grossPay >= 2885) {
            wtax = (((grossPay - 2885) * 0.0935) + 203.92); // update tax 
        }
        
        return wtax; // return tax to caller
    } // end of computeStateTax
    
    public double computeFederalTax ()
    {
       double fedtax = grossPay - 65.38; 
       
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
    
    public String toString()
    {
        return super.toString() + " State Tax: " + fm.format(computeStateTax()) + 
                " Federal Tax: " + fm.format(computeFederalTax());
    } // end of toString
}
