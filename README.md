# Graders: Please read!!

## Please refer to Team Project Part 6 PDF Write-up:
It should be called LetsGo_Part_6.pdf, and it is under this master branch. No need to search through folders.

## What is this project about?:
We wanted to create an app that would help college students here at CU find things to do and participate in.  Keeping that in 
mind, our app listed events based on category that students can find on campus, such as a theater production or maybe a sporting event.  The user has to signin with their Google account because we used a Google signin API.  Once they login, the user will click on the type of event they'd be interested in, then they'd click on a specific event.  This will pull up specific information like the location, date, time, etc. We also have a feature where the user can click on a button that will take them to Google Maps if they need help finding where the event is taking place.  In the bottom right corner we give the user the option to star an event if they're interested in going to it. This will pull the information about the event and throw it under the "starred" event category so that it is easier to find the next time the user logs into the app.

## Organization of Repository:
The only branch you'll want to look at for our project to grade is this branch, the master. We have tagged this branch as v1 "Final Submission".  Everything you'll need will be here, such as: 

    Source code
    Test cases
    Auto-documenter documents
    Project Part 5 presentation slides
    Project Part 6 PDF

## To find Source Code:
### Java code
Click LetsGoApp2 -> app -> src -> main -> java/dachman/lucas/letsgoapp2

In java/dachman/lucas/letsgoapp2 you will see several .java files, some found in the three folders: fragments, adapters, and models.

### XML files

#### Android Manifest file
In main you will find the AndroidManifest.xml file:

Click LetsGoApp2 -> app -> src -> main

#### Other XML files
In the values/layout folder you will find other important XML files:

Click LetsGoApp2 -> app -> src -> main -> res -> values/layout

## To find test cases:
These should be found under the master branch, no need to search through folders.

The test cases you should look for are: 

    LoginUITest.java
    EventViewActivity.java
    LoginActivityTest.java
    
## To find Auto-Documenter documents:
These should also just be under the master branch, no need to search through folders.

The auto-documenter documents you should look for all end in .pdf, each .java file has one, including the test cases.

#### Please ignore the HTML files. Javadoc outputs in HTML, but Github only shows the raw HTML code. Refer to the files with extensions .pdf, those are the auto-documenter documents (besides LetsGo_Part_5.pdf and LetsGo_Part_6.pdf)

## To find the Team Project Part 5 presentation slides:
It should be called LetsGo_Part_5.pptx and LetsGo_Part_5.pdf (saved as .pptx & .pdf), and it is under this master branch. No need to search through folders. 

## How to test code:
You would have to install the framework Android Studio to run our code. Installing Android Studio's latest version, along with the necessary APKs for the Android emulator to run and test the code. You would also need to install an API level, at the very minimum, of lollipop or above. This is the link you could go to start the process: https://developer.android.com/studio/index.html.  When you enter Android Studio, you can choose to pull a project from VCS control.  You'll click this and then pull our project code from Github using this link : https://github.com/Computer-Girl/3308Project.git.  In order for this to work, you would need Git installed on your machine as well. 

## Thank you for reading! This is the end of the instructions. Below material is from Part 1 of this project, so please ignore. If you can't find something or have questions please e-mail me at jare8779@colorado.edu
##
##
##
##
##
##
# Team Project Part 1: 3308 Project

### Who: 

Jasmine Rethmann (Computer-Girl) Lucas Dachman (LucasDachman) Nihar Nandan (niharnandan) Jonathan Taing (taingj) Ningtian Ruan (niru32868)

### Title: 

Let's Go

### Description:

Android app that tells CU Boulder students about on-campus events, 
has an API to Google calendar to set reminders for user for an event they approved, 
API to Google maps that wil have a limited-mile radius off the Boulder campus with different places highlighted.  
User has to login with .edu email to verify they're a student, and once they're in they can invite other friends to events.

### Vision statement: 

Finding campus events made less crappier

### Motivation:

The motivation behind the project is to make it easier for students to get a quick overview of all events taking place around campus in a single place. There are many things happening around campus that a lot of students miss simply because they aren't aware of them.


### Risks:
  1. Teamates have never worked with each other.
  2. Limited knowledge of Java by some team members. 
  3. Some team members have never worked with Android Dev.
  4. Some team members don't know how to work with databases.

### Mitigating Risks:

In order to mitigate these risks, we split up the tasks in a way that each developer will have some experience in the task they are assigned to. Also, we will help each other learn new skills that are required for the project (Android, Java, Databases etc). 

### List of Requirements for the project:
* 1/U0001: As an end user, I want to be able to keep track of campus events categorically so that I can find events related to my domain. (6 hours) CRITICAL
* 2/U0002: As an end user, I want to be able to index my favourite events, so I can have a quick look at the events on the go. (8 hours)
* 3/U0003: As an end user, I want to options like resetting my password, and sharing the even via facebook or email, so I can let my friends know about the events easily. (5 hours) CRITICAL
* 4/A0001: As an event admin, I want versatility when it comes to event descriptions and locations to show precise locations, so people know that the event is exactly. (8 hours) CRITICAL
* 5/S0001: As a system admin, I should be able to grant the role of 'EVENT ADMIN' easily and to verify if the event admins are real, so as to prevent spam and creation of fake events. (8 hours)
* 6/S0002: As a system admin, I want automatic checks to the expiry of created events, so there is not a burden on the database with events not being taken off causing the app to be slow. (4 hours)

### Methodology: 

Most likely Agile

### Project Tracking Software: 

Github, Trello

### Project Plan:

![screenshot of github part1](https://cloud.githubusercontent.com/assets/18471032/23008147/fe133896-f3ca-11e6-9264-d80668e245c3.jpeg)

For tracking our project, we use Github to improve the project and share our code with teammates, professor and TAs. 

![screenshot of trello part1 1](https://cloud.githubusercontent.com/assets/18471032/23008377/5f062306-f3cc-11e6-8804-175ee1d4f5f4.jpeg)
![screenshot of trello part1 2](https://cloud.githubusercontent.com/assets/18471032/23008378/5f066438-f3cc-11e6-9115-04f1fbbadfcc.jpeg)

On the other hand, we use Trello to distribute different tasks to each member and check the process of our project.
