package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlertsPage extends ParentPage{

    @FindBy(xpath = "//*[@id=\"alertButton\"]")
    private WebElement seeAlertButton;

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmButton;

    @FindBy(id = "confirmResult")
    private WebElement confirmResult;

    @FindBy(id = "promtButton")
    private WebElement promtButton;

    @FindBy(id = "promptResult")
    private WebElement promptResult;

    static final Logger log = LoggerFactory.getLogger(AlertsPage.class);

    AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void clickToSeeAlertButton() {
        seeAlertButton.click();
    }

    public void clickToTimeAlertButton() {
        timerAlertButton.click();
    }

    public void clickToConfirmButton() {
        confirmButton.click();
    }

    public boolean isConfirmResult() {
        return confirmResult.isDisplayed();
    }

    public void clickToPromtButton() {
        promtButton.click();
    }

    public boolean isPromptResult() {
        return promptResult.isDisplayed();
    }
}
