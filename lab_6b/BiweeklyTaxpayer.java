package cs209.lab_6b;

/**
 *
 * @author Mike
 */
public class BiweeklyTaxpayer extends Taxpayer{
    
    BiweeklyTaxpayer(String n, int ssN, double gp)
    {
        super(n, ssN, gp);
    } // end of constructor
    
    public double computeStateTax()
    {
        double wtax = grossPay; // set initial value for tax calculation
        
        // Calculate tax for bi-weekly payer based on state rates
        if (grossPay >= 0 && grossPay < 308) {
            wtax = (((grossPay - 0) * 0.04) + 0); // update tax
        } else if (grossPay >= 308 && grossPay < 423) {
            wtax = (((grossPay - 308) * 0.0450) + 12.31); // update tax 
        } else if (grossPay >= 423 && grossPay < 500) {
            wtax = (((grossPay - 423) * 0.0525) + 17.50); // update tax 
        } else if (grossPay >= 500 && grossPay < 769) {
            wtax = (((grossPay - 500) * 0.0590) + 21.54); // update tax 
        } else if (grossPay >= 769 && grossPay < 3462) {
            wtax = (((grossPay - 769) * 0.0685) + 37.42); // update tax 
        } else if (grossPay >= 3462 && grossPay < 3846) {
            wtax = (((grossPay - 3462) * 0.0764) + 221.85); // update tax 
        } else if (grossPay >= 3846 && grossPay < 5769) {
            wtax = (((grossPay - 3846) * 0.0814) + 251.23); // update tax 
        } else if (grossPay >= 5769) {
            wtax = (((grossPay - 5769) * 0.0935) + 407.85); // update tax 
        } // end of if else
        
        return wtax; // return calculated state tax
    } // end of computeStateTax
    
    public double computeFederalTax()
    {
        double fedtax = grossPay - 130.77; // subtract biweekly allowance from grosspay
        
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
