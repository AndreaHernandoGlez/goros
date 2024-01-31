# Utiliza una imagen base que incluye Java (por ejemplo, OpenJDK)
FROM openjdk:20

COPY out/artifacts/goros_jar/goros.jar /home

EXPOSE 8080

CMD ["java", "-jar", "/home/goros.jar"]
