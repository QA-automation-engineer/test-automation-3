package lesson10.a_file_downloading;

import de.redsix.pdfcompare.PdfComparator;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.hamcrest.CoreMatchers.is;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class FirstTest extends BaseTest {


    LoginPage loginPage = new LoginPage(webDriver);

    @Test
    public void verifyLogin() throws Exception {
        loginPage.visit();
        assertThat(titleContains("Login"));
        loginPage.login();
        assertThat(titleContains("My account"));

        $(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]")).click();
        assertThat(titleContains("Order history"));
        FileDownloader fileDownloader = new FileDownloader(webDriver);
        fileDownloader.setURI($(By.xpath("//*[@id=\"order-list\"]/tbody/tr[2]/td[6]/a")).getAttribute("href"));
        File actualFile = fileDownloader.downloadFile();
        int httpStatusCode = fileDownloader.getLastDownloadHTTPStatus();
        Assert.assertThat("Check status.", httpStatusCode, is(200));
        Assert.assertThat(new PdfComparator(new File("IN019477.pdf"), actualFile)
                .compare().writeTo("diffOutputPass"), is(true));
    }
}