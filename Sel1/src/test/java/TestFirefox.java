import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.testng.Assert.assertTrue;

public class TestFirefox {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\Intellij\\geckodriver.exe");
        FirefoxOptions opts = new FirefoxOptions();
        opts.addArguments("-private");
        FirefoxDriver driver = new FirefoxDriver(opts);
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com/");
        HomePage home = new HomePage(driver);
        Login login = new Login(driver);

        Dashboard dashboard = new Dashboard(driver);

        home.clickAcceptCookies();
        Thread.sleep(3000);
        login.enterEmail("albertopololinares@gmail.com");
        login.enterPassword("Blancaesguapa");

        login.clickLoginFirefox();
        Thread.sleep(3000);
        dashboard.clickLogout();
        Thread.sleep(3000);

        driver.quit();
    }
}
