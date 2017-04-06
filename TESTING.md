****TESTING.md****

****We used the JUnit framework and Espresso to develop test cases for the app in Android Studio****


**Who:** Ningtian Ruan, Jasmine Rethmann, Lucas Dachman, Jonathan Taing, Nihar Nandan

**Title:** Let's Go

**Vision:** Making it easier for students to find and participate in events on campus

**Automated Tests:** 

**1. LoginUItest.java (Tests plain login and UI for functionality and visibility to user)**

	1. Use case name:
	
		Test Login user interface (layout, buttons, functionality 
		available for user, visibility of screen to user), and check 
		to make sure the buttons accessed the next activity correctly to aid
		the navigation of the user.
	
	2. Description:
	
		Test the Login page UI and functionality.
	
	3. Pre-conditions:
	
		User must have android device with API level around
		lollipop and must have app installed on device.
	
	4. Test steps:
	
		1.Have layout present
		
		2.Have objects created and present for user
		
		3.Have correct functionality (i.e click button to continue)
		
		4.Allow for navigation to next sequential activity
	
	5. Expected result:
	
		User should be able to see the UI of the login screen, and
		should be able to navigate into main page of the app.
	
	6. Actual result:
	
		User is able to completely see UI setup and the next activity
		is present and accessed correctly.
	
	7. Status:
	
		Pass
	
	8. Notes:
	
		Created this test case using the JUnit 
		framework integrated into Android Studio/Java libraries.
	
	9. Post-conditions:
	
		User is now setup with local database connection and able to
		access app's features after testing the login UI and functionality. 
	
	10. Screenshot:
	
		Shows that when ran through Android Studio's emulator, all tests passed for LoginUITest.java.
![logintestpass](https://cloud.githubusercontent.com/assets/25499591/24745327/88ed622a-1a72-11e7-8ad1-479ce4b8d14d.PNG)
		
	

**2. EventViewActivityTest.java (Test functionality and navigation of EventView activity for user, along with UI)**

	1. Use case name:
		Test Event View interface (layout, buttons, functionality
		available for user, visibility for the user), and checks 
		the navigation of this activity to the Maps API.
	
	2. Description:
		Test the Event View page and it's functionality.
	
	3. Pre-conditions:
		User must already be signed in and have access to local 
		database to check event view page for an individual event.
	
	4. Test steps:
		1.Have layout present
		2.Have objects created and present for user
		3.Have correct functionality (i.e click button to continue)
		4.Allow user to navigate from this activity to maps API
		5.Maps API must exist and be successfully connected to
	
	5. Expected result:
		User should be able to see the UI of the event view screen, and
		should be able to navigate into the maps activity to view location of an event.
	
	6. Actual result:
		User is able to completely see UI setup and navigate map API.
	
	7. Status:
		Pass
	
	8. Notes:
		Created this test case using the JUnit 
		framework integrated into Android Studio/Java libraries.
	
	9. Post-conditions:
		User now has access to all event information from database
		and has correct permissions to view Google Maps.
	
	10. Screenshot:
		Shows that when ran through Android Studio's emulator, all tests passed for EventViewActivityTest.java.
![eventviewactivitypass](https://cloud.githubusercontent.com/assets/25499591/24745348/a26360b0-1a72-11e7-9c39-b65e3cc2642f.PNG)



**3. LoginActivityTest.java (A test to demonstrate basic user login and log out functionality using Espresso Test Recorder, a UI testing tool provided by Android Studio. It provides an alternative to tradional testing implementatons, providing conconvenience but at the cost of in-depth testing procedures)**

	1. Use case name:
                Verify successful login through Google login

	2. Description:
                Test the Google login button with navigation into the app's
		main activity, and sign out from app's main activity back
		to the login page.
	
	3. Pre-conditions:
		User has valid Google account. If not, the user is prompted
		to create one.

	4. Test steps:
		1. Click login button
		2. Navigate to login page
		3. Select existing account.
		4. Navigate to app's main activity.
		5. Click Signout button in app's menu overflow toolbar.
	
	5. Expected result:
		User should be able to navigate to app's main activity.
		Upon signing out from app's main activity, user should
		be navigated back to the login page.

	6. Actual result:
		User is navigated to app's main activity. From the main
		activity, user is navigated back to the login page after
		signing out.
	
	7. Status (Pass/Fail):
		Pass

	8. Screenshot:
	
		N/A

	9. Post-conditions
		User has successfully traversed through to the main activity
		from the login activity and back.

	10. Screenshot:
		Shows a successful completion of basic UI login/logout functionality
		as an instrumated test. In other words, it tested under the conditions 
		of android's Virtual Hardware Device platform.


