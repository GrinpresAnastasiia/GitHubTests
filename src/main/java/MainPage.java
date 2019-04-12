import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[contains(@class,'HeaderMenu')]//a[contains(@data-ga-click,'Sign in')]")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//div[contains(@class,'HeaderMenu')]//a[contains(@data-ga-click,'Sign up')]")
    private WebElement buttonSignUp;



    public SignInPage clickSignIn() {
        buttonSignIn.click();
        return new SignInPage(driver);
    }

    public SignUpPage clickSignUp() {
        buttonSignUp.click();
        return new SignUpPage(driver);
    }


}
