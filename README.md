# Java 11 In Action
## New features from java 1.8 to java 11
### Environment

1. **Java 11.0.12**
2. **Gradle 6.9.1**

## Index

1. [Java 9](#java-9)
   1. [Deprecated List](#deprecated-list)
      1. [Modular System – Jigsaw Project](#modular-system---jigsaw-project)
   2. [New Features](#new-features)
2. [Java 10](#java-10)
   1. [Deprecated List](#deprecated-list)
   2. [New Features](#new-features)
3. [Java 11](#java-11)
   1. [Deprecated List](#deprecated-list)
   2. [New Features](#new-features)

##Java 9

###Deprecated List

https://docs.oracle.com/javase/9/docs/api/deprecated-list.html

###New Features

https://www.baeldung.com/new-java-9

## Modular System - Jigsaw Project

We can only have one module per JAR file.

The JDK now has a new structure, based in modules, you can see it, using the command

```shell
java --list-modules
```

#### Modular types

* System Modules
* Application Modules
* Automatic Modules
* Unnamed Module

#### Declaration module

In the root of the project you should create a file called `module-info.java` to declare the packages to expose and
modules to consume

```java
module my.name.module {
    // Packeges to expose/consume
    // The name of module doesn't need be the same as the package name, but it is recommended that it be
}
```

##### Directives inside the module declaration

1. Requires
2. Requires Static
3. Requires Transitive
4. Exports
5. Exports To
6. Uses
7. Provides With
8. Open
9. Opens
10. Opens To

### Example

In this repository we have two projects. The main project called `java11-in-action:app` and the library project
called `java11-in-action:library`.

In the library project `java11-in-actio:library` you can see a simple logic with a Student model example. In the root
src you can see a file called `module-info.java` where there is defined the packages to expose.

```java
module base.domain.module {
    exports module.test.student.model;
    exports module.test.student.service.impl;
}
```

In this case we're exposing the model and service.impl package.

In the main project called `java11-in-action:app` in the root
src you can see a file called `module-info.java` where it's defined the name module project and the other modules consumed by this project.

```java
module main.app.module {
    requires base.domain.module;
}
```

You can see the main project consume the library module called `base.domain.module` and in the main class App.java we only consume the classes exposes in the library module-info and no other one.

To execute this project stand in the root folder `java11-in-action` and run the following command:

`./gradlew library:build app:build app:run`

## A New HTTP Client

The new Java HTTP client dispose to us a new robust class with the builder pattern and can be Sync or Async call. It supports Https/2 and is non-lockable call. The unique problem here is other libraries has improved their custom class, so they have more years of develop and bug fixes (Spring, Apache, Httpok)

Anyway the new class is easier to implement by comparing the old one.

Example

```java
HttpRequest request = HttpRequest.newBuilder()
  .uri(new URI("https://postman-echo.com/get"))
  .version(HttpClient.Version.HTTP_2)
  .GET()
  .build();

HttpResponse<String> response = HttpClient.newHttpClient()
  .send(request, HttpResponse.BodyHandlers.ofString());
```

## Process API



## Try-With-Resources

## Diamond Operator Extension

## Interface Private Method

## JShell Command Line Tool

## JCMD Sub-Commands

## Мulti-Resolution Image API

## Publish-Subscribe Framework (Reactive Streams)

## Unified JVM Logging

## Immutable Set

## Optional to Stream

## Java 10

### Deprecated List

https://docs.oracle.com/javase/10/docs/api/deprecated-list.html

### New Features

https://www.baeldung.com/java-10-overview

## Local Variable Type Inference

* Before

All variable declarations

```java
InputStream is=new InputStream();
```

* After

```java
var is=new InputStream();
```

Cannot be initialize without initial value or null value

Cannot be return, parameter or fields types. This is to prevent binary incompatibilities

You should not use `var` to defined 'anything' Object, this feature was create to make the code more readable, not more
generic.

You shloud use `var` only when the algorithm provides sufficient information.

## Unmodifiable Collections

## Performance Improvements

## Container Awareness

## Java 11

### Deprecated List

* Java API for XML-Based Web Services (java.xml.ws)
* Java Architecture for XML Binding (java.xml.bind)
* JavaBeans Activation Framework (java.activation)
* Common Annotations (java.xml.ws.annotation)
* Common Object Request Broker Architecture (java.corba)
* JavaTransaction API (java.transaction)

### New Features

https://www.baeldung.com/java-11-new-features

## New String Methods

## New File Methods

## The Not Predicate Method

## Local-Variable Syntax for Lambda

* Before

Lambda expression could by explicitly or implicitly types

* Explicitly

```java
(Item x,int y)->x.process(y);
```

* Implicitly

```java
(x,y)->x.process(y);
```

* After

Lambda expression could by implicitly with var types

```java
(var x,var y)->x.process(y);
```

## HTTP API improves, support HTTP/1.1 and HTTP/2

## Launch Single File Program

* Before

```bash
javac -d classes HelloWorld.java
java -cp classes HelloWorld
```

* After

```bash
java HelloWorld.java
```

## Performance Enhancements

## JEP 328 - Java Flight Recorder

Profiling with Extremely Low Overhead.

Before JDK 11, this feature was commercial option.

## JEP 333: GZC - Predictable, Low Latency, Large heap GC (Experimental)

New GC with multiples features.

GC time reduction from 300ms to 12ms
