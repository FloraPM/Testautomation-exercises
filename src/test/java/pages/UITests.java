package pages;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class UITests extends BaseTest {

    @Test
    @Description("TC01 - When the page loads, the page title is displayed correctly.")
    @DisplayName("Correct page title")
    public void TC01_pageTitleTest() {
        getHomePage();
        Assertions.assertEquals("DEMOQA", driver.getTitle());
        log.info("The title of the page is correct.");
    }

    @Test
    @Description("TC02 - When the page loads, the title of six sections on the main page are displayed correctly.")
    @DisplayName("Correct section titles")
    public void TC02_sectionTitlesTest() {
        log.info("List the titles");
        List<String> expectedTitleArr = Arrays.asList(new String[]{"Elements", "Forms", "Alerts, Frame & Windows",
                "Widgets", "Interactions", "Book Store Application"});
        List<String> sectionTitles = getHomePage().getSectionTitlesStr();

        Assertions.assertArrayEquals(expectedTitleArr.toArray(), sectionTitles.toArray());

        /*
        If we want to write to the console one by one:

        List<String> sectionTitles = getHomePage().getSectionTitlesStr();
        for (String title : sectionTitles) {
        System.out.println("Section Title: " + title);}
         */

    }

    @Test
    @Description("TC03 - Data listing from section titles on the page to an external file.")
    @DisplayName("Data list to an external file")
    public void TC03_writeToAnExternalFileTest() {
        List<String> sectionTitles = getHomePage().getSectionTitlesStr();
        try {
            FileWriter writer = new FileWriter("proba123.txt");
            for(String title : sectionTitles) {
                writer.write(title+ "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @ParameterizedTest
    @Description("TC04 - Click on the Text Box in the Elements section to fill in the data from an external file, then click Submit.")
    @DisplayName("Fill the Text Box from an external file")
    @CsvFileSource(resources = "/inputDataToTextBox")
    public void TC04_inputDatatoTextBoxTest(String fullname, String email, String address) {
        getElementsPage().clickToTextBox();
        ElementsPage elements = new ElementsPage(driver);
        elements.fillForm(fullname, email, address);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        By submitButton = By.id("submit");
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitButton));

        submit.click();

        Assertions.assertTrue(new ElementsPage(driver).isFormOutput());
    }

    @Test
    @Description("TC05 - The user clicks on the Check Box in the Elements section and select the field.")
    @DisplayName("Select the Check Box field")
    public void TC05_selectTheCheckBoxFieldTest() {
        getElementsPage().clickToCheckBox();
        ElementsPage elements = new ElementsPage(driver);
        elements.clickToCheckBoxField();

        Assertions.assertTrue(new ElementsPage(driver).isResultText());
    }

    @Test
    @Description("TC06 - When the user selects a radio button, the selection is displayed on the page.")
    @DisplayName("Radio button choice")
    public void TC06_radioButtonTest() {
        getElementsPage().clickToRadioButton().clickToRadioYes();
        Assertions.assertTrue(new ElementsPage(driver).isRadioYes());
    }

    @Test
    @Description("TC07 - When the user clicks on the Web Tables/Add button in the Elements section, the \"First Name\" " +
            "as placeholder appears in the First Name field.")
    @DisplayName("Elements\\Web Tables\\Add\\First Name field")
    public void TC07_firstNameFieldPlaceholderTest() {
        ElementsPage elements = getElementsPage().clickToWebTables().clickToWebTablesAdd();
        Assertions.assertEquals("First Name", elements.firstNameRegForm.getAttribute("placeholder"));
        log.info("Placeholder is OK.");
    }

    @ParameterizedTest
    @Description("TC08 - Click on the Web Tables in the Elements section to fill in the data from an external file, " +
            "then click Submit.")
    @DisplayName("Fill the Web Tables from an external file.")
    @CsvFileSource(resources = "/webTables.csv", numLinesToSkip = 1)
    public void TC08_inputDataToWebTableTest(String firstNameWebTables, String lastNameWebTables, String emailWebTables,
                                             String ageWebTables, String salaryWebTables, String departmentWebTables) {
        getElementsPage().clickToWebTables().clickToWebTablesAdd();
        ElementsPage elements = new ElementsPage(driver);
        elements.fillWebTablesAdd(firstNameWebTables, lastNameWebTables, emailWebTables, ageWebTables, salaryWebTables,
                departmentWebTables);

        /*
        Assertation:
        As the website is a training site, only the last registration is kept. So we cannot check them all at the same time.
         */
    }

    @Test
    @Description("TC09 - Choose the Web Tables in the Elements section and edit the department field.")
    @DisplayName("Department field change")
    public void TC09_departmentFieldChangeTest()  {
        ElementsPage elements = new ElementsPage(driver);
        getElementsPage().clickToWebTables();

        elements.clickToFirstRowEditor();

        elements.clickToDepartment().clearDepartment();
        elements.fillDepartment("QA");
        elements.clickToSubmitButtonRegForm();

        Assertions.assertEquals("QA", elements.getDepartmentText().getText());
    }

    @Test
    @Description("TC10 - The user double clicks on the button and he/she receives the correct message.")
    @DisplayName("Double click with message")
    public void TC10_doubleClickTest() {
        ElementsPage elements = new ElementsPage(driver);
        Actions actions = new Actions(driver);
        actions.doubleClick(getElementsPage().clickToButtonsField().getDoubleClickButton()).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        By doubleClickMessage = By.id("doubleClickMessage");
        WebElement doubleClick = wait.until(ExpectedConditions.visibilityOfElementLocated(doubleClickMessage));

        Assertions.assertEquals("You have done a double click", elements.getDoubleClickMeassage().getText());
    }

    @Test
    @Description("TC11 - The user clicks with the right mouse button and he/she receives the correct message.")
    @DisplayName("Right mouse button click")
    public void TC11_rightMouseButtonClickTest() {
        ElementsPage elements = new ElementsPage(driver);
        Actions actions = new Actions(driver);
        actions.contextClick(getElementsPage().clickToButtonsField().getRightClickButton()).perform();

        /*
        It is working without wait, but here is the method:

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        By rightClickMessage = By.id("rightClickMessage");
        WebElement rightClick = wait.until(ExpectedConditions.visibilityOfElementLocated(rightClickMessage));
        */

        Assertions.assertEquals("You have done a right click", elements.getRightClickMessage().getText());
    }

    @Test
    @Description("TC12 - When the user clicks to see alert button, then he/she receives the correct message.")
    @DisplayName("Alert message")
    public void TC12_alertMessageTest() {
        AlertsPage alerts = new AlertsPage(driver);
        getAlertsPage().clickToSeeAlertButton();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert message: " + alertText);

        Assertions.assertEquals("You clicked a button", alertText);
        log.info("You have received the confirmation message on the page.");
    }

    @Test
    @Description("TC13 - When the user clicks to the button, the alert will appear after 5 seconds.")
    @DisplayName("Alert after 5 seconds")
    public void TC13_alertAfter5SecTest() {
        AlertsPage alerts = new AlertsPage(driver);
        getAlertsPage().clickToTimeAlertButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        Alert timeAlert = wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        System.out.println("Alert message: " + alertText);
        Assertions.assertEquals("This alert appeared after 5 seconds", alertText);
    }

    @Test
    @Description("TC14 - When the user confirm the pop-up, the alert box dissapeared and he/she receives the correct message.")
    @DisplayName("Confirm the alert box")
    public void TC14_confirmTheAlertBoxTest() {
        AlertsPage alerts = new AlertsPage(driver);
        getAlertsPage().clickToConfirmButton();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assertions.assertTrue(new AlertsPage(driver).isConfirmResult());
    }

    @Test
    @Description("TC15 - After the user enters the text in the prompt box and clicks OK in the pop-up window, " +
            "the confirmation message is displayed on the website.")
    @DisplayName("Prompt box message")
    public void TC15_promptBoxMessageTest() {
        AlertsPage alerts = new AlertsPage(driver);
        getAlertsPage().clickToPromtButton();

        Alert alert = driver.switchTo().alert();
        String inputText = "John";
        alert.sendKeys(inputText);
        alert.accept();

        Assertions.assertTrue(new AlertsPage(driver).isPromptResult());
    }

    @Test
    @Description("TC16 - The user wants to select the date of 10 August 2010 from the date picker.")
    @DisplayName("Date handling")
    public void TC16_dateHandlingTest() {
        // Navigate to the page.
        WidgetsPage widgets = new WidgetsPage(driver);
        driver.get("https://demoqa.com/date-picker");
        driver.manage().window().maximize();
        widgets.clickToSelectDate();

        // We open the date picker.
        WebElement dropdownMonth = driver.findElement
                (By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
        Select select = new Select(dropdownMonth);

        // We find the months we need.
        WebElement month = select.getOptions().stream()
                .filter(option -> option.getText().equals("August"))
                .findFirst()
                .orElse(null);

        // When we find the item we are looking for, we click on it.
        if (month != null) {
            month.click();
        }

        // We select the year drop-down menu.
        WebElement dropdownYear = driver.findElement(By.xpath(
                "//*[@id='datePickerMonthYear']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));

        // Since the element we want to select is not visible, we need the moveToElement method of the Actions class.
        while (!driver.findElement(By.xpath(
                "//*[@id='datePickerMonthYear']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select/option[contains(text(), '2010')]"))
                .isDisplayed()) {
            new Actions(driver).moveToElement(dropdownYear).sendKeys(Keys.ARROW_DOWN).perform();
        }

        // Select the year and click on it.
        driver.findElement(By.xpath(
                "//*[@id='datePickerMonthYear']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select/option[contains(text(), '2010')]"))
                .click();

        // Choosing the day.
        WebElement day10 = driver.findElement(By.xpath(
                "//div[@class='react-datepicker__day react-datepicker__day--010' and contains(text(),'10')]"));
        day10.click();

        // We carry out the check.
        String selectDate = driver.findElement(By.xpath("//*[@id='datePickerMonthYearInput']"))
                .getAttribute("value");
        System.out.println(selectDate);
    }

    @Test
    @Description("TC17 - The user selects two values from the dropdown menu, but the expected result would be only one.")
    @DisplayName("Multiselect dropdown")
    public void TC17_multiSelectTest() {
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"selectMenuContainer\"]/div[7]/div/div"));
        dropdown.click();

        // Select a value
        WebElement green = driver.findElement(By.xpath("//div[text()='Green']"));
        green.click();

        // Select another value
        WebElement blue = driver.findElement(By.xpath("//div[text()='Blue']"));
        blue.click();

        WebElement selectedValue = driver.findElement(By.xpath("//*[@id=\"selectMenuContainer\"]/div[7]/div/div"));
        String actualValue = selectedValue.getText();
        Assertions.assertEquals("Green", actualValue);
    }

}