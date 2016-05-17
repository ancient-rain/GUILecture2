Feature: DemoFeature
	As a professor, I want to share my research interests online.
	
@webdriver
Scenario: Mark Hays
	Given I am using Firefox
	When I view the CSSE faculty expertise page
	Then Mark Hays should have Software testing and quality assurance listed as an area of expertise.
