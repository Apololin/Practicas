import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Dashboard {

    WebDriver driver;
    public Dashboard(WebDriver driver){
        this.driver = driver;
    }

    By imagenFb = By.cssSelector(".qv66sw1b:nth-child(2) > .a8c37x1j");
    By menuBtn = By.cssSelector("div[aria-label='Cuenta'][role='button']");

    By logoutBtn = By.cssSelector("div:nth-child(4) > .oajrlxb2 > .ow4ym5g4");
    By emailBox = By.xpath("//*[@id=\"email\"]");
    By heading = By.xpath("//div[@class=\"main-header\"]");
    @Test
    public String getImagenFb(){
        String imagen = driver.findElement(imagenFb).getText();
        return imagen;
    }
    @Test
    public void clickLogout(){
        driver.findElement(menuBtn).click();
        driver.findElement(logoutBtn).click();
    }
    @Test
    public String checkLogout(){
        String check = driver.findElement(emailBox).getText();
        return check;
    }
    @Test
    public String getHeading(){
        String head = driver.findElement(heading).getText();
        return head;
    }
}
