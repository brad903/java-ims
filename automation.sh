#! /bin/bash
APPLICATION_NAME=java-ims

SCRIPTPATH=$(cd "$(dirname "$0")";  pwd -P)
echo "sh file location : " $SCRIPTPATH

echo "> Git pull"

git pull

echo "> Build project"

./gradlew build

CURRENT_PID=$(pgrep -f java-ims)

echo $CURRENT_PID

if [ -z $CURRENT_PID ]; then
	echo "> There is no application that is operating"
else
	echo "> kill -2 $CURRENT_PID"
	kill -2 $CURRENT_PID
	sleep 5
fi

echo "> New application released"

JAR_NAME=$(ls $SCRIPTPATH/build/libs |grep 'java-ims' |tail -n 1)

echo "> JAR name: $JAR_NAME"

chmod 755 $SCRIPTPATH/build/libs/$JAR_NAME
nohup java -jar $SCRIPTPATH/build/libs/$JAR_NAME &
