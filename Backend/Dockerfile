FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://ep-noisy-salad-a523qtew.us-east-2.aws.neon.tech:5432/lexart_db_app?sslmode=require
ENV SPRING_DATASOURCE_USERNAME=lexart_db_app_owner
ENV SPRING_DATASOURCE_PASSWORD=2NAvH3iyKSph
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.PostgreSQLDialect

ENV JWT_SECRET_KEY=A9YuqwfdGi5foSOZfxhLFrU/KnghisE6F6/MSVn9qZ2atx55CBwjRR4fHaCxL95N
ENV JWT_TIME_EXPIRATION=86400000

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
