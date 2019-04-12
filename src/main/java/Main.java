import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://github.com");

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickSignIn();
        SignInPage signInPage = PageFactory.initElements(driver,SignInPage.class);
        signInPage.register("df", "dfh");
        String error = signInPage.getErrorHeading();
        System.out.println(error);

    }
}
