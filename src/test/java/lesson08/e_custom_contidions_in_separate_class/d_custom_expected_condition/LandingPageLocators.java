package lesson08.e_custom_contidions_in_separate_class.d_custom_expected_condition;

import org.openqa.selenium.By;

public interface LandingPageLocators {
    By searchField = By.id("search_query_top");
    By firstAdvice = By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]");
}
