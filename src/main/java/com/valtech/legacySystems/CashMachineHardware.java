package com.valtech.legacySystems;

public class CashMachineHardware {
    
	
    public boolean cashAvailable(float amount){
        return true;
    }

   
    public void dispenseCash(float amount) throws HardwareFailure{

    	// Do some clever hardware stuff.
    	
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
		}
		throw new HardwareFailure("Hardware not found");
    }


}
