# sms-shoulder-tap
Implementation to demonstrate that an IOT device can be brought online by sending a SMS (MT-SMS) to the device.

## Prerequsite
* Raspberry Pi w/ Raspbian OS
* JRE 8 
* Aeris SIM
* Celluar Modem
* AWS IOT Account


## How to Run the Client
1. Follow all instructions from the [secure-pubsub wiki](https://github.com/aerisiot/sms-shoulder-tap/wiki) before running this client.

2. Boot the Raspberry Pi and start a terminal console.

3. Download securePubNub.js to a directory on the Pi.

4. Login to your Aeris account at https://aerport.aeris.com. Find the SIM card by ICCD and then use the "Send SMS" menu in the Dashboard to send an SMS. Put any content in the SMS, for example "hello" and send it. 

See the [secure-pubsub wiki](https://github.com/aerisiot/sms-shoulder-tap/wiki) for more information.
