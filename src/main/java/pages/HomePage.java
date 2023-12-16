package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends ParentPage {


    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[3]/h5")
    private WebElement elements;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div/div[3]/h5")
    private WebElement forms;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div/div[3]/h5")
    private WebElement alertsFrameWindows;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[4]/div/div[3]/h5")
    private WebElement widgets;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[5]/div/div[3]/h5")
    private WebElement interactions;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[6]/div/div[3]/h5")
    private WebElement bookStoreApplication;

    @FindBy(css = "[class=\"card-body\"]")
    private List<WebElement> sectionTitles;



    static final Logger log = LoggerFactory.getLogger(HomePage.class);

    HomePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSectionTitles() {
        return sectionTitles;
    }

    public List<String> getSectionTitlesStr() {
        log.info("Get post titles string");
        return sectionTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickToElements() {
        elements.click();
    }



    public WebElement getElements() {
        return elements;
    }

    public WebElement getForms() {
        return forms;
    }
}
