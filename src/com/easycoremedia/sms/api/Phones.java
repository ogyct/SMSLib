package com.easycoremedia.sms.api;

public class Phones {
    public String idMessage;
    public String variables;
    public String phone;

    public Phones(String idMessage, String variables, String phone) {
        this.phone = phone;
        this.variables = variables;
        this.idMessage = idMessage;
    }

    public String getIdMessage() {
        return this.idMessage;
    }

    public String getVariable() {
        return this.variables;
    }

    public String getPhone() {
        return this.phone;
    }

}