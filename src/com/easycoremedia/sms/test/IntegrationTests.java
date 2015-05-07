package com.easycoremedia.sms.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.easycoremedia.sms.run.CallStatus;
import com.easycoremedia.sms.run.Result;
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
        Result res = smsLib.getBalance();
        assertEquals(CallStatus.AUTH_FAILED, res.getStatus());
        assertEquals("-1", res.getBean().getStatus());
    }

    @Test
    public void testBalanceException() {
        SMSLib smsLib = new SMSLib(Credentials.USERNAME, Credentials.PASSWORD);
        Result res = smsLib.getBalance();
        assertNotNull(res.getEx());
    }

    @Test
    public void testSendMessage() {
        SMSLib smsLib = new SMSLib(Credentials.USERNAME, Credentials.PASSWORD);
        Map<String, String> phones = new HashMap<String, String>();
        phones.put("czechNumber", "+420731634696");
        Result res = smsLib.sendSMS("", "", phones);
        assertEquals(CallStatus.AUTH_FAILED, res.getStatus());
    }

    @Test
    public void testSendMessageException() {
        SMSLib smsLib = new SMSLib(Credentials.USERNAME, Credentials.PASSWORD);
        Map<String, String> phones = new HashMap<String, String>();
        phones.put("czechNumber", "+420731634696");
        Result res = smsLib.sendSMS("", "", phones);
        assertNotNull(res.getEx());
    }

    ////TODO fix this. It may return normal repsonse bean instead of deliveryreport.
    //    @Test
    //    public void testRequestStatus() throws Exception {
    //        SMSLib smsLib = new SMSLib(Credentials.USERNAME, Credentials.PASSWORD);
    //        try {
    //            StatusBean sb = smsLib.getStatus("russianNumber");
    //        } catch (SMSLibException e) {
    //            System.out.println(e.getErrorMessage());
    //            e.printStackTrace();
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //            throw new Exception(e);
    //        }
    //    }
    //
    @Test
    public void testGetPrice() {
        SMSLib smsLib = new SMSLib(Credentials.USERNAME, Credentials.PASSWORD);
        Map<String, String> phones = new HashMap<String, String>();
        phones.put("russianNumber", "+79193386820");
        Result res = smsLib.getPrice("", "", phones);
        assertEquals(CallStatus.AUTH_FAILED, res.getStatus());

    }

    @Test
    public void testGetPriceException() {
        SMSLib smsLib = new SMSLib(Credentials.USERNAME, Credentials.PASSWORD);
        Map<String, String> phones = new HashMap<String, String>();
        phones.put("russianNumber", "+79193386820");
        Result res = smsLib.getPrice("", "", phones);
        assertNotNull(res.getEx());

    }
}
