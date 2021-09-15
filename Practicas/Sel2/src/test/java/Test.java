import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {
    public static void main(String[] args) {
        ChromeOptions o= new ChromeOptions();
        o.addArguments("−−incognito");
        o.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "C:\\Intellij\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(o);
        driver.get("https://www.toolsqa.com/");
        HomePage home = new HomePage(driver);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        home.getSocial();
        home.search();
        //System.out.println(home.listMenu());
    }
}
