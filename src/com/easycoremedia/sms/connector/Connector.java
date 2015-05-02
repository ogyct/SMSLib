package com.easycoremedia.sms.connector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * This class creates https connection with atompark server
 * @author Dmitry
 *
 */
public class Connector {

    private static final String URL = "https://my.atompark.com/sms/xml.php";

    /**
     * Method creates a connection and sends request to Atompark.
     * Returns server xml response
     * @param xml message with request
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public String sendRequest(String xml) throws ClientProtocolException, IOException {
        String response = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost(URL);

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);

            //pass XML request
            nameValuePairs.add(new BasicNameValuePair("XML", xml));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(nameValuePairs);

            httpPost.setEntity(uefe);

            System.out.println("Executing request " + httpPost.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = handleResponse();
            response = httpClient.execute(httpPost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(response);
        } finally {
            httpClient.close();
        }
        return response;

    }

    /**
     * Creates response handler object to check response status.
     * @return
     */
    private ResponseHandler<String> handleResponse() {
        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            @Override
            public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }
        };
        return responseHandler;
    }

}
