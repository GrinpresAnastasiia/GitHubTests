import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClassTest {
    private MainPage mainPage;
    private WebDriver driver;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com");
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void SignUpTest() {
        mainPage.clickSignUp();
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        String heading = signUpPage.getHeading();
        Assert.assertEquals("Join GitHub", heading);
    }

    @Test
    public void registerInvalidCreedsTest() {
        mainPage.clickSignIn();
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.register("jhfkj", "jfh");
        String error = signInPage.getErrorHeading();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void signInEmptyLoginTest() {
        mainPage.clickSignIn();
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.register("", "rfryf");
        String error = signInPage.getErrorHeading();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
