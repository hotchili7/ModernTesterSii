package example.media_expert;

import example.BaseTest;
import example.interactions.ResizeablePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MediaExpertPageTest extends BaseTest {

    private MediaExpertPage mediaExpertPage;

    @BeforeMethod
    public void before() {
        driver.get("https://www.mediaexpert.pl/");
        mediaExpertPage = new MediaExpertPage(driver);

    }

    @Test
    public void test(){
        System.out.println(mediaExpertPage.getNames());
    }


    @Test
    public void shouldOpenPageAnfMoveToElement() {
        mediaExpertPage.closeCookies();
        mediaExpertPage.hoverOverRoweryButton()
                .moveToElementOnPage();
    }



}
