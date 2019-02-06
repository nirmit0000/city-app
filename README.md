# city-app
City-App project has an endpoint exposed as "/connected" , provided origin and destination , it basically checks whether two cities are connected with each other or not . 

Swagger UI: http://localhost:8080/swagger-ui.html#

Swagger Endpoint : http://localhost:8181/v2/api-docs

Rest Endpoint : http://localhost:8181/connected?origin=[origin_place_value]&destination=[destination_place_value]

Softwares : 
Java 8 , Maven

We have to set below environment variables to make the application work in local . 

JAVA_HOME=JDK_INSTALLATION_DIRECTORY_PATH

M2_HOME=MAVEN_FOLDER_PATH

PATH=%PATH%;%JAVA_HOME%\bin;%M2_HOME%\bin


To run application in local : mvn spring-boot:run
