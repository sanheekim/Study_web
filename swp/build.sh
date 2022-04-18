#!/bin/sh

cd /usr/local/tomcat/webapps

mv ROOT.war ROOT.war.bak
rm -rf ROOT

mv swp*.war ROOT.war
rm -rf swp*

# check loop for 60 seconds
for i in {1..60}
do
  echo $i
  ls .
  if [ -d "ROOT" ]; then
    break;
  fi
  sleep 1
done

# change servlet-context.xml for real service
DIR='/usr/local/tomcat/webapps/ROOT/WEB-INF/spring/appServlet'

cd $DIR
mv servlet-context.real servlet-context.xml

cd /usr/local/tomcat
./restart.sh