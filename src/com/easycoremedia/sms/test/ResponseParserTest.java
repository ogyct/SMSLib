package com.easycoremedia.sms.test;


import javax.xml.bind.JAXBException;

import org.junit.Test;

import com.easycoremedia.sms.response.ResponseParser;

public class ResponseParserTest {
    String message = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
            "<RESPONSE>\r\n" + 
            "    <status>0</status>\r\n" + 
            "    <credits>195</credits>\r\n" + 
            "    <amount>79.82</amount>\r\n" + 
            "    <currency>UAH</currency>\r\n" + 
            "</RESPONSE>";
    
    String messageStatus = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
            "<deliveryreport>\r\n" + 
            "    <message id=\"id1\" sentdate=\"0000-00-00 00:00:00\" donedate=\"0000-00-00 00:00:00\"\r\n" + 
            "        status=\"0\" />\r\n" + 
            "    <message id=\"id1\" sentdate=\"0000-00-00 00:00:00\" donedate=\"0000-00-00 00:00:00\"\r\n" + 
            "        status=\"0\" />\r\n" + 
            "    <message id=\"id1\" sentdate=\"0000-00-00 00:00:00\" donedate=\"0000-00-00 00:00:00\"\r\n" + 
            "        status=\"0\" />\r\n" + 
            "</deliveryreport>";
    
    String messageSend = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
            "<RESPONSE>\r\n" + 
            "<status>1</status>\r\n" + 
            "<credits>0.2235</credits>\r\n" + 
            "<amount>0.0916</amount>\r\n" + 
            "<currency>UAH</currency>\r\n" + 
            "</RESPONSE>";

    @Test
    public void testParseBalace() throws JAXBException {
        ResponseParser rp = new ResponseParser();
        rp.parseBalace(message);
    }

    @Test
    public void testGetStatus() throws JAXBException {
        ResponseParser rp = new ResponseParser();
        rp.StatusBean(messageStatus);
    }

    @Test
    public void testSendSms() throws JAXBException {
        ResponseParser rp = new ResponseParser();
        rp.parseSendResonse(messageSend);
    }

}
