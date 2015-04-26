package com.easycoremedia.sms.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.easycoremedia.sms.api.API;
import com.easycoremedia.sms.api.Phones;
import com.easycoremedia.sms.api.RequestBuilder;

public class Test {
    public static void main(String[] args) {
        String URL = "https://my.atompark.com/sms/xml.php";
        String login = "o.stahurlova@ub-d.com.ua";
        String password = "3CPQraax";

        RequestBuilder Request = new RequestBuilder(URL);
        API ApiSms = new API(Request, login, password);

        //GET STATUS *************************************************************
        //System.out.println(ApiSms.getStatus("myId"));
        /*
         * response: <?xml version="1.0" encoding="UTF-8"?>
         * <deliveryreport><message id="1299" sentdate="0000-00-00 00:00:00" donedate="0000-00-00 00:00:00" status="0" /></deliveryreport>
        */

        //GET PRICE *************************************************************
//        Map<String, String> phones = new HashMap<String, String>();
//        phones.put("id1", "+420731634696");
        //phones.put("id2", "+38093101****");
        //System.out.print(ApiSms.getPrice("Test sms", phones));
        /*
         * response: <?xml version="1.0" encoding="UTF-8"?><RESPONSE><status>0</status><credits>0.682</credits></RESPONSE>
        */

        //GET BALANCE *************************************************************
        //System.out.println(ApiSms.getBalance());
        /*
         * response: <?xml version="1.0" encoding="UTF-8"?><RESPONSE><status>0</status><credits>780.64</credits></RESPONSE>
        */

        //SEND PHONE *************************************************************
        ArrayList<Phones> phoneSend = new ArrayList<Phones>();
        //myId - test message id, real - real message id
        phoneSend.add(new Phones("real", "", "+420731634696"));
        //phoneSend.add(new Phones("id2", "", "+38093101****"));

        System.out.print(ApiSms.sendSms("UKRBUD", "test sms real", phoneSend));
        /*
         * response: <?xml version="1.0" encoding="UTF-8"?><RESPONSE><status>2</status><credits>0.682</credits></RESPONSE>
        */
        
        //+79022284296 number from russia
        //
    }
}