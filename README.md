# Freemarker CSRF Error

This application represents the minimal set of code to illustrate how Freemarker CSRF 
no longer works in SpringBoot 3.

To reproduce the issue...

1. Install Java 17+
2. `./gradlew bootRun`
3. Visit `localhost:8080/demo`
4. Note the error on the browser and in the stack trace.
    ` The following has evaluated to null or missing: ==> _csrf [in template "demo.ftlh" at line 10, column 4]`

There is a workaround that has been identified where setting `spring.freemarker.expose-request-attributes=true`
fixes the issue, but this does not seem like a proper solution.
