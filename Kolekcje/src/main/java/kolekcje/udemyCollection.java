package kolekcje;

import java.util.ArrayList;
import java.util.Collection;

public class udemyCollection {

    public static void main(String[] args) {

        Collection b;
        ArrayList a = new ArrayList();

        a.add(new String("lala"));
        a.add(new Integer(2422));

        for (int i = 0; i < a.size(); i++) {
            System.out.println((String) a.get(i));


        }


        class Zwykła <COKOLWIEK>
        {
            public COKOLWIEK zwróc() {
                return this.nazwaZmiennejTypuCokolwiek;
            }
            COKOLWIEK nazwaZmiennejTypuCokolwiek;
        }



    }
}
