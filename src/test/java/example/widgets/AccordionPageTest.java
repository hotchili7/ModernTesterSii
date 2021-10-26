package example.widgets;

import example.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AccordionPageTest extends BaseTest {

    private AccordionPage accordionPage;

    private final String textFromFirst = "Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.";
    private final String textFromSecond = "Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.";
    private final String textFromThird = "Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.";
    private final List<String> itemsFromThridElement = Arrays.asList("List item one", "List item two", "List item three");
    private final   String textFromFourth = "Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est.\n" +
            "\n" +
            "Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.";


    @BeforeMethod
    public void before() {
        driver.get("https://seleniumui.moderntester.pl/accordion.php");
        accordionPage = new AccordionPage(driver);
    }

    @Test
    public void test() {
        accordionPage.clickOnElementOnIndex("3");
    }

    @Test
    public void shouldReadTextOnSection(){
        String index = "2";

        System.out.println(accordionPage.getTextFromSectionOnIndex(index));
    }

    @Test
    public void shouldReadTextFromSecondSection() {
        String index = "2";
        accordionPage.clickOnElementOnIndex(index);

        String textFromSectionOnIndex = accordionPage.getTextFromSectionOnIndex(index);
        Assert.assertEquals(textFromSectionOnIndex, textFromSecond);

    }


 //   @Test
 //   public void shouldReadTextFromThridSection() {
  //      accordionPage.clickOnElementOnIndex("3");
  //      Assert.assertEquals(accordionPage.getItemsFromThridSection("3"), textFromThird);
  //      Assert.assertEquals(accordionPage.getItemsFromThridSection("3"), itemsFromThridElement);
  //  }


    @Test
    public void shouldReadTextFromFourthSection() {
        String index = "4";
        accordionPage.clickOnElementOnIndex(index);
        System.out.println(accordionPage.getTextFromFourthSection("4"));
        String textFromSectionOnIndex = accordionPage.getTextFromSectionOnIndex(index);
        Assert.assertEquals(textFromSectionOnIndex, textFromFourth);
    }

    @Test
    public void testAssertJ1() {
        accordionPage.verifyTextInGivenSection("1", textFromFirst);
    }

    @Test
    public void testAssertJ2() {
        accordionPage.clickOnElementOnIndex("2")
                .verifyTextInGivenSection("2", textFromSecond);
    }

}
