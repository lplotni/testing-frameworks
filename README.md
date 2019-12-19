# testing-jvm-frameworks
Let's compare jvm frameworks 🎉💻

The idea is pretty simple: How does the same simple service that is able to
consume a message from a queue and expose some information via an HTTP endpoint
looks like in different popular jvm frameworks/libs. And how do those services
compare based on:
* startup time
* size of the artifact
* memory footprint

## Numbers based on following local setup
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
