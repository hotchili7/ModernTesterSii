package kolekcje;

import java.util.ArrayList;
import java.util.List;

public class MainKP {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("żaba");
        list.add("żonkil");
        list.add("Glistnik");
        list.add("pokżywa");
        list.add("43ew3");
        list.add("44566");

// funkcja contains sprawdza czy w liście znajduje się element o danej nazwie
        System.out.println(list.contains("żaba"));

//        wyświetlanie elementów, które zaczynają się od wielkiej litry

        List<String> upperCaseList = new ArrayList<>();

        for (String s : list) {
            if (Character.isUpperCase(s.charAt(0))) {
                upperCaseList.add(s);
            }
        }
        System.out.println("Wyświetla listę z elementami w środku []");
        System.out.println(upperCaseList);

        System.out.println("Wyświetla elementy listy");
        for (String s : upperCaseList) {
            System.out.println(s);
        }

        System.out.println("Wyświetla pierwszy element listy");
        System.out.println(upperCaseList.get(0));

        System.out.println("Wyświetla wszystkie ele zaczynające się na ż");
        for (String s : list) {
            if (s.startsWith("ż")) {
                System.out.print(s + ", ");
            }
        }
        System.out.println();

        System.out.println("Liczy elementy zaczynające się na ż");
        int count = 0;
        for (String s : list) {
            if (s.startsWith("ż")) {
                count++;
            }
        }

        System.out.println(count);

        List<String> żStarts = new ArrayList<>();

        for (String s : list) {
            if(s.startsWith("ż")) {
                żStarts.add(s);
            }
        }

        System.out.println(żStarts);

        for (String s : żStarts) {
            System.out.print(s+ ", ");
        }

        System.out.println();

        //        wyświetlić długość każdego elementu listy
        System.out.println("Długość każdego elementu listy: ");

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).length()+ ", ");

        }

        //        jeśli długość elementu > 3 => dodać do nowej listy

        List<String> threeList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length()>4) {
                threeList.add(list.get(i));
            }
        }

        System.out.println(threeList);

        List<String> threeList2 = new ArrayList<>();

        for (String s : list) {
            if(s.length()>4) {
                threeList2.add(s);
            }
        }

        System.out.println(threeList2);


//        jeśli element listy kończy sie na a, obciąć i dodać do nowej listy

    List<String> cuttedA = new ArrayList<>();

        for (String s : list) {
            if (s.endsWith("a")) {
                String replace = s.replace(s.substring(s.length() - 1), "");
                cuttedA.add(replace);
            }

        }

        System.out.println(cuttedA);


    }
}
