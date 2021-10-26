package example.widgets;

import example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class SelectMenuPage extends BasePage {
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "speed")
    protected WebElement speedSelect;

    @FindBy(id = "speed-button")
    protected WebElement speedButton;

    @FindBy(id = "files")
    protected WebElement filesSelect;

    @FindBy(id = "number")
    protected WebElement numberSelect;

    @FindBy(id = "salutation")
    protected WebElement salutationSelect;



    public List<String> getNamesOfSelectOptions(WebElement select) {

        Select sppeds = new Select(select);

        List<WebElement> elementsOfDropdown = sppeds.getOptions();
        return elementsOfDropdown.stream().map(element -> element.getAttribute("value")).collect(Collectors.toList());

    }

    public List<String> getNamesOfSpeeds() {
        return getNamesOfSelectOptions(speedSelect);
    }

    public List<String> getNamesOfFiles() {
        return getNamesOfSelectOptions(filesSelect);

    }
    public List<String> getNamesOfNumber() {
        return getNamesOfSelectOptions(numberSelect);

    }

    public List<String> getNamesOfTitles() {
        return getNamesOfSelectOptions(salutationSelect);

    }

    public void selectOption(WebElement select, String option) {
        Select elements = new Select(select);
        elements.selectByVisibleText(option);
    }

    public SelectMenuPage selectOptionSpeed(String option) {
        speedButton.click();
        selectOption(speedSelect, option);
        return  this;
    }



}
