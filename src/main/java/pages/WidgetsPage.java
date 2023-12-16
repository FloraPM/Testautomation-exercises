package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WidgetsPage extends ParentPage{

    @FindBy(xpath = "//*[@id=\"item-2\"]/span")
    private WebElement datePicker;

    @FindBy(id = "datePickerMonthYearInput")
    private WebElement selectDate;

    static final Logger log = LoggerFactory.getLogger(WidgetsPage.class);

    WidgetsPage(WebDriver driver) {
        super(driver);
    }

    public WidgetsPage clickToDatePicker() {
        datePicker.click();
        return this;
    }

    public void clickToSelectDate() {
        selectDate.click();
    }
}
