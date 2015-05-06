package com.easycoremedia.sms.test;


import java.util.Map;

/**
 * XML generator from atompark for testing.
 * @author avgustisd
 *
 */
public class AtomparkBuilder {
    
    public String getStatus(String msgId){
        String request="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        request=request.concat("<SMS><operations><operation>GETSTATUS</operation></operations>");
        request=request.concat("<authentification>");
        request=request.concat("<username>"+"</username>");
        request=request.concat("<password>"+"</password>");
        request=request.concat("</authentification>");
        request=request.concat("<statistics>");
        request=request.concat("<messageid>"+"</messageid>");
        request=request.concat("</statistics>");
        request=request.concat("</SMS>");
        return request;
    }
    
    public String getPrice(String text, Map<String, String>  phones){
        String request="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        request=request.concat("<SMS>");
        request=request.concat("<operations>");
        request=request.concat("<operation>GETPRICE</operation>");
        request=request.concat("</operations>");
        request=request.concat("<authentification>");
        request=request.concat("<username>"+"</username>");
        request=request.concat("<password>"+"</password>");
        request=request.concat("</authentification>");
        request=request.concat("<message>");
        request=request.concat("<sender></sender>");
        request=request.concat("<text>"+text+"</text>");
        request=request.concat("</message>");
        request=request.concat("<numbers>");
        for (Map.Entry entry : phones.entrySet()) {
            request=request.concat("<number messageID=\""+entry.getKey()+"\">"+entry.getValue()+"</number>");
        }
        request=request.concat("</numbers>");
        request=request.concat("</SMS>");
        return request;
        
    }
    
    public String sendSMS(String text, Map<String, String>  phones){
        String request="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        request=request.concat("<SMS>");
        request=request.concat("<operations>");
        request=request.concat("<operation>SEND</operation>");
        request=request.concat("</operations>");
        request=request.concat("<authentification>");
        request=request.concat("<username>"+"</username>");
        request=request.concat("<password>"+"</password>");
        request=request.concat("</authentification>");
        request=request.concat("<message>");
        request=request.concat("<sender></sender>");
        request=request.concat("<text>"+text+"</text>");
        request=request.concat("</message>");
        request=request.concat("<numbers>");
        for (Map.Entry entry : phones.entrySet()) {
            request=request.concat("<number messageID=\""+entry.getKey()+"\">"+entry.getValue()+"</number>");
        }
        request=request.concat("</numbers>");
        request=request.concat("</SMS>");
        return request;
        
    }

}
