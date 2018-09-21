package lesson06.a_cry_without_waits;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.StringContains.containsString;

public class FirstTest {

    static WebDriver wd;

    @BeforeClass
    public static void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        wd.quit();
    }

    @Test
    public void verifyFirstSearchResult(){
        wd.findElement(By.id("search_query_top")).click();
        wd.findElement(By.id("search_query_top")).sendKeys("Dress");

        Assert.assertThat(wd.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"))
                .getText(),containsString("Dress"));
    }
}