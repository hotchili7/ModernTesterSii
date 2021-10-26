package kolekcje;

import java.util.*;

public class Main2 {

//    tutaj w psvm możemy tylko wywoływać metody

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("paproć");
        list.add("doniczka");
        list.add("telefon");
        list.add("Zszywacz");
        list.add("54658");

        System.out.println(list.size());
        System.out.println(list.get(2).length());

        int count = 0;
        for (String s : list) {

            if (s.startsWith("Z")) {
                count++;
            }
        }
        System.out.println("Ilość wyrazów " + count);

// usunąć element z listy
        list.remove(4);
        System.out.println(list);

        list.add("63546541");

        System.out.println(list.get(4));

//        int i = Integer.parseInt(list.get(4));

        System.out.println(list.get(4).getClass());

//        jeśli dł elem > 3 => remove

        for (String s : list) {
            if (s.length()>=3) {
                s.replace(s, "");
            }
        }
        System.out.println(list);

        System.out.println("pozostało? ");

        for (int i = 0; i < list.size(); i++) {

            if(list.get(i).length()>3) {
                list.remove(i);
            }
        }

        System.out.println(list);


        List<String> owoce = new ArrayList<>();

        owoce.add("jadłko");
        owoce.add("kiwi");
        owoce.add("malina");
        owoce.add("truskawaka");
        owoce.add("wiśnia");
        owoce.add("pomarańcz");


//        dodać elementy list do owoce

        owoce.addAll(list);
        System.out.println(owoce);



//        dodać do listy co drugi znak każdego z listy owoce

        List<Character> newOneList = new ArrayList<>();

        for (int i = 0; i < owoce.size(); i++) {
            for (int j = 1; j < owoce.get(i).length(); j=j+2) {
                newOneList.add(owoce.get(i).charAt(j));

            }

        }
        System.out.println("new " + newOneList);


        List<Integer> intergerList = new ArrayList<>();

        intergerList.add(354);
        intergerList.add(65);
        intergerList.add(3);
        intergerList.add(76);
        intergerList.add(356635);

        System.out.println(intergerList);

List<Integer> lessThan100 = new ArrayList<>();
        for (Integer integer : intergerList) {
            if (integer < 100) {
                lessThan100.add(integer);
            }
        }
        System.out.println(lessThan100);


        List<Integer> divideBy3 = new ArrayList<>();

        for (Integer integer : intergerList) {
            if (integer%3==0){
                divideBy3.add(integer);
            }
        }

        System.out.println(divideBy3);

//        suma wszystkich elementów listy integer list

        int sum = 0;

        for (int i = 0; i < intergerList.size(); i++) {
            sum = sum + intergerList.get(i);
        }

        System.out.println(sum);



//        jeśli <200 => pomnożyć x2 i dodać do nowej listy, a jeśli jest >= 200 podzielić przez 5 i dodać do nowej listy

        List<Integer> lessThan200 = new ArrayList<>();

        List<Double> moreThan200 = new ArrayList<>();

        for (Integer integer : intergerList) {
            if (integer<200) {
                lessThan200.add(integer*2);
            } else {
                moreThan200.add((double) (integer/5));
            }
        }

        System.out.println("Mniejsza niż 200*2: " + lessThan200);
        System.out.println("Większa niż 200 /5: " + moreThan200);

//        sortowanie listy owoce

//        ZADANIE DOMOWE -- toLowercase i posortować

        List<String> noweOwoce = new ArrayList<>();
        noweOwoce.addAll(owoce);
        Collections.sort(noweOwoce);
        for (String s : noweOwoce) {
            s.toLowerCase(Locale.ROOT);
        }

        System.out.println(noweOwoce);
        System.out.println(owoce);


        Collections.sort(intergerList);
        System.out.println(intergerList);

        Collections.reverse(intergerList);
        System.out.println(intergerList);




//        -----------
        List<String> fruits = new ArrayList<>();

        fruits.add("malina");
        fruits.add("rak");
        fruits.add("gruszka");
        fruits.add("sliwka");
        fruits.add("wisnia");
        fruits.add("wisnia");
        fruits.add("kot");
        fruits.add("osa");


//        for (int i = 0; i < fruits.size(); i++) {
//            if (fruits.get(i).length()==3) {
//                fruits.remove(i);
//            }
//
//        }

        for (int i = fruits.size()-1; i > 0; i--) {
            if (fruits.get(i).length() == 3) {
                fruits.remove(i);
            }

        }

        System.out.println("Fruits: " + fruits);


//        policzyć długość każdego stringa na liście i posortowac po długości ZADANIE

        noweOwoce.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        System.out.println(noweOwoce);

        System.out.println("Czy liczba jest pierwsza?  ");
        System.out.println(isPrime(13));
    }

//    sprawdzanie czy liczba jest l pierwszą

    public static boolean isPrime(int n) {
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}