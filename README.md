# Freemarker CSRF Error

This repository captures the minimal amount of code to demonstrate the issue in this GitHub issue:
https://github.com/spring-projects/spring-boot/issues/33715.

The problem is that in SpringBoot 3 _csrf attribute injection in free marker templates no longer works.

There appears to be a workaround if `spring.freemarker.expose-request-attributes=true` is set, but that does not seem
like a viable long term solution.

## Observing SpringBoot 2 Behavior

Requires Java 17+.

1. `./gradlew sb2:bootRun`
2. Visit `localhost:8082/demo`
3. Note the error on the browser and in the stack trace. `The following has evaluated to null or missing: ==> _csrf [in template "demo.ftlh" at line 10, column 4]`

## Observing SpringBoot 3 Behavior

1. `./gradlew sb2:bootRun`
2. Visit `localhost:8083/demo`
3. Note how the page loads and the fields of the `_csrf` attribute load correctly.
