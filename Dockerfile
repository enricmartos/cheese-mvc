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
ADD build/libs/cheese-mvc-0.1.0.jar cheese-mvc.jar
# expose the port (configured on app.props server port)
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "cheese-mvc.jar"]
