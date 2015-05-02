package com.easycoremedia.sms.response;

public enum EnumStatus {
    
    AUTH_FAILED, //-1
    XML_ERROR, //-2
    NOT_ENOUGH_CREDITS,//-3
    NO_RECIPIENTS, //-4
    OK, //>0
    
    //Message status
    SENT,
    NOT_DELIVERED,
    DELIVERED,
    NOT_ALLOWED,
    INVALID_DESTINATION_ADDRESS,
    INVALID_SOURCE_ADDRESS
    //NOT_ENOUGH_CREDITS
    
}
