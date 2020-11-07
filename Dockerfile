FROM adoptopenjdk:11.0.9_11-jre-hotspot

RUN mkdir /app

WORKDIR /app

ADD ./prediction/target/prediction-0.0.1-SNAPSHOT.jar /app

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "prediction-0.0.1-SNAPSHOT.jar"]