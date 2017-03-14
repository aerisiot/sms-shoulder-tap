#!/bin/sh
cd /home/pi/piClient/client
mkdir newlogs
sudo -i
/etc/init.d/gammu-smsd stop
sleep 10
/etc/init.d/gammu-smsd stop

java -classpath *:client-0.0.1-SNAPSHOT.jar com.aeris.piDay.client.Initiator & 



/etc/init.d/gammu-smsd stop

sleep 8

/etc/init.d/gammu-smsd start
