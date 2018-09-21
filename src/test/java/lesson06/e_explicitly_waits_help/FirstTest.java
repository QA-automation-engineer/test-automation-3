package lesson06.e_explicitly_waits_help;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.core.StringContains.containsString;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class FirstTest {

    static WebDriver wd;

    @BeforeClass
    public static void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().pageLoadTimeout(10, SECONDS);
//        wd.manage().timeouts().implicitlyWait(10, SECONDS);

        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().setSize(new Dimension(1920,1080));
    }

    @AfterClass
    public static void tearDown(){
        wd.quit();
    }

    @Test
    public void verifyFirstSearchResult() throws InterruptedException {
        wd.findElement(By.id("search_query_top")).click();
        wd.findElement(By.id("search_query_top")).sendKeys("Dress");

        (new WebDriverWait(wd,10))
                .until(textToBePresentInElementLocated(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"),
                        "Dress"));

        wd.findElement(By.id("search_query_top")).click();
        wd.findElement(By.id("search_query_top")).clear();
        wd.findElement(By.id("search_query_top")).sendKeys("T-shirt");

        (new WebDriverWait(wd,10))
                .until(textToBePresentInElementLocated(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"),
                        "T-shirt"));
    }
}