@screen
@logs
Feature: Create project

  Scenario: Login
    Given I open url "https://uat-languagecloud.sdl.com/lc/login"
    When I login with "admin.test.uat@sdl.testinator.com" and "Weaver123"

  Scenario: Create project
    Then I open Projects page
    And I click on 'New Project' button
    And I type 'project name' name
    And I type 'HP' location
    And I type 'English (United States)' Source Language
    And I type 'Urdu (India)' Target Language
    And I type 'Default File Type Configuration from HP folder' File Type Configuration
    And I upload a file 'upload-file'
    Then I click on the Next button
    And I type 'HP_TranslationEngine' Translation Engine
    Then I click on the Next button
    And I type 'root pricing model' Pricing Model
    Then I click on the Next button 
    And I type 'WF-4_CP_2Languages' Workflow
    Then I click on the Next button 
    And I click on the Create & Start button
    Then 'Successfully created your project' and 'Successfully started the workflow.' notifications are displayed
    And 'project name' project is displayed in the list
    And I stop the test
    
  Scenario: Logout
   And I logout from LC