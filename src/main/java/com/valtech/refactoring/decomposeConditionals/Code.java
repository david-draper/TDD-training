package com.valtech.refactoring.decomposeConditionals;
import java.util.Date;
import java.util.Calendar;

public class Code {
    public double calculateEconomy7(Date timeStart, double units)
    {
    	double dayRate = 0.05;
    	double nightRate = 0.03;
    	double standingCharge = 1;

    	double charge;
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(timeStart);

        if ((calendar.get(Calendar.HOUR_OF_DAY) > 20) || (calendar.get(Calendar.HOUR_OF_DAY) < 5))
        {
            charge = (units * nightRate) + standingCharge;
        }
        else
        {
            charge = (units * dayRate) + standingCharge;
        }

        return charge;
    }
}
