package example.iframe;

import example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class IframePage extends BasePage {
    public IframePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "iframe1")
    public WebElement iframe1;

    @FindBy(name = "iframe2")
   public WebElement iframe2;

    @FindBy(id = "inputFirstName3")
    private WebElement inputFirstName3;

    @FindBy(id = "inputSurname3")
    private WebElement inputSurename3;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;
//--------- iFrame 2------------
    @FindBy(id = "inputLogin")
    private WebElement inputLoginIFrame2;

    @FindBy(id = "inputPassword")
    private WebElement inputPasswordIFrame2;

    @FindBy(id = "inlineFormCustomSelectPref")
    private WebElement continentSelectIFrame2;

    @FindBy(name = "gridRadios")
    private List<WebElement> YOFElementsIFrame2;

    public static final String YOF_ELEMENT_ON_INDEX = "(//input[@name='gridRadios'])[%d]";

    @FindBy(xpath = "//label[@class='form-check-label']")
    private List<WebElement> yoeLabels;

    @FindBy(className = "ui-tooltip-content")
    private WebElement iframeTooltip;




    public void completeIframe1(String firstname, String surename) {
//        driver.switchTo().frame(0);
        driver.switchTo().frame(iframe1);
        inputFirstName3.sendKeys(firstname);
        inputSurename3.sendKeys(surename);
        signInButton.click();

    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public void exitIFrame() {
        driver.switchTo().defaultContent();
    }

    public void completeIFrame2(String login, String password, int index) {
        driver.switchTo().frame(iframe2);
        inputLoginIFrame2.sendKeys(login);
        inputPasswordIFrame2.sendKeys(password);
        selectContinentByIndex(index);
        selectRandomYOE();
        clickSignInButton();
    }

    public void selectContinentByIndex(int index) {
        Select continents = new Select (continentSelectIFrame2);
        continents.selectByIndex(index);
    }

    public void selectRandomYOE() {
//        służy do wybierania randomowej liczby
        int randomIndex = ThreadLocalRandom.current().nextInt(1, YOFElementsIFrame2.size()+1);
            driver.findElement(By.xpath(String.format(YOF_ELEMENT_ON_INDEX, randomIndex))).click();

        
    }

    public int getNumberOfYOEElements() {
        driver.switchTo().frame(iframe2);
        return yoeLabels.size();
    }

    public int getSizeOfYOELabels() {
//        driver.switchTo().frame(iframe2);
        Set<String> labels = new HashSet<>();
        for (WebElement yoeLabel : yoeLabels) {
            labels.add(yoeLabel.getText());
        }
        return labels.size();
    }

    public List<Integer> getRepeatedLabels() {
        driver.switchTo().frame(iframe2);
        List<Integer> repeatedLabels = new ArrayList<>();
        List<String> labelNames = new ArrayList<>();

        for (WebElement label : yoeLabels) {
            labelNames.add(label.getText());
        }
        System.out.println();
        System.out.println(labelNames);
        System.out.println();

        for (int i = 0; i < labelNames.size(); i++) {
            if (Integer.parseInt(labelNames.get(i)) != i +1) {
                repeatedLabels.add(Integer.parseInt(labelNames.get(i)));
            }

        }
        return repeatedLabels;

    }

    public void hoverMouseOverElement(WebElement element) {
        actions.moveToElement(element).build().perform();
    }

    public String getTextFromIframeTooltip() {
        wait.until(ExpectedConditions.visibilityOf(iframeTooltip));
       return iframeTooltip.getText();
    }




}
