FROM amazoncorretto:17
EXPOSE 80
ARG JAR_FILE=./build/libs/kt-sym.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
