## Project Overview

The purpose of this project is to demonstrate techniques for writing automated UI tests. The tests are based on the guidelines of the Page Object Model, and efforts have been made to externalize test data wherever possible.

### Tools Used

- **Operating System:** Windows 10 Home
- **Browser:** Chrome 120.0
- **IDE:** IntelliJ
- **Build Tool:** Maven
- **Testing Framework:** Selenium 4.13.0, Jupiter Release version
- **Assertion Library:** AssertJ 3.24.2
- **WebDriver Manager:** 5.5.3
- **Logging Framework:** SLF4J 2.17.0
- **The training site:** https://demoqa.com/

### Description of Tests

1. **TC01 - Page Title Verification:**
   - Verifies that the correct page title is displayed when the page loads.

2. **TC02 - Section Titles Verification:**
   - Verifies that the titles of six sections on the main page are displayed correctly when the page loads.

3. **TC03 - Data Listing from Section Titles:**
   - Lists the section titles on the page and saves them to an external file.

4. **TC04 - Text Box Data Entry from External File:**
   - Clicks on the Text Box in the Elements section to fill in data from an external file, then clicks Submit.

5. **TC05 - Check Box Selection:**
   - Clicks on the Check Box in the Elements section and selects the field.

6. **TC06 - Radio Button Selection Display:**
   - Selects a radio button, and verifies that the selection is displayed on the page.

7. **TC07 - Web Tables Placeholder Verification:**
   - Clicks on the Web Tables/Add button in the Elements section and verifies that the "First Name" placeholder appears in the First Name field.

8. **TC08 - Web Tables Data Entry from External File:**
   - Clicks on Web Tables in the Elements section to fill in data from an external file, then clicks Submit.

9. **TC09 - Web Tables Department Field Edit:**
   - Chooses Web Tables in the Elements section and edits the department field.

10. **TC10 - Double Click Confirmation:**
    - The user double clicks on a button and verifies that the correct message is received.

11. **TC11 - Right Click Confirmation:**
    - The user right clicks, and verifies that the correct message is received.

12. **TC12 - Alert Button Display:**
    - Clicks to see alert button and verifies that the correct message is displayed.

13. **TC13 - Delayed Alert Display:**
    - Clicks a button, and after 5 seconds, verifies that an alert appears.

14. **TC14 - Confirm Pop-Up Confirmation:**
    - Confirms a pop-up, and verifies that the alert box disappears, and the correct message is received.

15. **TC15 - Prompt Box Text Entry:**
    - Enters text in the prompt box, clicks OK in the pop-up window, and verifies that the confirmation message is displayed on the website.

16. **TC16 - Date Picker Date Selection:**
    - The user selects the date of 10 August 2010 from the date picker.

17. **TC17 - Dropdown Multi-Select Verification:**
    - The user selects two values from the dropdown menu, but the expected result would be only one.

### Running the Tests

Follow these steps to set up and execute the tests:

1. Clone the repository.
2. Open the project in IntelliJ.
3. Configure the necessary dependencies.
4. Run the tests using Maven.

