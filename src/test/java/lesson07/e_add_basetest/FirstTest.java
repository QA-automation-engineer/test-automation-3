package lesson07.e_add_basetest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class FirstTest extends BaseTest{

    @Test
    public void verifyFirstSearchResultShouldRefresh() {
        String query1 = "Dress";
        String query2 = "T-shirt";
        LandingPage landingPage = new LandingPage();

        landingPage.searchFor(query1);
        (new WebDriverWait(wd,10))
                .until(textToBePresentInElementLocated(landingPage.firstAdvice, query1));

        landingPage.searchFor(query2);
        (new WebDriverWait(wd,10))
                .until(textToBePresentInElementLocated(landingPage.firstAdvice, query2));
    }

    class LandingPage {

        By searchField = By.id("search_query_top");
        By firstAdvice = By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]");

        void searchFor(String query){
            $(searchField).click();
            $(searchField).clear();
            $(searchField).sendKeys(query);
        }

        WebElement $(By locator){
            return wd.findElement(locator);
        }
    }
}