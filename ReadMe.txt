Overview for implementing Duo Two-Factor Authentication using their Web SDK


The Goal

		The goal of this Proof Of Concept is to show how Duo Security's second factor authorization
	can be implemented into any Web Application. Duo provides to all administrators on their website access 
	to a Web Software Development Kit (SDK), granting users three values necessary for using their service. 
	Two of what they provide,an integration and security key, are used to create a signed request, 
	using Java applications that they provide for download (DuoWeb.java, DuoWebException.java, etc).
	The third piece they provide, an API hostname, is used in correspondance with this generated sign request 
	to gain access to Duo's Second Factor web page, through a Javascript file (Duo-Web-v1) given by Duo. This
	Proof of Concept does all of these things using a combination of Spring Boot with a Thymeleaf MVC addition
	and deploys it to the local host using Apache Maven.

	
	
Downloads
Download Duo's provided Java applications and JavaScript from https://github.com/duosecurity/duo_java

	>> SprintAttempt/src/main/webapp/Duo-Web-v1.min.js is the main JavaScrpt file that must be stored in the same folder as your login.html file
	>> SprintAttempt/src/main/webapp/jquery-2.1.4.min.js is a Javascript file called on by Duo Web v1
	>> SpringAttempt/pom.xml Serves as the main Maven pom file
	>> SprintAttempt/src/main/java/duo/Base64.java This program features the main encoding process used to encrypt all data
	>> SprintAttempt/src/main/java/duo/DuoWeb.java The main Duo program, here is where the main program (Resource.java) will call to start the entire encryption process
	>> SprintAttempt/src/main/java/duo/DuoWebException.java Creates a new exception that can be thrown if the interaction times out
	>> SprintAttempt/src/main/java/duo/Util.java Contains two main functions, a function that signs a generated String using HMAC and a personal generated secret key


	
Directory

SpringAttempt

	pom.xml -- The main POM which includes the Spring boot, Thymeleaf, and apache tomcat dependency used for building the webpage
	
	
SpringAttempt/target

	gs-serving-web-content-0.1.0 -- The executable Jar file that is created with each mvn clean install run. Launches the localhost 

	
SpringAttempt/src/main/resources
This is the folder all HTML and JavaScript files should be stored in

	login.html -- The login html page that features the iFrame with Duo second factor authorization 
	loginDocumentation.txt -- The documentation of the login.html page
	
	loginIndex.html -- The loginIndex html page which serves as the primary login page
	loginIndexDocumentation.txt -- The documentation of the loginIndex.html page
	
	notLogin.html -- The notLogin html page which serves as the error page for when a user fails to properly log in with username and password
	notLoginDocumentation.txt -- The documentation of the notLogin.html page

	
	
SpringAttempt/src/main/webapp
Features both of the Javascript files used in creation of the Duo iFrame login page
The current application.properties loaded into Spring Boot requires all Javascript files to be kept here

	Duo-Web-v1.min.js -- The main Javascript file used for creation of the Duo login page
	jquery-2.1.4.min.js -- Javascript file required for Duo-Web-v1 to run properly
	
	
	
SpringAttempt/src/main/java/duo
Contains all relevant .java files

	Application.java -- The main Spring Boot run file, features the main method of the entire project
	DuoController.java -- Main Spring controller file, calls all html files, Java files, and essentially runs and determines all of the webpage
	loginIndex.java -- Creates a loginIndex Object which is used to store inputted username and password and also store the generated sign request from Duo
	DuoWeb.java -- THe main java application given by Duo, generates the necessary sign request through calling the other three Java methods given by Duo
		DuoWebException.java -- Creates a new exception for DuoWeb
		Base64.java -- encrypts several different strings in the DuoWeb process for added security
		Util.java -- called upon by DuoWeb to process parts of the sign request generation

		

Running the Program

	1. cd cd \workspace\SpringAttempt      					Directory should be set to the POM file that everything runs through
	2. mvn clean install 									Compiles the program using Apache Maven
	3. java -jar target/gs-serving-web-content-0.1.0.jar 	Run the server through the generated jar file





















