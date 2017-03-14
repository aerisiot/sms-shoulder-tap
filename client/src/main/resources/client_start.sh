#!/bin/sh

cd libs
echo "Initiating client....."
java  -classpath * com.aeris.piDay.client.Initiator &
echo "Deployment process complete...."

