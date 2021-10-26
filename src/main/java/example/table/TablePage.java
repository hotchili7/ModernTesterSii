package example.table;

import example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TablePage extends BasePage {

    public TablePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//tbody/tr")
    protected List<WebElement> rows;

    @FindBy(xpath = "//tfoot/tr/td")
    private WebElement totalNumberOfPeaks;

//    przypisanie  rows -> row


    public List<Mountain> getListOfMountains() {
        List<Mountain> mountains = new ArrayList<>();

        for (WebElement row : rows) {
            mountains.add(new Mountain(row));

        }
        return mountains;
    }


public List<Mountain> getMountainsFromSwitzerland() {
        List<Mountain> mountains = getListOfMountains();
        return mountains.stream().filter(mountain -> mountain.getState().equals("Switzerland")).collect(Collectors.toList());

}

public List<Mountain> getMountainsWitthSwitzerlandName() {
    List<Mountain> mountains = getListOfMountains();
    return mountains.stream().filter(mountain -> mountain.getState().contains("Switzerland")).collect(Collectors.toList());
}


public List<Mountain> getMountainsFromSwitzerland1 () {
    List<Mountain> mountains = getListOfMountains();
    List<Mountain> swissMountains = new ArrayList<>();
    for (Mountain mountain : mountains) {
        if (mountain.getState().equals("Switzerland"));
        swissMountains.add(mountain);
    }
    return swissMountains;
}

public List<Mountain> getMountainsFromSwitzerland2 () {
    List<Mountain> mountains = getListOfMountains();
    List<Mountain> swissMountains = new ArrayList<>();

    for (int i = 0; i < mountains.size(); i++) {
        if (mountains.get(i).getState().equals("Switzerland"));
        swissMountains.add(mountains.get(i));
    }
    return swissMountains;


}


public List<Mountain> getMountainSortedByName() {
        List<Mountain> mountains = getListOfMountains();
//        return mountains.stream().sorted(new Comparator<Mountain>() {
//            @Override
//            public int compare(Mountain o1, Mountain o2) {
//                return o1.getPeak().compareTo(o2.getPeak());
//            }
//        }).collect(Collectors.toList());
    return mountains.stream().sorted(((o1, o2) -> o1.getPeak().compareTo(o2.getPeak()))).collect(Collectors.toList());

}

public List<Mountain> getMountainSortedByName1() {
    List<Mountain> mountains = getListOfMountains();

     mountains.sort(new Comparator<Mountain>() {
        @Override
        public int compare(Mountain o1, Mountain o2) {
            return o1.getPeak().compareTo(o2.getPeak());
        }
    });

     return mountains;

};


    public Optional<Mountain> getMountainByName(String peakName) {
        return getListOfMountains().stream().filter(mountain -> mountain.getPeak().equals(peakName)).findFirst();

    }


// zwrócić listę gór wyższych niż 3800
    public List<Mountain> getMountainsHigherThan3800() {
        List<Mountain> mountains = getListOfMountains();
        List<Mountain> higherThan3800Mountains = new ArrayList<>();

        for (Mountain mountain : mountains) {
            if (mountain.getHeight()>3800) {
                higherThan3800Mountains.add(mountain);
            }
        }
        return higherThan3800Mountains;

    }

//    wyszukiać listę gór wyższych niż podany parametr

    public List<Mountain> getMountainHigherThan1(int givenHeight) {
        List<Mountain> higherThanPar = new ArrayList<>();

        for (Mountain mountain : getListOfMountains()) {
            if (mountain.getHeight()>givenHeight) {
                higherThanPar.add(mountain);
            }
        }
        return higherThanPar;
    }


    public List<Mountain> getMountainHigherThan2(int givenHeight) {
        List<Mountain> higherThanPar = new ArrayList<>();

        for (int i = 0; i < getListOfMountains().size(); i++) {
            if (getListOfMountains().get(i).getHeight() > givenHeight) {
                higherThanPar.add(getListOfMountains().get(i));
            }
        }
        return higherThanPar;
    }

    public List<Mountain> getMountainHigherThan3(int givenHeight) {
        return getListOfMountains().stream().filter(mountain -> mountain.getHeight()>givenHeight).collect(Collectors.toList());
    }

//    zsumować wysokość wszystkich gór wyższych niż 3000

    public long sumOfAllMountainsHigherThan3000() {
        return getListOfMountains().stream().filter(mountain -> mountain.getHeight() > 3000).count();
    }


    public long sumOfAllHeightsHigherThan3000() {
        return getListOfMountains().stream().filter(mountain -> mountain.getHeight()>3000).map(mountain -> mountain.getHeight())
                .reduce(0, Integer::sum);
    }

    public int sumOfAllHeightsHigherThan3000ForEach() {
        int count = 0;

        for (Mountain mountain : getListOfMountains()) {
            if (mountain.getHeight()>3000) {
                count = count + mountain.getHeight();
            }
        }
        return count;
    }


//    zwrócić góry należące do podanego kraju (na 3 sposoby)

    public List<Mountain> getPeaksBelongingToCountry1(String countryName) {
        List<Mountain> peaksBelongingTo = new ArrayList<>();

        for (Mountain mountain : getListOfMountains()) {
            if(mountain.getState().equals(countryName)) {
                peaksBelongingTo.add(mountain);
            }
        }
        return peaksBelongingTo;
    }

    public List<Mountain> getPeaksBelongingToCountry2(String countryName) {
        List<Mountain> peaksBelongingTo = new ArrayList<>();

        for (int i = 0; i < getListOfMountains().size(); i++) {
            if (getListOfMountains().get(i).getState().equals(countryName)) {
                peaksBelongingTo.add(getListOfMountains().get(i));
            }
        }
        return peaksBelongingTo;

    }

    public List<Mountain> getPeaksBelongingToCountry3(String countryName) {
        return getListOfMountains().stream().filter(mountain -> mountain.getState().equals(countryName)).collect(Collectors.toList());
    }

//    zwrócić nazwy gór przynależących do kraju

    public List<String> getNameOfPeaksBelongingToCountry1(String country) {
        List<String> nameOfPeaks = new ArrayList<>();

        for (Mountain mountain : getListOfMountains()) {
            if (mountain.getState().equals(country)) {
                nameOfPeaks.add(mountain.getPeak());
            }
        }
        return nameOfPeaks;
    }

    public List<String> getNameOfPeaksBelongingToCountry2(String country) {
        List<String> nameOfPeaks = new ArrayList<>();

        for (int i = 0; i < getListOfMountains().size(); i++) {
            if (getListOfMountains().get(i).getState().equals(country)) {
                nameOfPeaks.add(getListOfMountains().get(i).getPeak());
            }
        }
        return nameOfPeaks;
    }

    public List<String> getNameOfPeaksBelongingToCountry3(String country) {
        return getListOfMountains().stream().filter(mountain -> mountain.getState().equals(country)).map(mountain -> mountain.getPeak()).collect(Collectors.toList());
    }


//    znaleźć góry należące do podanego kraju i mające wysokośći większą niż

    public List<Mountain> getMountainsWithGivenCountryAndHeight(String country, int peakHeight) {
        List<Mountain> mountains = new ArrayList<>();
        for (Mountain mountain : getListOfMountains()) {
            if(mountain.getState().contains(country) && mountain.getHeight()>peakHeight) {
                mountains.add(mountain);
            }
        }
        return mountains;
    }

    public List<Mountain> getMountainsWithGivenCountryAndHeight1(String country, int peakHeight) {
        List<Mountain> mountains = new ArrayList<>();

        for (int i = 0; i < getListOfMountains().size(); i++) {
            if(getListOfMountains().get(i).getState().contains(country) && getListOfMountains().get(i)
                    .getHeight() > peakHeight) {
                mountains.add(getListOfMountains().get(i));
            }

        }
        return mountains;
    }


    public List<Mountain> getMountainsWithGivenCountryAndHeight2(String country, int peakHeight) {
        return getListOfMountains().stream().filter(mountain -> mountain.getState().contains(country)
                && mountain.getHeight() > peakHeight).collect(Collectors.toList());

    }

// oraz sortowanie
    public List<Mountain> getMountainsWithGivenCountryAndHeightAndSortByName(String country, int peakHeight) {
        return getListOfMountains().stream().filter(mountain -> mountain.getState().contains(country)
                && mountain.getHeight() > peakHeight).sorted((o1, o2) -> o1.getPeak().compareTo(o2.getPeak()))
                .collect(Collectors.toList());

    }

    public int getTotalNumberOfPeaks() {
        return Integer.parseInt(totalNumberOfPeaks.getText().replace(" peaks", ""));
    }

// ilość szczytów wyższych niż 4000

    public int numberOfPeaksMoreThan4000_1() {
        int count = 0;
        for (Mountain mountain : getListOfMountains()) {
            if (mountain.getHeight()>4000) {
                count++;
            }
        }
        return count;
    }

    public int numberOfPeaksMoreThan4000_2() {
        List<Mountain> mountains = new ArrayList<>();
        for (Mountain mountain : getListOfMountains()) {
            if (mountain.getHeight()>4000) {
               mountains.add(mountain);
            }
        }
        return mountains.size();
    }

    public int numberOfPeaksMoreThan4000_3(int peakHeight) {
        List<Mountain> mountains = new ArrayList<>();
        for (Mountain mountain : getListOfMountains()) {
            if (mountain.getHeight()>peakHeight) {
                mountains.add(mountain);
            }
        }
        return mountains.size();
    }


    public int numberOfPeaksMoreThan4000_4(int peakHeight) {
        int count = 0;
        for (int i = 0; i < getListOfMountains().size(); i++) {
            if (getListOfMountains().get(i).getHeight()>peakHeight) {
                count++;
        }
    }
        return count;
    }

    public int numberOfPeaksMoreThan4000_5(int peakHeight) {
        return (int) getListOfMountains().stream().filter(mountain -> mountain.getHeight()>peakHeight).count();
    }

//    policzyć wszystkie szczyty zaczynające się na 'D'

    public int getNumberOfPeaksStrartsWithD() {
        int count = 0;
        for (Mountain mountains : getListOfMountains()) {
            if (mountains.getPeak().startsWith("D")) {
                count++;
            }
        }
        return count;
    }

    public int getNumberOfPeaksStrartsWithPar(String param) {
        int count = 0;
        for (Mountain mountain : getListOfMountains()) {
            if (mountain.getPeak().startsWith(param.toUpperCase())) {
                count++;
            }
        }
        return count;
    }

    public int getNumberOfPeaksStrartsWithPar_2(String param) {
        int count = 0;
        for (int i = 0; i < getListOfMountains().size(); i++) {
                           if (getListOfMountains().get(i).getPeak().startsWith(param.toUpperCase())) {
                    count++;
                }
            }
            return count;
        }


    public int getNumberOfPeaksStrartsWithPar_3(String param) {
        int count = 0;
        return (int) getListOfMountains().stream().filter(mountain -> mountain.getPeak().startsWith(param.toUpperCase())).count();

    }

//    nazwy wszystkich gór wyższych niż param

    public List<String> getNameOfPeaksHigherThanPar(int param) {
        List<String> names = new ArrayList<>();
        for (Mountain mountain : getListOfMountains()) {
            if (mountain.getHeight()>param) {
                names.add(mountain.getPeak());
            }
        }
        return names;
    }

    public List<String> getNameOfPeaksHigherThanPar_2(int param) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < getListOfMountains().size(); i++) {
            if (getListOfMountains().get(i).getHeight() > param) {
                names.add(getListOfMountains().get(i).getPeak());
            }
        }
        return names;
    }

    public List<String> getNameOfPeaksHigherThanPar_3(int param) {
        return getListOfMountains().stream().filter(mountain -> mountain.getHeight() > param)
                .map(mountain -> mountain.getPeak()).collect(Collectors.toList());
    }

//    wyświetlić nzawy gór zawierające "horn"

    public List<String> getNameOfPeaksContaing(String str) {
        List<String> names = new ArrayList<>();

        for (Mountain mountain : getListOfMountains()) {
            if (mountain.getPeak().contains(str)) {
                names.add(mountain.getPeak());
            }
        }
        return names;
    }

    public List<String> getNameOfPeaksContaing_1(String str) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < getListOfMountains().size(); i++) {
            if (getListOfMountains().get(i).getPeak().contains(str)) {
                names.add(getListOfMountains().get(i).getPeak());
            }
        }
        return names;
    }

    public List<String> getNameOfPeaksContaing_2(String str) {
       return getListOfMountains().stream().filter(mountain -> mountain.getPeak().contains(str))
                .map(mountain -> mountain.getPeak()).collect(Collectors.toList());
    }
//    tablice

    public String[] getNamesToArray() {
        String[] names = new String[13];
        for (int i = 0; i < getListOfMountains().size(); i++) {
            names[i] = getListOfMountains().get(i).getPeak();
        }
        return names;
    }






















}
