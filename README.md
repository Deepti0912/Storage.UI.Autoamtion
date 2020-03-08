# Storage.UI.Autoamtion
Box Site Automation Framework 
https://www.box.com
Box site provides secure content management and file sharing facilities
========================================================================
## Scope of this Project

1. Automate login functionality with happy and unhappy login paths
2. User with valid login credentials able to create a new folder on the site
3. User with valid login credentials able to upload a file within the folder on the site
========================================================================
## Tools and Technologies ##

   *Java                # Programming Language
  *Cucumber      # BDD-Gherkin
  *pom.xml          # Maven project build definition, Maven dependencies 
   *JUnit				#Unit Testing Framework
   *log4j			    #Logging Framework
   
 ========================================================================
 ## Prerequisites  ##  
 * Install Java8, Maven and IDE of choice (Intellij)
 * Add Cucumber with Java and Gherkin plugins to IDE
 * Save **test.png** file at **C:/temp** folder. This file will be used to upload to the Box site. This is important in order for successful upload of the file. 

========================================================================
## Directory Structure ##

    pom.xml                                     # Maven project build definition
   
    src/
   
        main/
            java/                               # Java source code
       
        test/
            java/                               # Java source code
                 basePage/                      # Parent Page extending PageObject
                 driverSetup/                   # Driver classes
                    Setup/                      # Driver setup methods covered
                    TearDown/                   # Tear Down methods covered
                    Wait/                       # Various Wait methods covered
                 homePage/                      # 
                     HomePage/                  # HomePage Page Library with assertions
                     HomePageSteps/             # Gherkin to Java model Transformer classes   Steps Library       
                 loginPage/                     # 
                     LoginPage/                 # LoginPage Page Library with assertions
                     LoginPageSteps/            # Gherkin to Java model Transformer classes    
                  Runnder/                      # Test Runner used for gluing Steps with Tests 
            resources/                          # Project resources
                features/                       # Test feature files      
    
    target/                                     # output, test reports

========================================================================
## Steps for Execution ##

* Unzip the project file and open it in Intellij
* To run the tests, right click on the feature file (FileUpload.feature) under the resources folder (src/test/resources)

========================================================================
## Future Capabilities and Enhancements 

The code has been structured to accommodate future enhancements. 

Following are some of the capabilities that can be achieved as a part of future enhancements:

|S. No | Future Enhancements                                                                               |
|------|--------------------------------------------------------------------------------------------|
|1.    | Ability to run mvn project via command prompt                                                                         |  
|2.    | Ability to add additional features via features files                                                                   |
|3.    | Parallel Execution (of feature files)                                                      |
|4.    | Execution of Tagged Scenarios                                                              |   
|5.    | Cross Browser Execution via Configuration                                                  |
|6.    | Headless Execution                                                         |
|7.    | Integration to CI/CD Build Pipeline                                                    |
|8.    | Execution on Standalone Docker Container                                        |
|9.    |  Execution on Selenium Grid   |
