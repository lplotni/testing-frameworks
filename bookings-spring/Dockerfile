FROM adoptopenjdk/openjdk14:alpine-jre

COPY build/libs/bookings-spring-*.jar bookings.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/bookings.jar"]