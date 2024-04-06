package cs209.lab_6b;

/**
 *
 * @author Mike
 */
public class MonthlyTaxpayer extends Taxpayer{
    
    MonthlyTaxpayer(String n, int ssN, double gp)
    {
        super(n, ssN, gp);
    } // end of constructor
    
    public double computeStateTax()
    {
        double wtax = grossPay; // set initial value for tax calculation
        
        // Calculate tax for monthly payer based on state rates
        if (grossPay >= 0 && grossPay < 667) {
            wtax = (((grossPay - 0) * 0.04) + 0); // update tax
        } else if (grossPay >= 667 && grossPay < 917) {
            wtax = (((grossPay - 667) * 0.0450) + 26.27); // update tax 
        } else if (grossPay >= 917 && grossPay < 1083) {
            wtax = (((grossPay - 917) * 0.0525) + 37.92); // update tax 
        } else if (grossPay >= 1083 && grossPay < 1667) {
            wtax = (((grossPay - 1083) * 0.0590) + 46.67); // update tax 
        } else if (grossPay >= 1667 && grossPay < 7500) {
            wtax = (((grossPay - 1667) * 0.0685) + 81.08); // update tax 
        } else if (grossPay >= 7500 && grossPay < 8333) {
            wtax = (((grossPay - 7500) * 0.0764) + 480.67); // update tax 
        } else if (grossPay >= 8333 && grossPay < 12500) {
            wtax = (((grossPay - 8333) * 0.0814) + 544.33); // update tax 
        } else if (grossPay >= 12500) {
            wtax = (((grossPay - 12500) * 0.0935) + 883.67); // update tax 
        }
        
        return wtax;
        
    } // end of computeStateTax
    
    public double computeFederalTax()
    {
        double fedtax = grossPay - 283.33; // cubtract monthly allowance from grosspay
        
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
    
      public String computeTax()
    {
        return "\n    State Tax for Pay Period: " + fm.format(computeStateTax())
                + "\n    Federal Tax for Pay Period: " + fm.format(computeFederalTax());
    }
    
    public String toString()
    {
        return super.toString();
    } // end of toString
}
