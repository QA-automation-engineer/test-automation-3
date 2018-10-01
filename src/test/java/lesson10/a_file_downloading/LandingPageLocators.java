package lesson10.a_file_downloading;

import org.openqa.selenium.By;

public interface LandingPageLocators {
    By searchField = By.id("search_query_top");
    By firstAdvice = By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]");
}
