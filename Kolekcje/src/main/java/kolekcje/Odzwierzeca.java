package kolekcje;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Odzwierzeca {
    public static void main(String[] args) {
        List<Zwierze> zwierzeta = new ArrayList<>();

        Zwierze kot = new Zwierze("kot", 5, "bialy");
        Zwierze pies = new Zwierze("pies", 4, "bury");
        Zwierze wrona = new Zwierze("wrona", 2, "czarny");
        Zwierze skowronek = new Zwierze("skowronek", 3, "zielony");
        Zwierze lis = new Zwierze("lis", 7, "rudy");
        Zwierze dzik = new Zwierze("dzik", 6, "szary");

        zwierzeta.add(kot);
        zwierzeta.add(pies);
        zwierzeta.add(wrona);
        zwierzeta.add(skowronek);
        zwierzeta.add(lis);
        zwierzeta.add(dzik);



        zwierzeta.sort(new Comparator<Zwierze>() {
            @Override
            public int compare(Zwierze o1, Zwierze o2) {
                return o1.getLegs() - o2.getLegs();
            }
        });

        System.out.println(zwierzeta);


        for (Zwierze zwierze : zwierzeta) {
            if (zwierze.getName().startsWith("p")) {
                System.out.println(zwierze);
            }
        }

//        --STREAM--
//          sortowanie - wyświetlanie -- LAMBDA

        List<Zwierze> list1 = zwierzeta.stream().filter(zwierze -> zwierze.getName().startsWith("k")).collect(Collectors.toList());

        System.out.println(list1);

        zwierzeta.stream().forEach(zwierze -> System.out.println(zwierze));
//        zwierzeta.forEach(System.out::println);
        List<Zwierze> sortedList = zwierzeta.stream().sorted(((o1, o2) -> o1.getName().compareTo(o2.getName()))).collect(Collectors.toList());

        System.out.println("Sorted list");
        System.out.println(sortedList);


        long legs = zwierzeta.stream().filter(zwierze -> zwierze.getLegs() > 4).count();

        System.out.println("Zwierzeta z nog > 4");
        System.out.println(legs);


//        List<Zwierze> zwierzeta2 = zwierzeta.stream().map(zwierze -> new Zwierze("małpa", 2, "ruda")).collect(Collectors.toList());

//        System.out.println("Lista z mowym zwierzeta: ");
//        System.out.println(zwierzeta2);

//        DISTINCT
        List<Zwierze> collect = zwierzeta.stream().distinct().collect(Collectors.toList());




    }
}
