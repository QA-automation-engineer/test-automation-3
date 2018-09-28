package lesson08.f_smart_element_finders_and_po_refactor;

import org.junit.Test;

public class FirstTest extends BaseTest {

    @Test
    public void verifyFirstSearchResultShouldRefresh() {
        LandingPage landingPage = new LandingPage(wd);
        landingPage.visit();

        String query1 = "Dress";
        landingPage.searchFor(query1);
        landingPage.verifyFirstAdviceContainsText(query1);

        String query2 = "T-shirt";
        landingPage.searchFor(query2);
        landingPage.verifyFirstAdviceContainsText(query2);
    }
}