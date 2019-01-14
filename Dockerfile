#Multi-stage approach
FROM openjdk:8 AS TEMP_BUILD_IMAGE
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
RUN ./gradlew build || return 0 
COPY . .
RUN ./gradlew build



# base image present in Docker Hub
FROM openjdk:8
# add the spring boot jar to the container
# ADD build/libs/cheese-mvc-0.1.0.jar cheese-mvc.jar
ENV ARTIFACT_NAME=cheese-mvc-0.1.0.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .

#ADD $APP_HOME/build/libs/$ARTIFACT_NAME $ARTIFACT_NAME


# expose the port (configured on app.props server port)
EXPOSE 8086
CMD ["java","-jar",$ARTIFACT_NAME]
# ENTRYPOINT ["java", "-jar", "cheese-mvc.jar"]
# ENTRYPOINT ["java", "-jar", $ARTIFACT_NAME]
