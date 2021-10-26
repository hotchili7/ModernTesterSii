package example.form;

import example.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;

import static example.form.FormPage.*;
import static example.form.FormPage.Gender.*;
import static example.form.FormPage.Profession.*;
import static org.testng.Assert.*;

public class FormPageTest extends BaseTest {
    private FormPage formpage;
    private int indexOfExperienceYear = 6;
    private String genderMale = "male";
    private String genderFemale = "Female";
    private int continentIndex = 5;


   private final List<String> selectedProfessions = Arrays.asList("Manual tester", "Automation Tester", "Other");

   private final String UPLOAD_FILE_PATH = "C:\\Users\\paluchk\\Downloads\\173878589_3912740332105910_2832896471268635550_n.jpg";
   private final String filename = "173878589_3912740332105910_2832896471268635550_n.jpg";

   private final String downloadedFilePath = "C:\\Users\\paluchk\\Downloads\\test-file-to-download.xlsx";

    @BeforeMethod
    public void before() {
        formpage = new FormPage(driver);
        driver.get("https://seleniumui.moderntester.pl/form.php");
    }

//    @Test
//    public void shouldSelectRandomYearOfExperience() {
//        formpage.selectRandomYearOfExperienceButton();
//    }
//
//    @Test
//    public void shouldSelectGivenYearOfExperienceButtonTest() {
//        formpage.selectYearOfExperienceButtonByIndex(indexOfExperienceYear);
//    }

    @Test
    public void selectGenderByGivenNameTest() {
        formpage.selectGenderByName(MALE.getLabel());
    }

//    @Test
//    public void shouldCheckIfGivenYOEIsSelectedTest() {
//        formpage.selectYearOfExperienceButtonByIndex(indexOfExperienceYear);
//        assertTrue(formpage.isYearOfExperienceButtonSelected(indexOfExperienceYear));
//
//    }
//
//    @Test
//    public void shouldCheckIfYOEIsSelectedTest() {
//        assertFalse(formpage.isYearOfExperienceButtonSelected(indexOfExperienceYear));
//
//    }

//    @Test
//    public void shouldVerifyThatNumberOfSelectedYOFButtonsIs0Test() {
//        assertEquals(formpage.getNumberOfSelectedYOEButtons(), 0);
//
//    }

//    @Test
//    public void shouldSelect2YOFButtonAndVerifyThatNumberOfSelectedButtonsIs1() {
//        formpage.selectYearOfExperienceButtonByIndex(indexOfExperienceYear);
//        formpage.selectYearOfExperienceButtonByIndex(2);
//
//        assertEquals(formpage.getNumberOfSelectedYOEButtons(), 1);
//    }

//    @Test
//    public void shoulSelectYOFButtonOn6IndexAndVerifyThatIndexIsCorrectTest() {
//        formpage.selectYearOfExperienceButtonByIndex(indexOfExperienceYear);
//
//        assertEquals(formpage.getIndexOfSelectedYOEButton(), 6);
//    }

    @Test
    public void test() {
        formpage.clickAgeInputFieldTimes(10);
        System.out.println(formpage.getValueFromField());
    }

    @Test
    public void shouldSelectManualTesterTest() {
        formpage.selectProfessionByName(AUTOMATION_TESTER.getLabel());

        assertEquals(formpage.getNameOfSelectedProfession(), "Automation Tester");
    }

    @Test
    public void shouldSelectAllProfessionCheckBoxesAndGetNamesOfLabelsTest() {
        formpage.selectProfessionByName(MANUAL_TESTER.getLabel());
        formpage.selectProfessionByName(AUTOMATION_TESTER.getLabel());
        formpage.selectProfessionByName(OTHER_PROFESSION.getLabel());

        assertEquals(formpage.getNamesOfSelectedProfessions(),selectedProfessions);


    }

    @Test
    public void shouldSelectContinentAfrica() {
        formpage.selectContinetsByName(Continent.AFRICA.getContinentName());

        assertEquals(formpage.getNameOfSelectedContinent().get(0), "Africa");
    }

    @Test
    public void shouldSelectContinentByIndexTest() {
        formpage.selectContinentByIndex(continentIndex);

        System.out.println(formpage.getIndexOfSelectedContinent());
        assertEquals(formpage.getIndexOfSelectedContinent(), 5);
    }

    @Test
    public void shouldSelectBrowserCommand() {
        formpage.selectSeleniumCommendsByName(Commands.BROWSER_COMMANDS.getCommendName());
    }

    @Test
    public void shouldUploadFile() {
       formpage.inputFile(UPLOAD_FILE_PATH);
       assertTrue(formpage.isFileUploaded(filename));
    }

    @Test
    public void shouldDownloadTestFileTest() {
        formpage.clickTestFileDownloadButton();

        assertTrue(formpage.isFileDownloaded(downloadedFilePath));
    }

    @Test
    public void whenAllFieldAreEmptyAndSignInButtonClickThenValidationMessageShouldBeDisplayed() {
        formpage.clickSignInButton();

        String textFromValidatorMessage = formpage.getTextFromValidatorMessage();
        assertEquals(textFromValidatorMessage, "Form not send, please fill all missing form fields");
    }

    @Test
    public void shouldCompleteAllFieldsAndSendForm() {
        formpage.inputFirstName("Jan");
        formpage.inputLastName("Nygou");
        formpage.inputEmail("fs@gf.op");
        formpage.selectGenderByName(FEMALE.getLabel());
        formpage.clickAgeInputFieldTimes(20);
//        formpage.selectRandomYearOfExperienceButton();
        formpage.selectProfessionByName(AUTOMATION_TESTER.getLabel());
        formpage.selectContinentByIndex(2);
        formpage.selectSeleniumCommendsByName(Commands.BROWSER_COMMANDS.getCommendName());
        formpage.inputFile(UPLOAD_FILE_PATH);
        formpage.clickSignInButton();

        assertEquals(formpage.getTextFromValidatorMessage(), "Form send with success");


    }











}
