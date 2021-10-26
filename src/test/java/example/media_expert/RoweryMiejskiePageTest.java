package example.media_expert;

import example.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RoweryMiejskiePageTest extends BaseTest {

    private RoweryMiejskiePage roweryMiejskiePage;

    @BeforeMethod
    public void before() {
        driver.get("https://www.mediaexpert.pl/rowery/rowery-miejskie");
        roweryMiejskiePage = new RoweryMiejskiePage(driver);
    }


    @Test
    public void test() {
        roweryMiejskiePage.closeCookies();
        System.out.println(roweryMiejskiePage.getListOfBikes());
    }

    @Test
    public void test1() {
        Assert.assertEquals(roweryMiejskiePage.getListOfBikes().size(), 30);

    }





}
