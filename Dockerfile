FROM amazoncorretto:21-alpine-jdk AS build
WORKDIR /workspace/app
COPY . .
RUN chmod +x ./gradlew
RUN --mount=type=cache,target=/root/.gradle ./gradlew clean build --no-daemon -x test -x sonarlintMain -x sonarlintTest -x spotlessCheck -x spotlessJavaCheck
RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*boot.jar)

FROM amazoncorretto:21-alpine-jdk
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "dev.wolffcode.spring_boot_demo.Application"]