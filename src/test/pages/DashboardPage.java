package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {
    protected WebDriver driver;

    public DashboardPage(WebDriver driver) {
            super(driver);
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        @FindBy(linkText = "Access DB")
        public WebElement accessDbBtn;

        @FindBy(xpath = " //input[@id='Firstname']")
        public WebElement firstName;

        @FindBy(id = "Lastname")
        public WebElement lastName;

        @FindBy(id = "Phonenumber")
        public WebElement phoneNumber;

        @FindBy(id = "Email")
        public WebElement email;

        @FindBy(id = "Select-role")
        public WebElement roleSelect;

        @FindBy(id = "submit-btn")
        public WebElement submitBtn;

        @FindBy(id = "submit-table-btn")
        public WebElement submitTableBtn;

        @FindBy(xpath = "(//table//tr)[last()]")
        public WebElement lastUser;

    }
