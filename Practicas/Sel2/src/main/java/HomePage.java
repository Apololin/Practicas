import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.lang.Thread.sleep;

public class HomePage {
    WebDriver driver;
    By tutorial = By.cssSelector(".navbar__tutorial-menu--text");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String listMenu(){
        String nombres = null;
        WebElement dropDown = driver.findElement( By.cssSelector( ".//.navbar__tutorial-menu--text" ) );
        dropDown.click();
        List<WebElement> allOptions = dropDown.findElements(By.cssSelector(".first-generation"));
        for (int i =0;i<allOptions.size();i++){
            nombres += allOptions.get(i).getText();
        }
        return nombres;
    }

    public void getSocial(){
        String facebook,twitter,youtube,linkedin = null;
        facebook = driver.findElement(By.cssSelector("a[href='https://www.facebook.com/tools.qa']")).getAttribute("href");
        twitter = driver.findElement(By.cssSelector("a[href='https://twitter.com/toolsqa']")).getAttribute("href");
        youtube =driver.findElement(By.cssSelector("a[href='https://www.facebook.com/tools.qa']")).getAttribute("href");
        linkedin = driver.findElement(By.cssSelector("footer div:nth-child(5) a:nth-child(1)")).getAttribute("href");
        System.out.println(facebook);
        System.out.println(twitter);
        System.out.println(youtube);
        System.out.println(linkedin);
    }

    public void search(){
        driver.findElement(By.cssSelector("input[class='navbar__search--input']")).click();
        WebElement buscador =driver.findElement(By.cssSelector("input[class='navbar__search--input']"));
        buscador.sendKeys("postman");
        buscador.sendKeys(Keys.ENTER);
    }
}
