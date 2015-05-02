package com.easycoremedia.sms.response;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Class parses response xml from server and returns values in Java objects
 * @author Dmitry
 *
 */

public class ResponseParser {
    
    public void parseBalace(String xml) throws JAXBException {
        StringReader reader = new StringReader(xml);
        JAXBContext jaxbContext = JAXBContext.newInstance(BalanceBean.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        BalanceBean balanceBean = (BalanceBean) jaxbUnmarshaller.unmarshal(reader);
        System.out.println(balanceBean);
                
    }
    

}
