FROM maven:3.8.6-openjdk-11 as build
#ARG NEXUS_USERNAME
#ARG NEXUS_PASSWORD
#ARG MVN_CODEARTIFACT_REPO_NAME
#ARG MVN_CODEARTIFACT_URL
#ARG MVN_CODEARTIFACT_TOKEN

COPY . .
RUN rm settings.xml || true
RUN mvn -B -f pom.xml clean package -DskipTests

FROM openjdk:11.0.16-jdk
#ARG APP_NAME
COPY --from=build target/*.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]