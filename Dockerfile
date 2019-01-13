# base image present in Docker Hub
FROM openjdk:8
# add the spring boot jar to the container
ADD build/libs/cheese-mvc-0.1.0.jar cheese-mvc.jar
# expose the port (configured on app.props server port)
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "cheese-mvc.jar"]
