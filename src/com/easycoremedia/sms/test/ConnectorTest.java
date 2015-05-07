package com.easycoremedia.sms.test;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import com.easycoremedia.sms.connector.Connector;

/**
 * The purpose of this is only to test connection, whether it can be established and if response is a proper HTTP response.
 * @author avgustisd
 *
 */
public class ConnectorTest {
    String message = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
            "<SMS>\r\n" + 
            "    <operations>\r\n" + 
            "        <operation>BALANCE</operation>\r\n" + 
            "    </operations>\r\n" + 
            "    <authentification>\r\n" + 
            "        <username></username>\r\n" + 
            "        <password></password>\r\n" + 
            "    </authentification>\r\n" + 
            "</SMS>";

    @Test
    public void testConnector() throws ClientProtocolException, IOException {
        Connector c = new Connector();
        c.sendRequest(message);
    }

}
