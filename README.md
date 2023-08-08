# AGI Assistant
## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#structure)
- [References](#references)

## Installation
Describe the installation process here.
Include any pre-requisites, required libraries, and how to get the development environment running.

### Example command line instructions
```
bash
pip install -r requirements.txt
```
## Usage
...

## Structure
### AGI-Assistant-Backend
This repository handles the data traffic and connects all the different components. <br>
### AGI-Assistant-Frontend
This repository holds everything required to run the frontend of the application. <br>
### AGI-Assistant-Model
This repository holds everything required to run the machine learning model. <br>

## References
### Repositories
Backend:   https://github.com/Knaeckebrothero/AGI-Assistant-Backend <br>
Frontend:  https://github.com/Knaeckebrothero/AGI-Assistant-Frontend <br>
Model:     https://github.com/Knaeckebrothero/AGI-Assistant-Model <br>

### Lucidchart
https://lucid.app/documents#/documents?folder_id=336580960 <br>


## AGI Backend Quarkus
How to start the application:
1.run 'docker-compose up' in the directory of the docker-compose file
2. run './gradlew quarkusDev' in the directory of the quarkus project
3. you are ready to go

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./gradlew build
```

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/agi-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.

## Related Guides

- RESTEasy Reactive ([guide](https://quarkus.io/guides/resteasy-reactive)): A Jakarta REST implementation utilizing
  build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the
  extensions that depend on it.

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
