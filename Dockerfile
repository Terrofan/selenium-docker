FROM openjdk:8u212-jre-alpine3.9

RUN apk add curl jq dos2unix

# Workspace
WORKDIR /usr/share/udemy

# ADD .jar under target from host
# into this image
ADD target/selenium-docker.jar         selenium-docker.jar
ADD target/selenium-docker-tests.jar   selenium-docker-tests.jar
ADD target/libs						   libs

# ADD suite files
ADD book-flight-module.xml			   book-flight-module.xml
ADD search-module.xml				   search-module.xml

#ADD health-check script
ADD health-check.sh						health-check.sh
RUN dos2unix health-check.sh

# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT sh health-check.sh