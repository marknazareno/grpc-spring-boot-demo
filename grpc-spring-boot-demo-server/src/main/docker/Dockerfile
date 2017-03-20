FROM openjdk:alpine

ADD *.jar app.jar

ENV JAVA_OPTS=""

CMD ["java", "-jar", "app.jar", "$JAVA_OPTS"]