
FROM java:8
VOLUME /var/lib/docker-images
EXPOSE 8005
ADD /target/Register_Backend.jar Register_Backend.jar
ENTRYPOINT ["java" "-jar" "Register_Backend.jar"]
