#!/bin/sh
cd /home/pi/piClient/client

sudo -i
/etc/init.d/gammu-smsd stop
sleep 10
/etc/init.d/gammu-smsd stop

java -classpath *:./lib/* com.aeris.piDay.client.Initiator --clientEndpoint $AWS_HOST -clientId sdk-java -certificateFile myPie.cert.pem -privateKeyFile myPie.private.key $PUBLISH_DURATION &


/etc/init.d/gammu-smsd stop

sleep 8

/etc/init.d/gammu-smsd start
