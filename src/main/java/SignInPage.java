import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='login_field']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//div[@class='flash flash-full flash-error']")
    private WebElement errorHeading;

    public SignInPage typeUserEmail(String userEmail) {
       // WebDriverWait wait = new WebDriverWait(driver, 5);
      //  wait.until(ExpectedConditions.presenceOfElementLocated((By) userEmailField));
        userEmailField.sendKeys(userEmail);
        return this;
    }

    public SignInPage typeUserPasswrod(String userPassword) {
       // WebDriverWait wait = new WebDriverWait(driver, 5);
      //  wait.until(ExpectedConditions.presenceOfElementLocated((By) userPasswordField));
        userPasswordField.sendKeys(userPassword);
        return this;
    }

    public SignInPage clickSignIn() {
        buttonSignIn.click();
        return this;
    }

    public String getErrorHeading() {
        return errorHeading.getText();
    }

    public SignInPage register(String email, String password) {
        this.typeUserEmail(email);
        this.typeUserPasswrod(password);
        this.clickSignIn();
        return new SignInPage(driver);
    }
}
