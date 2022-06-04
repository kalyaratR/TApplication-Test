package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
public class HomePage extends BasePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "php-travels")
    public WebElement phpTravelsLink;

    @FindBy(id = "mercury-tours")
    public WebElement mercuryToursLink;

    @FindBy(id = "internet")
    public WebElement internetLink;

    @FindBy(id = "e-commerce")
    public WebElement ecommerceLink;

    @FindBy(id = "passion-tea-company")
    public WebElement passionTeaCompanyLink;

    @FindBy(id = "sauce-demo")
    public WebElement sauceDemoLink;

    @FindBy(id = "shopping-cart")
    public WebElement shoppingCartLink;


}