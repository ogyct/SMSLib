package com.easycoremedia.sms.run;

import com.easycoremedia.sms.response.beans.BalanceBean;

/**
 * Initial class that allows user to use the library
 * @author Dmitry
 *
 */
public class SMSLib {
    
    private final String userName;
    private final String password;
    
    
    public SMSLib(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }
    
    public BalanceBean getBalance() {
        
        return null;
        
    }
    
    
}
