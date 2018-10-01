package lesson10.b_uploading_file;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class FirstTest extends BaseTest {

    @Test
    public void verifyLogin() throws Exception {
        navigateTo("https://www.google.com.ua/imghp?hl=uk&tab=wi");
        assertThat(titleContains("Google"));
        $(By.id("qbi")).click();
        $(By.linkText("Завантажте зображення")).click();
        $(By.id("qbfile")).sendKeys("C:\\Users\\vmuser\\IdeaProjects\\mystore\\128650_v9_bb.jpg");
        assertThat(textToBePresentInElementLocated(By.xpath("//*[@id=\"topstuff\"]/div/div[2]/a"), "jim carrey 2010"));
    }
}