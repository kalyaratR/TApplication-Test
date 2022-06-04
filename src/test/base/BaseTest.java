package base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;
import utils.ExtentManager;

import java.util.concurrent.TimeUnit;

    public class BaseTest {
        private WebDriver driver;

        protected ExtentManager extentManager;
        private final String filePath = "src/test/config/configuration.properties";

        @BeforeSuite
        private void startReporter() {
            extentManager = new ExtentManager();
            extentManager.createReports();
        }
        @AfterSuite
        private void endReporter() {
            extentManager.closeReport();
        }

        @BeforeMethod
        public void setUp(){
            initializeDriver(ConfigReader.readProperty(filePath, "browser"));
            driver.get(ConfigReader.readProperty(filePath, "url"));
            //extentManager.createTestReport();
        }

        @AfterMethod
        public void tearDown(){
            driver.quit();
        }

        public void initializeDriver(String browser){
            driver = null;
            switch (browser.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    System.out.println("Wrong browser name was entered");
            }
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        public WebDriver getDriver(){

            return driver;
        }
    }


