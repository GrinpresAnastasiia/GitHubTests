import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='user[login]']")
    private WebElement userNameFiled;

    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement userEmailFiled;

    @FindBy(xpath = "//input[@id='user_password']")
    private WebElement userPasswordFiled;

    @FindBy(xpath = "//button[@id='signup_button']")
    private WebElement buttonCreateNewAcc;

    @FindBy(xpath = "//div[contains(@class,'setup-header setup-org')]//h1[contains(text(),'Join GitHub')]")
    private WebElement heading;

    @FindBy(xpath = "//div[@class='flash flash-error my-3']")
    private WebElement mainError;

    public SignUpPage typeName(String name) {
        userNameFiled.sendKeys(name);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        userEmailFiled.sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        userPasswordFiled.sendKeys(password);
        return this;
    }

    public SignUpPage clickCreateNAcc() {
        buttonCreateNewAcc.click();
        return this;
    }

    public SignUpPage createNewAcc(String name, String email, String password) {
        this.typeName(name);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickCreateNAcc();
        return new SignUpPage(driver);
    }

    public String getHeading() {
        return heading.getText();
    }

}
