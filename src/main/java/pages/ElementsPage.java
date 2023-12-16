package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.plugin.dom.core.Element;

public class ElementsPage extends ParentPage {


    @FindBy(xpath = "//*[@id=\"item-0\"]/span")
    private WebElement textBox;
    @FindBy(xpath = "//*[@id=\"userName\"]")
    private WebElement fullName;
    private String fullname;

    @FindBy(xpath = "//*[@id=\"userEmail\"]")
    private WebElement emails;
    private String email;

    @FindBy(xpath = "//*[@id=\"currentAddress\"]")
    private WebElement currentAddress;
    private String address;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(xpath = "//*[@id=\"output\"]/div")
    private WebElement formOutput;

    @FindBy(xpath = "//*[@id=\"item-1\"]")
    private WebElement checkBox;

    @FindBy(css = "[class=\"rct-checkbox\"]")
    private WebElement checkBoxField;


    @FindBy(id = "result")
    private WebElement resultText;

    @FindBy(xpath = "//*[@id=\"item-2\"]/span")
    private WebElement radioButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label")
    private WebElement radioYes;

    @FindBy(xpath = "//*[@id=\"item-3\"]/span")
    private WebElement webTables;

    @FindBy(id = "addNewRecordButton")
    private WebElement addWebTables;

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    WebElement firstNameRegForm;
    private String firstNameWebTables;


    @FindBy(xpath = "//*[@id=\"lastName\"]")
    private WebElement lastNameRegForm;
    private String lastNameWebTables;

    @FindBy(xpath = "//*[@id=\"userEmail\"]")
    private WebElement emailRegForm;
    private String emailWebTables;

    @FindBy(xpath = "//*[@id=\"age\"]")
    private WebElement ageRegForm;
    private String ageWebTables;

    @FindBy(xpath = "//*[@id=\"salary\"]")
    private WebElement salaryRegForm;
    private String salaryWebTables;

    @FindBy(xpath = "//*[@id=\"department\"]")
    private WebElement departmentRegForm;
    private String departmentWebTables;

    @FindBy(xpath = "//*[@id=\"submit\"]")
    private WebElement submitButtonRegForm;

    @FindBy(xpath = "//*[@id=\"edit-record-1\"]")
    private WebElement firstRowEditor;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[6]")
    private WebElement departmentText;

    @FindBy(xpath = "//*[@id=\"item-4\"]/span")
    private WebElement buttons;

    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickButton;

    @FindBy(id = "doubleClickMessage")
    private WebElement doubleClickMeassage;


    @FindBy(id = "rightClickBtn")
    private WebElement rightClickButton;


    @FindBy(id = "rightClickMessage")
    private WebElement rightClickMessage;



    static final Logger log = LoggerFactory.getLogger(ElementsPage.class);

    ElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickToTextBox() {
        textBox.click();
    }

    public void fillFullName(String fullname) {
        this.fullname = fullname;
        fullName.sendKeys(fullname);
    }

    public void fillEmail(String email) {
        this.email = email;
        emails.sendKeys(email);
    }

    public void fillCurrentAddress(String address) {
        this.address = address;
        currentAddress.sendKeys(address);
    }

    public void fillForm(String fullname, String email, String address) {
        this.fullname = fullname;
        this.email = email;
        this.address = address;

        fullName.sendKeys(fullname);
        emails.sendKeys(email);
        currentAddress.sendKeys(address);
    }

    public boolean isFormOutput() {
        return formOutput.isDisplayed();
    }

    public void clickToCheckBox() {
        checkBox.click();
    }

    public void clickToCheckBoxField() {
        checkBoxField.click();
    }

    public boolean isResultText() {
        return resultText.isDisplayed();
    }

    public ElementsPage clickToRadioButton() {
        radioButton.click();
        return this;
    }

    public ElementsPage clickToRadioYes() {
        radioYes.click();
        return this;
    }

    public boolean isRadioYes() {
        return radioYes.isDisplayed();
    }

    public ElementsPage clickToWebTables() {
        webTables.click();
        return this;
    }

    public ElementsPage clickToWebTablesAdd() {
        addWebTables.click();
        return this;
    }

    public String firstNameRegFormText() {
        return firstNameRegForm.getText();
    }

    public void fillWebTablesAdd(String firstNameWebTables, String lastNameWebTables, String emailWebTables,
                                 String ageWebTables, String salaryWebTables, String departmentWebTables) {
        this.firstNameWebTables = firstNameWebTables;
        this.lastNameWebTables = lastNameWebTables;
        this.emailWebTables = emailWebTables;
        this.ageWebTables = ageWebTables;
        this.salaryWebTables = salaryWebTables;
        this.departmentWebTables = departmentWebTables;

        firstNameRegForm.sendKeys(firstNameWebTables);
        lastNameRegForm.sendKeys(lastNameWebTables);
        emailRegForm.sendKeys(emailWebTables);
        ageRegForm.sendKeys(ageWebTables);
        salaryRegForm.sendKeys(salaryWebTables);
        departmentRegForm.sendKeys(departmentWebTables);

        submitButtonRegForm.click();
    }

    public ElementsPage clickToSubmitButtonRegForm() {
        submitButtonRegForm.click();
        return this;
    }

    public ElementsPage clickToFirstRowEditor() {
        firstRowEditor.click();
        return this;
    }

    public ElementsPage clickToDepartment() {
        departmentRegForm.click();
        return this;
    }

    public void clearDepartment() {
        departmentRegForm.clear();
    }

    public void fillDepartment(String department) {
        this.departmentRegForm = departmentRegForm;
        departmentRegForm.sendKeys(department);
    }

    public WebElement getDepartmentText() {
        return departmentText;
    }

    public ElementsPage clickToButtonsField() {
        buttons.click();
        return this;
    }

    public WebElement getDoubleClickButton() {
        return doubleClickButton;
    }

    public WebElement getDoubleClickMeassage() {
        return doubleClickMeassage;
    }

    /*

    public boolean isDoubleCickMessageVisible() {
        return doubleClickMeassage.isDisplayed();
    }

     */

    public WebElement getRightClickButton() {
        return rightClickButton;
    }

    public WebElement getRightClickMessage() {
        return rightClickMessage;
    }

}
