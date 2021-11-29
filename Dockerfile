FROM maven:3.6.3-jdk-11 as base

WORKDIR /app

COPY pom.xml ./
RUN mvn dependency:go-offline
COPY src ./src

FROM base as test
RUN ["mvn", "test"]

FROM base as development
CMD ["mvn", "spring-boot:run", "-Dspring-boot.run.jvmArguments='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000'"]

FROM base as build
RUN mvn package

FROM openjdk:11-jre-slim as production
EXPOSE 8080

COPY --from=build /app/target/mostcommonwords-*.jar /mostcommonwords.jar

CMD ["java", "-jar", "/mostcommonwords.jar"]