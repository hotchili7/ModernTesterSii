package example.widgets;

import example.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutocompletePageTest extends BaseTest {

    private AutocompletePage autocompletePage;

    @BeforeMethod
    public void before() {
        driver.get("https://seleniumui.moderntester.pl/autocomplete.php");
        autocompletePage = new AutocompletePage(driver);
    }

    @Test
    public void test() {

        String s = "andreas johnson";
        autocompletePage.inputTextInField("rea")
        .selectGivenSuggestion(s);

        Assert.assertEquals(autocompletePage.getContentOdSearchInput(), "andreas johnson");
    }

    @Test
    public void verifyThatForInputANumberIs9Test() {
        autocompletePage.inputTextInField("a")
                .verifyNumberOfSuggestions();
        autocompletePage
                .verifyThatNumberOfSuggestionsEquals(9);

        Assert.assertEquals(autocompletePage.getNumberOfSuggestions(), 9);
        Assert.assertTrue(autocompletePage.verifyThatNumberOfSuggestionsEquals(9));



    }



}
