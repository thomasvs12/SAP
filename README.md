# OData Boilerplate

The OData Boilerplate combines OpenUI5 with Spring Boot, OLingo and JPA and allows you to easily and quickly boot up a JVM based OData app based on modeling your data model in using JPA.

For convenience, a base-diagram for the JPA diagram editor has been provided as well. Once the datamodel is finished, the application with update the data model of the connected database on first run.

By default, the application comes with just one entity: Members, that is automatically populated with a few names from Application.java

Once the application is running, you can browse to http://localhost:8080 to run the sample OpenUI5 application that is using the OData service. The service itself is available from http://localhost:8080/odata.svc

## Prerequisites

To be able to run this application, you need Java JDK 1.8 and Maven.

## Installation

To install the boilerplate, you can just clone this repository to your computer.

After cloning it, set the connection parameters to connect to a database in `application.properties`

## Usage

To run the application just enter `mvn spring-boot:run`

To stop the application press control-C

To build a jar run `mvn clean package`

To run the jar `mvn -jar target/odata-0.1.0.jar`

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D

## License

This software is published under MIT license.

Please refer to LICENSE.TXT for more details