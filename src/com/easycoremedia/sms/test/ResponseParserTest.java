package com.easycoremedia.sms.test;


import javax.xml.bind.JAXBException;

import org.junit.Before;
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

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testParseBalace() throws JAXBException {
        ResponseParser rp = new ResponseParser();
        rp.parseBalace(message);
    }

}
