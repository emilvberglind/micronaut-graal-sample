# Use the official maven/Java 8 image to create a build artifact.
# https://hub.docker.com/_/maven
FROM maven:3.6.3-jdk-11 as builder

#Copy source to container.
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build a release artifact.
RUN mvn clean package -DskipTests

#Native image generation
FROM oracle/graalvm-ce:20.1.0-java11 as graalvm
RUN gu install native-image

COPY --from=builder /app/target/sample-app-*.jar /home/app/sample-app/sample-app.jar
WORKDIR /home/app/sample-app

RUN pwd
RUN ls -l

RUN native-image \
  --no-server \
  -H:+TraceClassInitialization \
  -H:+ReportExceptionStackTraces \
  -H:-UseServiceLoaderFeature \
  --enable-url-protocols=http,https \
  --enable-all-security-services \
  --report-unsupported-elements-at-runtime \
  --no-fallback \
  -jar sample-app.jar

RUN pwd
RUN ls -l /home/app/sample-app

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/sample-app/sample-app /app/sample-app
ENTRYPOINT ["/app/sample-app"]
