package com.valtech.legacySystems;

import java.util.HashMap;

/**
 * Legacy authentication service
 */
public class AuthenticationService {

    HashMap<String, String> bankDatabase;

    public AuthenticationService(){
        bankDatabase = new HashMap<String, String>();
        bankDatabase.put("12345", "1111");
        bankDatabase.put("12344", "1111");  //  broken check sums
    }

    public String authenticate(String card, String pin){
        if (bankDatabase.get(card) == pin){
            return new String("token");
        }
        return null;
    }
}
