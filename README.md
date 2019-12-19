# testing-jvm-frameworks
Let's compare jvm frameworks 🎉💻


**The idea is pretty simple:**
 
_How does the same simple service that is able to
consume a message from a queue and expose some information via an HTTP endpoint
looks like in different popular jvm frameworks/libs. And how do those services
compare based on:_

* _startup time_
* _size of the artifact_
* _memory footprint_
* _personal take on the codebase feel_

## Playground domain
Each service uses a fictional domain consuming bookings over a queue and stores it in memory providing certain statistics for those bookings over HTTP.

## Local setup used to measure
### Local java version
```
 ~/repos/testing-jvm-frameworks > java --version
 openjdk 13.0.1 2019-10-15
 OpenJDK Runtime Environment (build 13.0.1+9)
 OpenJDK 64-Bit Server VM (build 13.0.1+9, mixed mode, sharing)
```

### Hardware
* MacBook Pro (13-inch, 2018, Four Thunderbolt 3 Ports)
* CPU: 2,7 GHz Quad-Core Intel Core i7
* Memory: 16 GB 2133 MHz LPDDR3

## Spring-based service
Bootstapped using [spring-initializr](https://start.spring.io)

Endpoints:
- http://localhost:8080/actuator/health
- http://localhost:8080/statistics

### Startup time
#### Only providing the endpoint
```bash
2019-12-19 12:50:16.616  INFO 9235 --- [main] d.l.test.bookings.BookingsApplication    : Started BookingsApplication in 1.785 seconds (JVM running for 2.127)
```

## Micronaut-based service
Bootsrapped using [micronaut cli](https://docs.micronaut.io/snapshot/guide/index.html#buildCLI)

Endpoints:
- http://localhost:8080/statistics

### Startup time (graalvm & native-image)
#### Only providing the endpoint
```bash
15:44:12.614 [main] INFO  io.micronaut.runtime.Micronaut - Startup completed in 22ms. Server Running: http://localhost:8080
```

## Quarkus-base service
Bootsrapped using [quarkus starter](https://code.quarkus.io/)

Endpoints:
- http://localhost:8080/statistics

### Startup time
Although quarkus supports graalvm and native-images it's currently not compatilbe with java11 & graalvm (https://github.com/quarkusio/quarkus/issues/5691).
#### Only providing the endpoint
```bash
<to come....>
```


## Resources
- Quarkus: https://www.youtube.com/watch?v=SQDR34KoC-8
- Micronaut: https://www.youtube.com/watch?v=RtjSqRZ_md4
- Quarkus vs. Micronaut: https://www.youtube.com/watch?v=hnEXOqcNXPs
