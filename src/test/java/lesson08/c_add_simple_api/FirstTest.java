package lesson08.c_add_simple_api;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class FirstTest extends BaseTest {

    @Test
    public void verifyFirstSearchResultShouldRefresh() {
        String query1 = "Dress";
        String query2 = "T-shirt";
        LandingPage landingPage = new LandingPage(wd);
        landingPage.visit();

        landingPage.searchFor(query1);
        assertThat(textToBePresentInElementLocated(landingPage.firstAdvice, query1));

        landingPage.searchFor(query2);
        assertThat(textToBePresentInElementLocated(landingPage.firstAdvice, query2), 15);
    }
}