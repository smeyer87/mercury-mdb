# Composable application example for MongoDB

The lambda-example-mdb demonstrates REST automation (lightweight non-blocking HTTP server) that allows you
to create REST endpoints by configuration instead of code.  The original project (lambda-example) has been extended to support an interface writing data to a MongoDB Atlas database configured by the user.

It illustrates building individual event-driven functions using Java (LambdaFunction and TypedLambdaFunction) and
Kotlin (suspend function that implements the KotlinLambdaFunction interface).

Unit test examples are also provided.

## Spring Boot

This sample application does not have Spring framework or Spring Boot dependencies so that it can be used
with Spring Boot or other frameworks.

The "spring-boot-parent" dependency in the pom.xml is a convenient way to fetch latest open sources libraries
that have been vetted by the Spring community.
