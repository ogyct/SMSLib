package com.easycoremedia.sms.exception;

/**
 * This class takes status response string and checks if it means some business error
 * @author avgustisd
 *
 */
public class ExceptionChecker {

    /**
     * Each number means certain business error
     * @param statusNumber
     * @throws SMSLibException
     */
    public static void checkIfException(String statusNumber) throws SMSLibException {
        String errorMsg;
        switch (statusNumber) {
        case "-4":
            errorMsg = "NO_RECIPIENTS";
            throw new SMSLibException(errorMsg);
        case "-3":
            errorMsg = "NOT_ENOUGH_CREDITS";
            throw new SMSLibException(errorMsg);
        case "-2":
            errorMsg = "XML_ERROR";
            throw new SMSLibException(errorMsg);
        case "-1":
            errorMsg = "AUTH_FAILED";
            throw new SMSLibException(errorMsg);
        }
    }

}
