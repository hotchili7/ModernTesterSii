package example.table;

import example.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TablePageTest extends BaseTest {

    private TablePage tablePage;

    @BeforeMethod
    public void before() {
        driver.get("https://seleniumui.moderntester.pl/table.php");
        tablePage = new TablePage(driver);
    }


//    @Test
//    public void test() {
//        System.out.println(tablePage.getListOfMountains());
//    }

    @Test
    public void test() {
        for (Mountain listOfMountain : tablePage.getListOfMountains()) {
            System.out.println(listOfMountain);
        }
    }

    @Test
    public void test1() {
        System.out.println(tablePage.getMountainsFromSwitzerland());
        System.out.println(tablePage.getMountainsWitthSwitzerlandName());
    }

    @Test
    public void shouldSortByName() {
        System.out.println(tablePage.getMountainSortedByName1());

    }


    @Test
    public void shouldReturnPeakByName() {
        System.out.println(tablePage.getMountainByName("Dufourspitze"));
    }

    @Test
    public void shouldSumOfPeaksHigherTahn3000() {
        System.out.println(tablePage.sumOfAllMountainsHigherThan3000());
    }


    @Test
    public void lhnjhn() {
        System.out.println(tablePage.sumOfAllHeightsHigherThan3000ForEach());
    }

    @Test
    public void test2() {
        System.out.println(tablePage.getPeaksBelongingToCountry1("Italy"));
        System.out.println(tablePage.getPeaksBelongingToCountry2("Italy"));
        System.out.println(tablePage.getPeaksBelongingToCountry3("Italy"));
    }

    @Test
    public void test3() {
        System.out.println(tablePage.getNameOfPeaksBelongingToCountry1("Italy"));
        System.out.println(tablePage.getNameOfPeaksBelongingToCountry2("Italy"));
        System.out.println(tablePage.getNameOfPeaksBelongingToCountry3("Italy"));
    }

    @Test
    public void test4() {
        System.out.println(tablePage.getMountainsWithGivenCountryAndHeight("Italy", 2500));
        System.out.println(tablePage.getMountainsWithGivenCountryAndHeightAndSortByName("Italy", 2500));
    }

    @Test
    public void totalNumberOfPeaksShouldBe13() {
        Assert.assertEquals(tablePage.getTotalNumberOfPeaks(), 13);
    }

    @Test
    public void totalNumerOfPeaksShouldBeThesameAsNumberOfRowsTest() {
        Assert.assertEquals(tablePage.getTotalNumberOfPeaks(), tablePage.rows.size());
    }

    @Test
    public void test5() {
        System.out.println(tablePage.numberOfPeaksMoreThan4000_1());
        System.out.println(tablePage.numberOfPeaksMoreThan4000_2());
        System.out.println(tablePage.numberOfPeaksMoreThan4000_3(4000));
        System.out.println(tablePage.numberOfPeaksMoreThan4000_4(4000));
        System.out.println(tablePage.numberOfPeaksMoreThan4000_5(4000));
    }

    @Test
    public void test6() {
        System.out.println(tablePage.getNumberOfPeaksStrartsWithD());
        System.out.println(tablePage.getNumberOfPeaksStrartsWithPar("d"));
//        System.out.println(tablePage.getNumberOfPeaksStrartsWithPar_2("d"));
        System.out.println(tablePage.getNumberOfPeaksStrartsWithPar_3("d"));
    }

@Test
    public void test7() {
    System.out.println(tablePage.getNameOfPeaksHigherThanPar(4100));
    System.out.println(tablePage.getNameOfPeaksHigherThanPar_2(4100));
    System.out.println(tablePage.getNameOfPeaksHigherThanPar_3(4100));
}


@Test
    public void test8() {
    System.out.println(tablePage.getNameOfPeaksContaing("horn"));
    System.out.println(tablePage.getNameOfPeaksContaing_2("horn"));
    System.out.println(tablePage.getNameOfPeaksContaing_1("horn"));
}

@Test
    public void test9() {
//    System.out.println(tablePage.getNamesToArray().toString());
    for (String s : tablePage.getNamesToArray()) {
        System.out.println(s);
    }
}



}
