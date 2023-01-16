Feature: Course information
   Scenario: Calling course info api with parameter
      Given we have access to url "https://app.pragra.io/"
      When We will call end point "/api/course/info/{id}" with id "6116c308df858e6d5ed1507b"
      Then We should have got status code of 200
      And Enrolled student should be "c931af06-3400-4824-8a57-8adb56c24bf9"
      And Total Modules should be "Pragra"
