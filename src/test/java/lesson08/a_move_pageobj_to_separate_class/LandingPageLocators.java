package lesson08.a_move_pageobj_to_separate_class;

import org.openqa.selenium.By;

public interface LandingPageLocators {
    By searchField = By.id("search_query_top");
    By firstAdvice = By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]");
}
