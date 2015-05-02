package com.easycoremedia.sms.request;

import java.io.StringWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Class contains methods which build xml requests for certain operations
 * p.s. I wanted to refactor same xml parts, but decided not to do it(lack of time)
 * @author Dmitry
 *
 */
public class RequestBuilder {

    /**
     * Builds get balance xml request
     * @param username
     * @param password
     * @return
     * @throws XMLStreamException
     */
    public String balanceRequest(String username, String password) throws XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        StringWriter result = new StringWriter();

        XMLStreamWriter writer = factory.createXMLStreamWriter(result);

        writer.writeStartDocument("UTF-8", "1.0");
        writer.writeStartElement("SMS");

        writer.writeStartElement("operations");
        writer.writeStartElement("operation");
        writer.writeCharacters("BALANCE");
        writer.writeEndElement();//operation
        writer.writeEndElement();//operations

        writer.writeStartElement("authentification");
        writer.writeStartElement("username");
        writer.writeCharacters(username);
        writer.writeEndElement();//username
        writer.writeStartElement("password");
        writer.writeCharacters(password);
        writer.writeEndElement();//password

        writer.writeEndElement();//auth
        writer.writeEndElement();//SMS

        writer.writeEndDocument();

        writer.flush();
        writer.close();

        return result.toString();
    }

    /**
     * Creates status request xml message. Message id is an id, which got assigned to a message which was sent via sendMessage
     * @param username
     * @param password
     * @param messageId
     * @return
     * @throws XMLStreamException
     */
    public String statusRequest(String username, String password, String messageId) throws XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        StringWriter result = new StringWriter();

        XMLStreamWriter writer = factory.createXMLStreamWriter(result);

        writer.writeStartDocument("UTF-8", "1.0");
        writer.writeStartElement("SMS");

        writer.writeStartElement("operations");
        writer.writeStartElement("operation");
        writer.writeCharacters("GETSTATUS");
        writer.writeEndElement();//operation
        writer.writeEndElement();//operations

        writer.writeStartElement("authentification");
        writer.writeStartElement("username");
        writer.writeCharacters(username);
        writer.writeEndElement();//username
        writer.writeStartElement("password");
        writer.writeCharacters(password);
        writer.writeEndElement();//password
        writer.writeEndElement();//auth

        writer.writeStartElement("statistics");
        writer.writeStartElement("messageid");
        writer.writeCharacters(messageId);
        writer.writeEndElement();//messageid
        writer.writeEndElement();//statistics

        writer.writeEndElement();//SMS

        writer.writeEndDocument();

        writer.flush();
        writer.close();

        return result.toString();
    }

    /**
     * Creates xml to send the same SMS to one or more numbers
     * @param username
     * @param password
     * @param sender
     * @param text
     * @param phones
     * @return
     * @throws XMLStreamException
     */
    public String sendMessage(String username, String password, String sender, String text, Map<String, String> phones) throws XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        StringWriter result = new StringWriter();
        XMLStreamWriter writer = factory.createXMLStreamWriter(result);

        writer.writeStartDocument("UTF-8", "1.0");
        writer.writeStartElement("SMS");

        writer.writeStartElement("operations");
        writer.writeStartElement("operation");
        writer.writeCharacters("SEND");
        writer.writeEndElement();//operation
        writer.writeEndElement();//operations

        writer.writeStartElement("authentification");
        writer.writeStartElement("username");
        writer.writeCharacters(username);
        writer.writeEndElement();//username
        writer.writeStartElement("password");
        writer.writeCharacters(password);
        writer.writeEndElement();//password
        writer.writeEndElement();//auth

        writer.writeStartElement("message");
        writer.writeStartElement("sender");
        writer.writeCharacters(sender);
        writer.writeEndElement();//sender
        writer.writeStartElement("text");
        writer.writeCharacters(text);
        writer.writeEndElement();//text
        writer.writeEndElement();//message

        //Adding phone numbers from Map object
        writer.writeStartElement("numbers");
        for (Entry<String, String> entry : phones.entrySet()) {
            writer.writeStartElement("number");
            writer.writeAttribute("messageID", entry.getKey());
            writer.writeCharacters(entry.getValue());
            writer.writeEndElement();//number
        }
        writer.writeEndElement();//numbers
        
        writer.writeEndElement();//SMS

        writer.writeEndDocument();

        writer.flush();
        writer.close();

        return result.toString();
    }
    
    /**
     * Creates xml to check how much transaction will cost
     * @param username
     * @param password
     * @param sender
     * @param text
     * @param phones
     * @return
     * @throws XMLStreamException
     */
    public String priceRequest(String username, String password, String sender, String text, Map<String, String> phones) throws XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        StringWriter result = new StringWriter();
        XMLStreamWriter writer = factory.createXMLStreamWriter(result);

        writer.writeStartDocument("UTF-8", "1.0");
        writer.writeStartElement("SMS");

        writer.writeStartElement("operations");
        writer.writeStartElement("operation");
        writer.writeCharacters("GETPRICE");
        writer.writeEndElement();//operation
        writer.writeEndElement();//operations

        writer.writeStartElement("authentification");
        writer.writeStartElement("username");
        writer.writeCharacters(username);
        writer.writeEndElement();//username
        writer.writeStartElement("password");
        writer.writeCharacters(password);
        writer.writeEndElement();//password
        writer.writeEndElement();//auth

        writer.writeStartElement("message");
        writer.writeStartElement("sender");
        writer.writeCharacters(sender);
        writer.writeEndElement();//sender
        writer.writeStartElement("text");
        writer.writeCharacters(text);
        writer.writeEndElement();//text
        writer.writeEndElement();//message

        //Adding phone numbers from Map object
        writer.writeStartElement("numbers");
        for (Entry<String, String> entry : phones.entrySet()) {
            writer.writeStartElement("number");
            writer.writeAttribute("messageID", entry.getKey());
            writer.writeCharacters(entry.getValue());
            writer.writeEndElement();//number
        }
        writer.writeEndElement();//numbers
        
        writer.writeEndElement();//SMS

        writer.writeEndDocument();

        writer.flush();
        writer.close();

        return result.toString();
    }

}