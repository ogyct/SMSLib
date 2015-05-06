//package com.easycoremedia.sms.exception;
//
///**
// * This class takes status response string and checks if it means some business error
// * @author avgustisd
// *
// */
//public class ExceptionChecker {
//
//    /**
//     * Each number means certain business error
//     * @param statusNumber
//     * @throws SMSLibException
//     */
//    public static void checkIfException(String statusNumber) throws SMSLibException {
//        String errorMsg;
//        if ("-4".equals(statusNumber)) {
//            errorMsg = "NO_RECIPIENTS";
//            throw new SMSLibException(errorMsg);
//        } else if ("-3".equals(statusNumber)) {
//            errorMsg = "NOT_ENOUGH_CREDITS";
//            throw new SMSLibException(errorMsg);
//        } else if ("-2".equals(statusNumber)) {
//            errorMsg = "XML_ERROR";
//            throw new SMSLibException(errorMsg);
//        } else if ("-1".equals(statusNumber)) {
//            errorMsg = "AUTH_FAILED";
//            throw new SMSLibException(errorMsg);
//        }
//    }
//
//}
