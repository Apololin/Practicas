import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HomePage {

    WebDriver driver;


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    By AcceptCookies = By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div[3]/button[2]");
    @Test
    public void clickAcceptCookies(){
        driver.findElement(AcceptCookies).click();
    }

}
