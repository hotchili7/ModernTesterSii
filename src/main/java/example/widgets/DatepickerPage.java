package example.widgets;

import example.BasePage;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DatepickerPage extends BasePage {
    public DatepickerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="datepicker")
    protected WebElement datepickerInput;

    @FindBy (id = "ui-datepicker-div")
    protected WebElement datepickerDiv;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']/div/div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")
    protected WebElement monthLabel;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']/div/div[@class='ui-datepicker-title']/span[@class='ui-datepicker-year']")
    protected WebElement yearLabel;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td[contains(@class, 'ui-datepicker-current-day')]/a")
    protected WebElement selectedDay;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td[contains(@class, 'ui-datepicker-today')]/a")
    protected WebElement currentDayxx;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td[contains(@class, 'ui-datepicker-today')]/a")
    protected WebElement currentDay;

    @FindBy(xpath = "//tbody/tr/td/a[not(contains(@class, 'ui-priority-secondary'))]")
    protected List<WebElement> daysOfCurrentMonth;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']/div/a[@data-handler='prev']")
    protected WebElement previousButton;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']/div/a[@data-handler='next']")
    protected WebElement nextButton;





    public DatepickerPage inputDate(String date) {
        datepickerInput.sendKeys(date);
        return this;
    }

    public String getSelectedDate() {
        String month = monthLabel.getText();
        String year = yearLabel.getText();
        String day = selectedDay.getText();

        return day + "/" + month + "/" + year;
    }

    public String getCurrentDate() {
        datepickerInput.click();
        String month = monthLabel.getText();
        String year = yearLabel.getText();
        String day = currentDay.getText();

        return day + "/" + month + "/" + year;
    }

    public String getCurrentMonth() {
        return monthLabel.getText();
    }

    public String getCurrentYear() {
        return yearLabel.getText();
    }

    // metoda Paulina - działająca:


    public DatepickerPage selectDate(int expectedDay, int expectedMonth, int expectedYear) {
        datepickerInput.click();
        if (validateDay(expectedMonth, expectedDay) && validateMonth(expectedMonth)){

            int currentYear = Integer.parseInt(getCurrentYear());
            int currentMonth = getIntegerFromNameOfMonth(getCurrentMonth());

            int yearDifference = currentYear-expectedYear;
            int monthDifference = currentMonth - expectedMonth;

            while(!(Integer.parseInt(getCurrentYear())==expectedYear
                    &&
                    getCurrentMonth().equals((getNameOfMonthFromInteger(expectedMonth))))){
                if (yearDifference>0){
                    previousButton.click();
                } else if (yearDifference<0){
                    nextButton.click();
                } else {
                    if (monthDifference<0){
                        for (int i=0; i <monthDifference*-1; i ++){
                            nextButton.click();
                        }
                    } else if (monthDifference>0){
                        for (int i=0; i < monthDifference; i ++){
                            previousButton.click();
                        }
                    }
                }

            }
            clickDay(expectedDay);
        }

        return this;
    }

// moja, która nie działa:

//    public DatepickerPage selectDate(int expectedDay, int expectedMonth, int expectedYear) {
//       if (validateDay(expectedMonth, expectedDay) && validateMonth(expectedMonth) ) {
//           datepickerInput.click();
//           int currentYear = Integer.parseInt(getCurrentYear());
//           int currentMonth = getIntegerFromNameOfMonth(getCurrentMonth());
//
//
//           int yearDifference = currentYear - expectedYear;
//           int monthDifference = currentMonth - expectedMonth;
//
//           while (!(currentYear == expectedYear && getCurrentMonth().
//                   equals((getNameOfMonthFromInteger(expectedMonth))))) {
//               if (yearDifference > 0) {
//                   previousButton.click();
//               } else if (yearDifference < 0) {
//                   nextButton.click();
//               } else {
//                   if (monthDifference < 0) {
//                       for (int i = 0; i < monthDifference*(-1); i++) {
//                           nextButton.click();
//                       }
//                   } else if (monthDifference > 0) {
//                       for (int i = 0; i < monthDifference; i++) {
//                           previousButton.click();
//                       }
//                   }
//               }
//
//           }
//           clickDay(expectedDay);
//
//       }
//       return this;
//
//    }

    // metody pomocnicze do selectDate

    public boolean validateMonth(int expectedMonth) {
        if (expectedMonth<1 || expectedMonth>12) {
            System.out.println("Nie ma takiego miesiąca");
            return false;
        }
        return true;
    }

    public boolean validateDay(int expectedMonth, int expectedDay) {
        List<Integer> monthsWith31Days = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
        List<Integer> monthsWith30Days = Arrays.asList(4, 6, 9, 11);

        if (monthsWith31Days.contains(expectedMonth)) {
            if (expectedDay < 1 || expectedDay > 31) {
                System.out.println("Za dużo dni dla danego miesiąca");
                return false;
            }
        } else if (monthsWith30Days.contains(expectedMonth)) {
            if (expectedDay < 1 || expectedDay > 30) {
                System.out.println("Za dużo dni dla danego miesiąca");
                return false;
            }
        } else if (expectedMonth == 2) {
            if (expectedDay < 1 || expectedDay > 28) {
                System.out.println("Za dużo dni dla danego miesiąca");
                return false;
            }
        }
        return true;
    }

//    public boolean validateDay(int expectedDay, int expectedMonth) {
//        List<Integer> monthWith31Days = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
//        List<Integer> monthWith30Days = Arrays.asList(4, 6, 9, 11);
//
//        if (monthWith31Days.contains(expectedMonth)) {
//            if (expectedDay < 1 || expectedDay > 31) {
//                System.out.println("Za dużo dni dla danego miesiąca!");
//                return false;
//            }
//        } else if (monthWith30Days.contains(expectedMonth)) {
//            if (expectedDay < 1 || expectedDay > 30) {
//                System.out.println("Za dużo dni dla danego miesiąca!");
//                return false;
//            }
//        } else if (expectedMonth == 2) {
//            if (expectedDay < 1 || expectedDay > 28) {
//                System.out.println("Za dużo dni dla danego miesiąca!");
//                return false;
//            }
//        }
//        return true;
//
//    }


    public int getIntegerFromNameOfMonth(String month) {
        DateTimeFormatter format = DateTimeFormat.forPattern("MMM");
        DateTime instance = format.withLocale(Locale.ENGLISH).parseDateTime(month);
        return instance.getMonthOfYear();
    }

    public String getNameOfMonthFromInteger(int month) {
        return  new DateFormatSymbols(Locale.ENGLISH).getMonths()[month - 1];
    }

    public DatepickerPage clickDay(int expectedDay) {
        daysOfCurrentMonth.stream().filter(element -> Integer.parseInt(element.getText())==expectedDay)
                .findFirst().get().click();
        return this;
    }


    public String getDateFromDateInput() {
        return datepickerInput.getAttribute("value");
    }

    public int[] getNumericValueFromDatepickerInput() {
        int[] dates = new int[3];

        String[] strings = getDateFromDateInput().split("/");

        for (int i = 0; i < strings.length; i++) {
            dates[i] = Integer.parseInt(strings[i]);
        }


        return dates;
    }






}
