#!/bin/sh
cd /home/pi/piClient/client

sudo /etc/init.d/gammu-smsd stop

sleep 5

sudo java -classpath *:./lib/* com.aeris.piDay.client.Initiator --clientEndpoint $AWS_HOST -clientId sdk-java -certificateFile myPie.cert.pem -privateKeyFile myPie.private.key $PUBLISH_DURATION


sleep 2

sudo /etc/init.d/gammu-smsd start
