package lesson08.d_custom_expected_condition;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

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

    @Test
    public void verifyPageTitleWithDefaultCondition(){
        navigateTo("http://automationpractice.com/index.php?id_category=8&controller=category");
        assertThat(titleContains("Dresses"));
    }

    @Test
    public void verifyPageTitleWithCustomCondition(){
        navigateTo("http://automationpractice.com/index.php?id_category=8&controller=category");
        assertThat(new ExpectedCondition<Boolean>() {
            String expTitle = "Dresses1";
            String actTitle;
            @Override
            public Boolean apply(WebDriver webDriver) {
                actTitle = webDriver.getTitle();
                return actTitle.contains(expTitle);
            }

            @Override
            public String toString() {
                return String.format("Expected title should contain: '%s', but actual was: '%s'",expTitle, actTitle);
            }
        });
    }
}