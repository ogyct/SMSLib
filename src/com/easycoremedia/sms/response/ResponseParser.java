package com.easycoremedia.sms.response;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.easycoremedia.sms.response.beans.BalanceBean;
import com.easycoremedia.sms.response.beans.GetPriceBean;
import com.easycoremedia.sms.response.beans.SendResponseBean;
import com.easycoremedia.sms.response.beans.StatusBean;

/**
 * Class parses response xml from server and returns values in Java objects
 * @author Dmitry
 *
 */

public class ResponseParser {

    /**
     * Parses get balance message and puts it to java bean
     * @param xml
     * @throws JAXBException
     */
    public BalanceBean parseBalace(String xml) throws JAXBException {
        StringReader reader = new StringReader(xml);
        JAXBContext jaxbContext = JAXBContext.newInstance(BalanceBean.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        BalanceBean balanceBean = (BalanceBean) jaxbUnmarshaller.unmarshal(reader);
        return balanceBean;
    }

    /**
     * Parses deliveryreport message and puts it to java bean
     * @param xml
     * @throws JAXBException
     */
    public StatusBean StatusBean(String xml) throws JAXBException {
        StringReader reader = new StringReader(xml);
        JAXBContext jaxbContext = JAXBContext.newInstance(StatusBean.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        StatusBean statusBean = (StatusBean) jaxbUnmarshaller.unmarshal(reader);
        return statusBean;
    }

    /**
     * Parses send response and stores it to java bean
     * @param xml
     * @throws JAXBException
     */
    public SendResponseBean parseSendResonse(String xml) throws JAXBException {
        StringReader reader = new StringReader(xml);
        JAXBContext jaxbContext = JAXBContext.newInstance(SendResponseBean.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        SendResponseBean sendBean = (SendResponseBean) jaxbUnmarshaller.unmarshal(reader);
        return sendBean;

    }

    /**
     * Parses getPrice response and stores it to java bean
     * @param xml
     * @throws JAXBException
     */
    public GetPriceBean parseGetPriceResponse(String xml) throws JAXBException {
        StringReader reader = new StringReader(xml);
        JAXBContext jaxbContext = JAXBContext.newInstance(GetPriceBean.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        GetPriceBean getPriceBean = (GetPriceBean) jaxbUnmarshaller.unmarshal(reader);
        return getPriceBean;

    }

}
