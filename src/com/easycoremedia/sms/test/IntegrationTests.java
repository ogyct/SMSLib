package com.easycoremedia.sms.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.easycoremedia.sms.exception.SMSLibException;
import com.easycoremedia.sms.response.beans.BalanceBean;
import com.easycoremedia.sms.response.beans.GetPriceBean;
import com.easycoremedia.sms.response.beans.SendResponseBean;
import com.easycoremedia.sms.response.beans.StatusBean;
import com.easycoremedia.sms.run.SMSLib;

/**
 * This class contains complete integration tests, which should test the whole procedure at once.
 * NOTE!! Before using this, set up credentials accordingly
 * @author Dmitry
 *
 */
public class IntegrationTests {

    @Test
    public void testBalance() {
        SMSLib smsLib = new SMSLib(Credentials.USERNAME, Credentials.PASSWORD);
        try {
            BalanceBean bb = smsLib.getBalance();
        } catch (SMSLibException e) {
            System.out.println(e.getErrorMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSendMessage() {
        SMSLib smsLib = new SMSLib(Credentials.USERNAME, Credentials.PASSWORD);
        Map<String, String> phones = new HashMap<String, String>();
        phones.put("czechNumber", "+420731634696");
        try {
            SendResponseBean sendBean = smsLib.sendSMS("Dima", "Test message", phones);
        } catch (SMSLibException e) {
            System.out.println(e.getErrorMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//TODO fix this. It may return normal repsonse bean instead of deliveryreport.
    @Test
    public void testRequestStatus() throws Exception {
        SMSLib smsLib = new SMSLib(Credentials.USERNAME, Credentials.PASSWORD);
        try {
            StatusBean sb = smsLib.getStatus("russianNumber");
        } catch (SMSLibException e) {
            System.out.println(e.getErrorMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    @Test
    public void testGetPrice() {
        SMSLib smsLib = new SMSLib(Credentials.USERNAME, Credentials.PASSWORD);
        Map<String, String> phones = new HashMap<String, String>();
        phones.put("russianNumber", "+79193386820");
        try {
            GetPriceBean pb = smsLib.getPrice("Dima", "Test message", phones);
        } catch (SMSLibException e) {
            System.out.println(e.getErrorMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
