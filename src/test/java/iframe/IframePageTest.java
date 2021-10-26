package iframe;

import example.BaseTest;
import example.iframe.IframePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IframePageTest extends BaseTest {

    private IframePage iframePage;

    @BeforeMethod
    public void before() {
        driver.get("https://seleniumui.moderntester.pl/iframes.php");
        iframePage = new IframePage(driver);


    }

    @Test
    public void shouldCompleteFrame1Test()   {
        iframePage.completeIframe1("qwe", "fdsf");


    }

    @Test
    public void shouldCompleteIFrame2() {
//        iframePage.completeIFrame2("qwerty", "dsaq", 5);
        System.out.println(iframePage.getNumberOfYOEElements());
    }

    @Test
    public void numberOfUniqueElemensYOEshouldBe7() {
        assertEquals(iframePage.getNumberOfYOEElements(), iframePage.getSizeOfYOELabels());

    }

    @Test
    public void verifyIfNumberOfRepaeatedLabelsIs0() {
      assertEquals(iframePage.getRepeatedLabels().size(), 0);
    }

    @Test
    public void verifyTooltipFromIframe2() {
        assertEquals(iframePage.getTextFromIframeTooltip(), "Inline Frame Example 2");
    }

    @Test
    public void shouldReadTExtOnTooltip() {
        iframePage.hoverMouseOverElement(iframePage.iframe2);
        assertEquals(iframePage.getTextFromIframeTooltip(), "Inline Frame Example 2");
    }



}
