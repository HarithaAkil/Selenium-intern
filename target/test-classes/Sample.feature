
Feature: To validate the login functionality of facebook application. 

Background:
Given To launch the firefox browser and maximize window.


Scenario: To validate login with valid username and invalid password.
When To launch the url of the facebook application.
And  To pass valid username in email field.
And  To pass invalid username in password field.
And  To click the login button.
And  To check whether navigate to the homepage or not 
Then To close the browser
  
  Scenario Outline: To validate the positive and negative combination of login functionality
  Given User has to launch the browser and maximize the window
  When User has to hit the facebook url
  And User has to pass the data  "<emaildatas>"  in email field
  And User has to pass the data  "<passworddatas>" in password field
  And User has to click login button 
  Then User has to close the browser

Examples:

|emaildatas               |passworddatas|
|harithabscit@gmail.com   |haritha      |
|akil123@gmail.com        |akil         | 
|qwert@gmail.com          |hastb        | 

