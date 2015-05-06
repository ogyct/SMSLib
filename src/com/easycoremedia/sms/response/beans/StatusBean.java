package com.easycoremedia.sms.response.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Status bean contains structure for deliveryreport message.
 * Example: 
 * <?xml version="1.0" encoding="UTF-8"?>
 * <deliveryreport>
 *    <message id="id1" sentdate="0000-00-00 00:00:00" donedate="0000-00-00 00:00:00"
 *        status="0" />
 *    <message id="id1" sentdate="0000-00-00 00:00:00" donedate="0000-00-00 00:00:00"
 *        status="0" />
 *    <message id="id1" sentdate="0000-00-00 00:00:00" donedate="0000-00-00 00:00:00"
 *        status="0" />
 * </deliveryreport>
 * @author Dmitry
 *
 */
@XmlRootElement(name = "deliveryreport")
public class StatusBean {

    private List<Message> messages;

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @XmlElement(name = "message")
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Message tag contains 4 attributes and no value
     * @author Dmitry
     *
     */
    public static class Message {

        private String id;
        private String sentDate;
        private String doneDate;
        private String status;

        public void setId(String id) {
            this.id = id;
        }

        public void setSentDate(String sentDate) {
            this.sentDate = sentDate;
        }

        public void setDoneDate(String doneDate) {
            this.doneDate = doneDate;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @XmlAttribute(name = "id")
        public String getId() {
            return id;
        }

        @XmlAttribute(name = "sentdate")
        public String getSentDate() {
            return sentDate;
        }

        @XmlAttribute(name = "donedate")
        public String getDoneDate() {
            return doneDate;
        }

        @XmlAttribute(name = "status")
        public String getStatus() {
            return status;
        }

    }

}
