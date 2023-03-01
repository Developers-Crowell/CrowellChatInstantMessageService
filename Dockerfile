FROM eclipse-temurin:19-jdk AS base
RUN apt-get update & apt upgrade -y
WORKDIR /app
EXPOSE 80
EXPOSE 443

FROM eclipse-temurin:19-jdk AS builder
WORKDIR /app
COPY . .
RUN apt-get update && apt -y upgrade && apt-get install -y maven && mvn -DskipTests -Dspring.profiles.active=develop clean package

FROM base AS final
RUN groupadd instantmessageservice && useradd -g instantmessageservice instantmessageservice
USER instantmessageservice
WORKDIR /app
COPY --from=builder /app/target/*.jar .
CMD ["java", "-jar", "/app/InstantMessageService.jar", "--spring.profiles.active=production"]