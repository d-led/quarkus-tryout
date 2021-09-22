# quarkus-tryout

[![Java CI with Gradle](https://github.com/d-led/quarkus-tryout/actions/workflows/gradle.yml/badge.svg)](https://github.com/d-led/quarkus-tryout/actions/workflows/gradle.yml) [![Docker](https://github.com/d-led/quarkus-tryout/actions/workflows/docker-publish.yml/badge.svg)](https://github.com/d-led/quarkus-tryout/actions/workflows/docker-publish.yml)

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

Windows: `gradlew quarkusDev`

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

&rarr; Swagger-UI: http://localhost:8080/q/swagger-ui/

## Packaging and running the application

The application can be packaged using:
```shell script
./gradlew build
```
It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

## Creating a native executable

Make sure, GraalVM & native-image is installed: `gu install native-image`

You can create a native executable using: 
```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using (producing a Linux executable): 
```shell script
./gradlew build build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/**runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.

## Building and Running in Docker

build-it-yourself:

```shell
docker-compose up --build
```

pre-built:

```shell
docker run --rm --name="quarkus-tryout" -p 8080:8080 ghcr.io/d-led/quarkus-tryout:master
```

&darr; http://localhost:8080/hello/multiply?a=11&b=32

## Testing

- run all the tests: `gradle test`
- run all tests marked to be run in native mode
  ([no injection](https://quarkus.io/guides/getting-started-testing#native-executable-testing) 
  due to the compilation mode): `gradle testNative`
- mutation testing: `gradle pitest`
  &rarr; open [open build/reports/pitest/index.html](open build/reports/pitest/index.html )
  &rarr; `Replaced integer multiplication with addition → SURVIVED`
  &rarr; adding another test case for a full mutation coverage
  &rarr; ok
- property-based testing: `gradle jqwik --info`
  &rarr; `Property [MathsProperties:multiplying positive numbers returns positive number] failed with sample {0=3379, 1=635539}`
- try out the endpoint: `gradle quarkusDev` &rarr; http://localhost:8080/hello/multiply?a=11&b=3

## Related Guides

- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

## How this project was created

```bash
mvn io.quarkus:quarkus-maven-plugin:2.0.3.Final:create \
    -DprojectGroupId=com.github.d.led \
    -DprojectArtifactId=quarkus-tryout \
    -DprojectVersion=0.0.1 \
    -DclassName="com.github.d.led.controllers.Tryout" \
    -Dextensions="resteasy,resteasy-jackson" \
    -DbuildTool=gradle
```

