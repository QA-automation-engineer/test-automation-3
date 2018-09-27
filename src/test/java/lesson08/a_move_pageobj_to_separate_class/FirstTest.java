package lesson08.a_move_pageobj_to_separate_class;

import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class FirstTest extends BaseTest {

    @Test
    public void verifyFirstSearchResultShouldRefresh() {
        String query1 = "Dress";
        String query2 = "T-shirt";
        LandingPage landingPage = new LandingPage(wd);
        landingPage.visit();

        landingPage.searchFor(query1);
        (new WebDriverWait(wd,10))
                .until(textToBePresentInElementLocated(landingPage.firstAdvice, query1));

        landingPage.searchFor(query2);
        (new WebDriverWait(wd,10))
                .until(textToBePresentInElementLocated(landingPage.firstAdvice, query2));
    }

}