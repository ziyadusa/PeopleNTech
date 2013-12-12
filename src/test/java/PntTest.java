/**
 * Created with IntelliJ IDEA.
 * User: Mohammed Z. Azam
 * Date: 12/9/13
 * Time: 10:39 PM
 * To change this template use File | Settings | File Templates.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
public class PntTest {

    WebDriver driver = null;
    String username = "mzazam";
    String password = "054782550010767";

    @Before
    public void setUp() throws Exception {

        //DesiredCapabilities capabillities = DesiredCapabilities.iphone();
        DesiredCapabilities capabillities = DesiredCapabilities.firefox();
        capabillities.setCapability("version", "17");
        capabillities.setCapability("platform", Platform.XP);
        this.driver = new RemoteWebDriver(
                new URL("http://mzazam07:ff0ecc19-2836-4fd7-aa99-42752d74aa10@ondemand.saucelabs.com:80/wd/hub"),
                capabillities);
    }

    public void doLogin() {
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("passwrd")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='frmLogin']/table/tbody/tr/td/table/tbody/tr[3]/td/input")).click();
    }

    @Test
    public void searchWeb() throws InterruptedException {
        driver.get("http://peoplentech.com/");
        doLogin();
        Thread.sleep(30);
        WebElement member_link = driver.findElement(By.xpath("//*[@id='button_mlist']/a/span"));
        Actions builder = new Actions(driver);
        Action mouseOverLive = builder
                .moveToElement(member_link)
                .build();
        mouseOverLive.perform();
        Thread.sleep(30);
        driver.findElement(By.xpath("//*[@id='button_mlist']/a/span")).click();
        driver.findElement(By.xpath("//*[@id='memberlist']/div[2]/div[1]/ul/li[2]/a/span")).click();
        driver.findElement(By.xpath("//*[@id='search_term_input']/input[1]")).sendKeys("mohammedzazam@aol.com");
        driver.findElement(By.xpath("//*[@id='search_term_input']/input[2]")).click();
        WebElement registerdDate = driver.findElement(By.xpath("//*[@id='mlist']/table/tbody/tr/td[10]"));
        String regDate = registerdDate.getText();

    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}

