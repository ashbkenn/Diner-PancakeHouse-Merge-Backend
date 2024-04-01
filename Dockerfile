FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/merger-0.0.1.jar merger.jar
ENTRYPOINT ["java", "-jar", "merger.jar"]
