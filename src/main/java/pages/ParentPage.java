package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ParentPage {

    static WebDriver driver;
    static final Logger log = LoggerFactory.getLogger("PageLogger");

    ParentPage(WebDriver driver) {
        log.info("Initializing page elements on: {}", this.getClass().getName());
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
