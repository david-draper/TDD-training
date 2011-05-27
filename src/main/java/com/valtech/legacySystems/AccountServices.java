package com.valtech.legacySystems;

public class AccountServices {

    public static AccountServices instance(){
    	
    	return singleton;
    }
	
	public float balance(String token) throws AccountingException{
    	throw new AccountingException("Accounts system not available");
    }
    
    public int reserveForWithdraw( String token, float amount) throws AccountingException{
    	throw new AccountingException("Accounts system not available");
    }

    public boolean withdraw( String token, float amount, int correlationId) throws AccountingException{
    	throw new AccountingException("Accounts system not available");

    }
    
    private static final AccountServices singleton = new AccountServices();

    private AccountServices(){};
}
