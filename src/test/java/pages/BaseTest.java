package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    static WebDriver driver;
    static String hostUrl;
    static String elementsUrl;
    static String alertsUrl;
    static String widgetsUrl;


    static final Logger log = LoggerFactory.getLogger("TestLogger");

    @BeforeEach
    public void setup() {
        setUpProperties();
        browserDriverSetup();
    }
    /*
    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
    */


    public void setUpProperties() {

        Properties properties = new Properties();
        try {
            log.info("Setting up properties from: config.properties");
            FileInputStream input = new FileInputStream("src/test/resources/config.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        hostUrl = properties.getProperty("base.url");
        elementsUrl = properties.getProperty("elements.url");
        alertsUrl = properties.getProperty("alerts.url");
        widgetsUrl = properties.getProperty("widgets.url");
    }

    public void browserDriverSetup() {
        log.info("Setting up Chromedriver with option: --remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    public HomePage getHomePage() {
        log.info("Opening host url: {}", hostUrl);
        driver.manage().window().maximize();
        driver.get(hostUrl);
        return new HomePage(driver);
    }

    public ElementsPage getElementsPage() {
        log.info("Opening elements url: {}", elementsUrl);
        driver.manage().window().maximize();
        driver.get(elementsUrl);
        return new ElementsPage(driver);
    }

    public AlertsPage getAlertsPage() {
        log.info("Opening alerts url: {}", alertsUrl);
        driver.manage().window().maximize();
        driver.get(alertsUrl);
        return new AlertsPage(driver);
    }

    public WidgetsPage getWidgetsPage() {
        log.info("Opening widgets url: {}", widgetsUrl);
        driver.manage().window().maximize();
        driver.get(widgetsUrl);
        return new WidgetsPage(driver);
    }
}
