import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.testng.Assert.assertTrue;

public class Test {


    public static void main(String[] args) throws InterruptedException {

        ChromeOptions o= new ChromeOptions();
        o.addArguments("−−incognito");
        o.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "C:\\Intellij\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(o);
        driver.get("https://www.facebook.com/loggin");
        HomePage home = new HomePage(driver);
        Login login = new Login(driver);

        Dashboard dashboard = new Dashboard(driver);

        home.clickAcceptCookies();
        Thread.sleep(3000);
        login.enterEmail("albertopololinares@gmail.com");
        login.enterPassword("Blancaesguapa");

        login.clickLogin();
        Thread.sleep(3000);
        /*String titulo = null;
        titulo = dashboard.getImagenFb();
        boolean verifyLogin = false;
        if (titulo != null){
            verifyLogin = true;
        }

        assertTrue(verifyLogin);
*/
        dashboard.clickLogout();
        Thread.sleep(3000);

        driver.quit();
    }
}
