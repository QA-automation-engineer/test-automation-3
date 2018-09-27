package lesson08.e_custom_contidions_in_separate_class.d_custom_expected_condition;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static org.hamcrest.core.Is.is;
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
        assertThat(MyExpectedCondition.pageTitleContainsText("Dresses"), 10 );
    }

    @Test
    public void verifyLeftBar(){
        navigateTo("http://automationpractice.com/index.php?id_category=8&controller=category");
        Assert.assertThat(waitFor(
                MyExpectedCondition.firstListItemContainsTest(By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li/a"),"Casual")).size(),
                is(3));

    }

}