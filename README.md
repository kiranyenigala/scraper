scraper
===========

*scraper* is a console application that scrapes the Sainsbury’s grocery site - Ripe Fruits page and prints out
a JSON array of all the products on the page.

GitHub project repository: https://github.com/kiranyenigala/scraper.git

source tree
-----------

Project's source tree looks like:

    .
    |-- nbproject
    `-- src
        |-- main
        |   `-- java
        |       `-- com
        |           `-- sainsbury
        |               `-- grocery
        |                    `-- converter
        |                    `-- parser
        |
        `-- test
            `-- java
                `-- com
                    `-- sainsbury
                        `-- grocery
                            `-- converter
                             `-- parser

dependencies
------------

*scraper* depends on just few popular libraries/frameworks:

- jackson-annotations - for JSON data manipulation.
- jackson-databind - for convert java object into json
- jsoup - for HTML parsing and DOM manipulation as well as web connections.
- junit - for testing.

running the application
-----------------------

The simplest way to run the application is to clone the repository, and use Maven to compile and run it:

    cd /tmp
    git clone git@github.com:kiranyenigala/scraper.git
    cd sainscraper
    mvn compile
    mvn exec:java

I have also configured maven to package all dependencies in a single, executable JAR. To generate this JAR file
execute

    mvn package

After that you can run the application with simple:

    java -jar target/scraper-1.0-SNAPSHOT.jar

The scraper-1.0-SNAPSHOT.jar can then be copied anywhere and executed independently.

testing
-------

To execute tests run:

`mvn test`
