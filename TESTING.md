Who: Ningtian Ruan, Jasmine Rethmann, Lucas Dachman, Jonathan Taing, Nihar Nandan

Title: Let's Go

Vision: Making it easier for students to find and participate in events on campus

Automated Tests: 

1. LoginUItest.java (Tests plain login and UI for functionality and visibility to user)

	Use case name:
		Test Login user interface (layout, buttons, functionality 
		available for user), and check to make sure the buttons
		accessed the next activity correctly.
	Description:
		Test the Login page
	Pre-conditions:
		User must have android device with API level around
		lollipop and must have app installed on device
	Test steps:
		1.Have layout present
		2.Have objects created and present for user
		3.Have correct functionality (i.e click button to continue)
	Expected result:
		User should be able to see the UI of the login screen, and
		should be able to navigate into main page of the app
	Actual result:
		User is able to completely see UI setup and navigate app
	Status:
		Pass
	Notes:
		We created this test case using the JUnit 
		framework integrated into Android Studio/Java libraries.
	Post-conditions:
		User is now setup with local database connection and able to
		access app's features after testing the login UI and functionality. 
	
2. EventViewActivityTest.java (Test functionality and navigation of EventView activity for user, along with UI)

	Use case name:
		Test Event View interface (layout, buttons, functionality
		available for user), and checks the navigation of this
		activity to the Maps API
	Description:
		Test the Event View page
	Pre-conditions:
		User must already be signed in and have access to local 
		database to check event view page for individual event
	Test steps:
		1.Have layout present
		2.Have objects created and present for user
		3.Have correct functionality (i.e click button to continue)
		4.Allow user to navigate from this activity to maps API
	Expected result:
		User should be able to see the UI of the event view screen, and
		should be able to navigate into the maps activity to view location of event.
	Actual result:
		User is able to completely see UI setup and navigate map API
	Status:
		Pass
	Notes:
		We created this test case using the JUnit 
		framework integrated into Android Studio/Java libraries.
	Post-conditions:
		User now has access to all event information from database
		and has correct permissions to view Google Maps.

3. <filename> (Test Google Sign-in API accessibility, navigation, and permissions for user) 
	
