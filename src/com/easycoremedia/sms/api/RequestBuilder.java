package com.easycoremedia.sms.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {

	String URL;

	public RequestBuilder(String URL) {
		this.URL = URL;
	}

	public String doXMLQuery(String xml) {
		StringBuilder responseString = new StringBuilder();

		Map<String, String> params = new HashMap<String, String>();
		params.put("XML", xml);
		try {
			Connector.sendPostRequest(this.URL, params);
			String[] response = Connector.readMultipleLinesRespone();
			for (String line : response) {
				responseString.append(line);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		Connector.disconnect();
		return responseString.toString();
	}
}