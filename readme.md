Technologies:
=
* Java 8: Java(TM) SE Runtime Environment (build 1.8.0_91-b15)
* MAVEN
* jbehave-core - version 4.8
* org.seleniumhq.selenium - v 4.1.1
* org.seleniumhq.selenium - v 4.1.1
* webdrivermanager - v 5.0.3


How to run:
=
mvn clean test (to run the tests with default chrome browser)

mvn clean test -Dbrowser=browserName (to run t he tests with different browsers. available options chrome, firefox, ie, edge)