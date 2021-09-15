import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver){
        this.driver = driver;
    }

    By uEmail = By.xpath("(//input[@id='email'])[2]");
    By uPassword = By.xpath("(//input[@id='pass'])[2]");
    By uEmail2 = By.xpath("//*[@id=\"email\"]");
    By uPassword2 = By.xpath("//*[@id=\"pass\"]");
    By loginBtn = By.xpath("//*[@id=\"loginbutton\"]");
    By loginBtnFireFox = By.id("loginbutton");

    @Test
    public void enterEmail(String email){

        driver.findElement(uEmail2).sendKeys(email);
    }
    @Test
    public void enterPassword(String pass){
        driver.findElement(uPassword2).sendKeys(pass);
    }
    @Test
    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }
    public void clickLoginFirefox(){
        driver.findElement(loginBtnFireFox).click();
    }
}
