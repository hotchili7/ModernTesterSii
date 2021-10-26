package example.widgets;

import example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class TabsPage extends BasePage {
    public TabsPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//ul[@role='tablist']/li")
    protected List<WebElement> tabs;

    public static final String TAB_BY_NAME_XPATH = "//ul[@role='tablist']/li/a[text()='%s']";

//    @FindBy(xpath = "//div[@style='display: block;']")
//    protected WebElement displayedTextInTab4;

    @FindBy(xpath = "//div[@style='display: block;']/p/strong")
    protected List<WebElement> headers;

    @FindBy(xpath = "//div[@style='display: block;']/p[not(./strong)]")
    protected List<WebElement> paragraphs;





    public TabsPage switchToTab(String tabName) {
        driver.findElement(By.xpath(String.format(TAB_BY_NAME_XPATH, tabName))).click();
        return this;
    }

    public String getTextFromTab(String tabName) {
        switchToTab(tabName);
        String header = "";
        if (headers.size() > 0) {
            header = headers.get(0).getText();
        }
        return header;
    }

    public List<String> getTextFromParagraphs() {
        return paragraphs.stream().map(element -> element.getText()).collect(Collectors.toList());
    }
}
