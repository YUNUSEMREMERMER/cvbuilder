FROM openjdk:11
WORKDIR /app
COPY . .
RUN chmod +x mvnw && ./mvnw clean install -U
ENTRYPOINT ["./mvnw", "spring-boot:run"]


# ->çalışıyor
# FROM openjdk:11
# WORKDIR /app
# COPY . .
# RUN chmod +x mvnw && ./mvnw clean install -U
# ENTRYPOINT ["./mvnw", "spring-boot:run"]

# -> çalışıyor
# FROM openjdk:11 
# WORKDIR /app
# ADD target/cvbuilder-0.0.1-SNAPSHOT.jar cvbuilder-0.0.1-SNAPSHOT.jar
# ENTRYPOINT ["java", "-jar", "cvbuilder-0.0.1-SNAPSHOT.jar"]


# -> çalışıyor
#Usage with maven exec method
# FROM openjdk:11
# WORKDIR /app
# COPY . .
# RUN chmod +x mvnw && ./mvnw clean install -U
# ENTRYPOINT ["./mvnw", "spring-boot:run"]

