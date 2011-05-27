package com.valtech.cashMachine;

import com.valtech.legacySystems.AccountingException;
import com.valtech.legacySystems.AuthenticationService;
import com.valtech.legacySystems.AccountServices;
import com.valtech.legacySystems.CashMachineHardware;
import com.valtech.legacySystems.HardwareFailure;


public class Engine {
	private AuthenticationService authentication = new AuthenticationService();
	private CashMachineHardware cashMachine;

    String token;

    public Engine(CashMachineHardware theCashMachine){
    	this.cashMachine = theCashMachine;
    }
    
    boolean authorise(String cardNo, String pin){

        // Check sum the card number (prevents trying to authenticate none bank cards).
        int check = 0;
        for (int i = 0; i < cardNo.length(); ++i){

            check += Character.getNumericValue(cardNo.charAt(i));
        }

        if (check != 15) return false;

        // Authenticate with legacy service.
        token = authentication.authenticate(cardNo, pin);
        return token != null;
    };


    void ejectCard(){
        token = null;
    }

    boolean withdrawCash(float amount){
    	int correlationID;

        try{
        	float balance = AccountServices.instance().balance(token);

        	if (balance < amount)return false;

            correlationID = AccountServices.instance().reserveForWithdraw(token, amount);
        }
        catch(AccountingException e){
            return false;
        }

        if (!cashMachine.cashAvailable(amount)){
            return false;
        }

        try {
            cashMachine.dispenseCash(amount);
        }
        catch (HardwareFailure hardwareFailure) {
            return false;
        }

        try {
        	AccountServices.instance().withdraw(token, amount, correlationID);
        } catch (AccountingException e) {
            return false;
        }

        // All OK.
        return true;
    }



}
