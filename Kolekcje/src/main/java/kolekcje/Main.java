package kolekcje;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {



    public static void main(String[] args) {
        //    List<String> list = new ArrayList<>();
//        List<String> list = Arrays.asList("koń", "ryba", "krowa", "Owca", "kot", "1254");
//
//        for (String s : list) {
//            System.out.println();
//        }
//        System.out.println(list);




        List<String> list = new ArrayList<>();

        list.add("koń");
        list.add("ryba");
        list.add("krowa");
        list.add("Owca");
        list.add("kot");
        list.add("2569");

        System.out.println(list.contains("ko"));
        System.out.println(list.contains("koń"));

//        wyświetlanie elementów z wielkiej litery

        List<String> uppers = new ArrayList<>();
        for (String s : list) {
            if (Character.isUpperCase(s.charAt(0))) {
                uppers.add(s);
            }

        }
        System.out.println(uppers);

//        wyświtla wszystkie elementy listy
        for (String upper : uppers) {
            System.out.println(upper);
        }
//      wyświetla 1-szy element listy
        System.out.println(uppers.get(0));

//        wyświetlić wszystkie ele zaczynające się na k

        System.out.println("Elementy zaczynające się na k");
        for (String element : list) {
            if (element.startsWith("k")) {
                System.out.print(element+" ");
            }

        }
        System.out.println();

//        policzyć elementy zaczynajace się na k
        System.out.println("Ilość elementów zaczynających się na k");
        int count = 0;
        for (String item : list) {
            if (item.startsWith("k")) {
                count++;
            }

        }
        System.out.println(count);

//        jeśli zaczyna się na k to dodać nowej listy
        System.out.println();

        List<String> naK = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("k")) {
                naK.add(s);
            }
        }
        System.out.println("Lista elementów na k: ");
        for (String s : naK) {
            System.out.print(s+" ");

        }
        System.out.println();
//        wyświetlić długość każdego elementu listy
        System.out.println("Długość każdego elementu listy: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).length()+ ", ");
        }

//        jeśli długość elementu > 3 => dodać do nowej listy

        List<String> moreThan3_1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length()>3) {
                moreThan3_1.add(list.get(i));
            }

        }
        System.out.println(moreThan3_1);

        System.out.println();


        List<String> moreThan3_2= new ArrayList<>();
        for (String str2 : list) {
            if (str2.length()>3) {
                moreThan3_2.add(str2);
            }

        }

        System.out.println(moreThan3_2);

//        jeśli element listy kończy sie na a, obciąć i dodać do nowej listy

        List<String> obcięteOstatnieA = new ArrayList<>();

        for (String s : list) {
            if (s.endsWith("a")) {
                s = s.replace(s.substring(s.length() - 1), "");
                obcięteOstatnieA.add(s);
            }
        }
        System.out.println(obcięteOstatnieA);

//        ostatni znak
        String owoc = "jabłko";
        owoc.substring(1, owoc.length()-2);
        System.out.println(owoc.charAt(owoc.length() - 1));




    }
}
