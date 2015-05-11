# SMSLib
This library allows user to set connection with Atompark and send sms messages.

To initialize process instantiate SMSLib class e.x : SMSLib smsLib = new SMSLib(Credentials.USERNAME, Credentials.PASSWORD);

After you have instance created, call certain method to execute process.

getBalance() method allows you to get balance of an account.

To send a message call sendSMS() method. The response will contain delivery cost.
Phones is a map of id+number. Id is an identificator to track message status via Atompark UI. e.x. 
```
        SMSLib smsLib = new SMSLib(Credentials.USERNAME, Credentials.PASSWORD);
        Map<String, String> phones = new HashMap<String, String>();
        phones.put("czechNumber", "+420731634696");
        Result res = smsLib.sendSMS("sender", "message", phones);
```        
getPrice() response will contain delivery cost.
getPrice() works in the same way as sendSMS(), the only difference is no sms will be actually sent:
```
        SMSLib smsLib = new SMSLib(Credentials.USERNAME, Credentials.PASSWORD);
        Map<String, String> phones = new HashMap<String, String>();
        phones.put("russianNumber", "+79193386820");
        Result res = smsLib.getPrice("sender", "message", phones);
``` 
Sender should be registered via Atompark UI. More info on https://my.atompark.com/sms/senders

Library returns Result object. It contains Bean object with response info, if no technical error occured.
Result object will contatin Exception object if any technical problem occured (Connection problem, parsing problem etc. etc.)

Bean object is made of response XML:
getBalance xml:
```
<?xml version="1.0" encoding="UTF-8"?>
<RESPONSE>
	<status>0</status>
	<credits>195</credits>
	<amount>79.82</amount>
	<currency>UAH</currency>
</RESPONSE>
```
Status: negative status means some business error(insufficient funds, auth fail etc.) 0 status means success. 

Credits: a balance value in some common currency (I don't know exatly, which one)

Amount: a balance value in currency specified in "currency" tag (UAH in this example).

sendSMS xml:
```
<?xml version="1.0" encoding="UTF-8"?>
<RESPONSE>
	<status>1</status>  
	<credits>0.2235</credits>
	<amount>0.0916</amount>
	<currency>UAH</currency>
</RESPONSE>
```
Status: negative status means some business error(insufficient funds, auth fail etc.) 0 status means success. Positive number means count of sent messages.

Credits: a cost of sms delivery in some common currency(I don't know exatly, which one)

Amount:  a cost of sms delivery in currency specified in "currency" tag (UAH in this example)

Same for the getPrice method.


Examples of usage can be found in IntegrationTests.java
