This bbdTests includes all behaviour test cases using serenity and sereniyy

To run BDD tests

Make sure your application is running 

#To run java application
First import parent project as mvn in Eclips.

	In Eclips Right click on Application.start file and run as Java Application


#To run BDD tests
	mvn verify

This will create new folder as target inside bddTests(Module name)
Go to Target-> site-> serenity-> index.html to see serenity reports

Open index.html file with web browser to see tests report