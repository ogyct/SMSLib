# SMSLib
This library allows user to set connection with Atompark and send sms messages.

To initialize process instantiate SMSLib class e.x : SMSLib smsLib = new SMSLib(Credentials.USERNAME, Credentials.PASSWORD);

After you have instance created, call certain method to execute process.

getBalance() method allows you to find out balance of an account.

To send a message call sendSMS() method. e.x. 
```
        SMSLib smsLib = new SMSLib(Credentials.USERNAME, Credentials.PASSWORD);
        Map<String, String> phones = new HashMap<String, String>();
        phones.put("czechNumber", "+420731634696");
        Result res = smsLib.sendSMS("id", "message", phones);
```        
The same approach can be used to calculate price of transaction without actually sending sms. ex.:
```
        SMSLib smsLib = new SMSLib(Credentials.USERNAME, Credentials.PASSWORD);
        Map<String, String> phones = new HashMap<String, String>();
        phones.put("russianNumber", "+79193386820");
        Result res = smsLib.getPrice("", "", phones);
```        
Library returns Result object. It contains Bean object with response info if no technical error occured.
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
Status: negative status means some business error(insufficient funs, auth fail etc.) 0 status means success. 

Credits is a common balance value.

Amount is a balance value in certain currency.

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
Status: negative status means some business error(insufficient funs, auth fail etc.) 0 status means success. Positive number means count of sent messages.

Credits is a cost of sms delivery in a common currency

amount is a cost of sms delivery in a certain currency

Same for the getPrice method.

Examples of usage can be found in IntegrationTests.java
