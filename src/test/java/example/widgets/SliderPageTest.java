package example.widgets;

import example.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderPageTest extends BaseTest {

    private SliderPage sliderPage;

    @BeforeMethod
    public void before() {
        driver.get("https://seleniumui.moderntester.pl/slider.php");
        sliderPage = new SliderPage(driver);

    }

    @Test
    public void test() {

        sliderPage.moveToPosition(50);
        Assert.assertEquals(sliderPage.getCurrentPosition(),50 );
        sliderPage.moveToPosition(30);
        Assert.assertEquals(sliderPage.getCurrentPosition(),30 );
        sliderPage.moveToPosition(100);
        Assert.assertEquals(sliderPage.getCurrentPosition(),100 );
        sliderPage.moveToPosition(10);
        Assert.assertEquals(sliderPage.getCurrentPosition(),10 );
        sliderPage.moveToPosition(55);
        Assert.assertEquals(sliderPage.getCurrentPosition(),55 );

    }

    @Test
    public void test1() {
        sliderPage.verifyThat(2)
                .verifyThat(50);

    }

}
