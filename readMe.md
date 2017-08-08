This parent project includes two modules one is for CodeBase with UnitTests and another is for BDD tests
It includes code coverage by unit tests using sonar(SonarQube and Sonar Scanner)

To run parent project

#To install mvn project : This will run Unit Tests and BDD test using serenity and JBehave
	mvn clean install

#To analyze codebase with unit test code covergae
	mvn sonar:sonar

