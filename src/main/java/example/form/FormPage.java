package example.form;

import example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPathEvaluationResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.FileHandler;

public class FormPage extends BasePage {

    public enum Gender {
        MALE("male"),
        FEMALE("Female"),
        OTHER("Other");

        public String label;

       Gender(String label) {
           this.label = label;
       }

        public String getLabel() {
            return label;
        }
    }

    public enum Profession{
        MANUAL_TESTER("Manual tester"),
        AUTOMATION_TESTER("Automation Tester"),
        OTHER_PROFESSION("Other");

        public String label;

        Profession(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    public enum Continent{
        ASIA("Asia"),
        EUROPE("Europe"),
        AFRICA("Africa"),
        ANTAECTICA("Antarctica"),
        NORTH_AMERICA("North America"),
        SOUTH_AMERICA("South America"),
        AUSTRALIA("Australia");

        public String continentName;

        Continent(String continentName) {
            this.continentName = continentName;
        }

        public String getContinentName() {
            return continentName;
        }
    }


    public enum Commands{
        BROWSER_COMMANDS("browser-commands"),
        NAVIGATION_COMMENDS("navigation-commands");

        public String commendName;

        Commands(String commendName) {
            this.commendName = commendName;
        }

        public String getCommendName() {
            return commendName;
        }
    }




    public FormPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "inputFirstName3")
    private WebElement firstNameInput;

    @FindBy(id = "inputLastName3")
    private WebElement lastNameInput;

    @FindBy(id = "inputEmail3")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='gridRadiosMale']")
    private WebElement maleRadioButton;

    @FindBy(xpath = "//input[@id='gridRadiosFemale']")
    private WebElement femaleRadioButton;

    @FindBy(xpath = "//input[@id='gridRadiosOther']")
    private WebElement otherRadioButton;

    public static final String GENDER_RADIO_BUTTON = "//div[@class='form-check']/input[@value='%s']";

    @FindBy(id = "inputAge3")
    private WebElement ageInput;



    @FindBy(xpath = "//input[@name='gridCheckboxProfession']")
    private List<WebElement> professionCheckboxes;

    public static final String PROFESSION_CHECKBOX = "//div[@class='form-check' and ./input[@name='gridCheckboxProfession']]/label[contains(text(), '%s')]";
    public static final String PROFESSION_CHECKBOX_ON_INDEX = "(//div[@class='form-check']/input[@name='gridCheckboxProfession'])[%d]";
    public static final String PROFESSION_LABEL_ON_INDEX = "(//div[@class='form-check' and ./input[@name='gridCheckboxProfession']]/label)[%d]";

    @FindBy(id= "selectContinents")
    private WebElement continetsSelect;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement seleniumCommendsSelect;

    @FindBy(id = "chooseFile")
    private WebElement chooseFileInput;

    @FindBy(className = "custom-file-label")
    private WebElement fileLabel;

    @FindBy(xpath = "//a[text()='Test File to Download']")
    private WebElement testFileToDownloadButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;

    @FindBy(id = "validator-message")
    private WebElement validatorMessage;






    public void inputFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void inputEmail(String email) {
        emailInput.sendKeys(email);
    }


    public void selectGenderByName(String gender) {
        driver.findElement(By.xpath(String.format(GENDER_RADIO_BUTTON, gender))).click();
    }



    public void clickAgeInputFieldTimes(int n) {
        ageInput.click();
        for (int i = 0; i < n; i++) {
        actions.sendKeys(Keys.ARROW_UP).build().perform();
        }
    }

    public void inputAgeInAgeField(int age) {
        ageInput.sendKeys(String.valueOf(age));

    }

    public String getValueFromField() {
        return ageInput.getText();
    }

    public void selectProfessionByName(String professionName) {
        driver.findElement(By.xpath(String.format(PROFESSION_CHECKBOX, professionName))).click();
    }


    public String getNameOfSelectedProfession() {
        String professionName = "";
        for (int i = 1; i <= professionCheckboxes.size(); i++) {
            if (driver.findElement(By.xpath(String.format(PROFESSION_CHECKBOX_ON_INDEX, i))).isSelected()) {
                professionName = driver.findElement(By.xpath(String.format(PROFESSION_LABEL_ON_INDEX, i))).getText();
            }
        }
        return professionName;
    }

public List<String> getNamesOfLabels() {
        List<String> labels = new ArrayList<>();
    for (int i = 1; i<= professionCheckboxes.size(); i++) {
        if (driver.findElement(By.xpath(String.format(PROFESSION_CHECKBOX_ON_INDEX, i))).isSelected()) {
            labels.add(driver.findElement(By.xpath(String.format(PROFESSION_CHECKBOX_ON_INDEX, i))).getText());
        }
    }
    return labels;
}




    public List<String> getNamesOfSelectedProfessions() {
        List<String> professionNames = new ArrayList<>();
        for (int i = 1; i <= professionCheckboxes.size(); i++) {
            if (driver.findElement(By.xpath(String.format(PROFESSION_CHECKBOX_ON_INDEX, i))).isSelected()) {
                professionNames.add(driver.findElement(By.xpath(String.format(PROFESSION_LABEL_ON_INDEX, i))).getText());
            }
        }
        return professionNames;
    }



    public void selectContinetsByName(String name) {
        Select continents = new Select(continetsSelect);
//        List<WebElement> continentOptions = continents.getOptions();
        continents.selectByVisibleText(name);

    }

    public List<String> getNameOfSelectedContinent() {
        Select continents = new Select(continetsSelect);
        List<WebElement> listOfSelectedContinents = continents.getAllSelectedOptions();
        List<String> namesOfSelectedContinents = new ArrayList<>();

        for (WebElement listOfSelectedContinent : listOfSelectedContinents) {
            namesOfSelectedContinents.add(listOfSelectedContinent.getText());


        }
        return namesOfSelectedContinents;
    }

    public void selectContinentByIndex(int index) {
        Select continents = new Select(continetsSelect);
        continents.selectByIndex(index);
    }

    public int getIndexOfSelectedContinent() {
        Select continents = new Select(continetsSelect);
        WebElement selectedOption = continents.getFirstSelectedOption();
        String option = selectedOption.getText();


        List<WebElement> listOfSelectedContinents = continents.getOptions();
        List<String> continentsNames = new ArrayList<>();

        int index = 0;

        for (WebElement listOfSelectedContinent : listOfSelectedContinents) {
            continentsNames.add(listOfSelectedContinent.getText());
            }

            for (int i = 0; i < continentsNames.size(); i++) {
                if (continentsNames.get(i).equals(option)) {
                    index = i;
                }
            }
            return index;
        }


    public void selectSeleniumCommendsByName(String seleniumCommandValue) {
        Select commands = new Select(seleniumCommendsSelect);
        commands.selectByValue(seleniumCommandValue);
    }



    public void inputFile(String path) {
        chooseFileInput.sendKeys(path);
    }

    public boolean isFileUploaded (String filename) {
        String textFromFile = fileLabel.getText();
        return  textFromFile.contains(filename);
    }

    public void clickTestFileDownloadButton() {
        testFileToDownloadButton.click();
    }

    public boolean isFileDownloaded(String filePath) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File file = new File(filePath);
        return file.isFile();


    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public String getTextFromValidatorMessage() {
        return validatorMessage.getText();
    }



    

}
