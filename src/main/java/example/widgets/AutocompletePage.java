package example.widgets;

import example.BasePage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AutocompletePage extends BasePage {
    public AutocompletePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "search")
    protected WebElement searchInput;

    @FindBy(id = "ui-id-1")
    protected WebElement dropdown;

    @FindBy(xpath = "//ul[@id='ui-id-1']/li[@class='ui-menu-item']/div")
    protected List<WebElement> suggestions;

    public AutocompletePage inputTextInField(String text) {
        searchInput.sendKeys(text);
        waitForVisibility(dropdown);
        suggestions.stream().allMatch(element -> element.getText().contains(text));
        System.out.println(suggestions.get(2).getText());
        return this;
    }

    public AutocompletePage selectGivenSuggestion(String suggestion) {
        for (WebElement webElement : suggestions) {
            if (webElement.getText().equals(suggestion)) {
                webElement.click();
            }
        }
        return this;
    }


    public int getNumberOfSuggestions() {
        return suggestions.size();
    }

    public AutocompletePage verifyNumberOfSuggestions() {
        Assertions.assertThat(suggestions.size() == 9).isTrue();
        return this;
    }

    public boolean verifyThatNumberOfSuggestionsEquals(int number) {
        return suggestions.size() == number;
    }


    public String getContentOdSearchInput() {
        return searchInput.getAttribute("value");
    }


}
