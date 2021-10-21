package Arrays_.sortClass;

import java.util.Arrays;

public class SortForClass {
    public static void main(String[] args) {
        Car01 benz = new Car01(240, "Benz");
        Car01 hong = new Car01(230, "Hong");
        Car01 bmw = new Car01(230, "BMW");

        Car02 Benz = new Car02(240, "Benz");
        Car02 Hong = new Car02(230, "Hong");
        Car02 Bmw = new Car02(220, "BMW");

        Car01[] car01s = new Car01[3];
        car01s[0] = benz;
        car01s[1] = hong;
        car01s[2] = bmw;

        Car02[] car02s = new Car02[3];
        car02s[0] = Benz;
        car02s[1] = Hong;
        car02s[2] = Bmw;

        Arrays.sort(car01s);
        Arrays.sort(car02s);

        for (int i = 0; i < car01s.length; i++) {
            System.out.println(car01s[i].toString());;
        }
        System.out.println(benz.compareTo(hong));// return 1
        System.out.println(hong.compareTo(benz));// return -1
        System.out.println(bmw.compareTo(hong)); // return 0;
        System.out.println("=========================");

        for (int i = 0; i < car02s.length; i++) {
            System.out.println(car02s[i].toString());;
        }
        System.out.println(Benz.compareTo(Hong));// return 1
        System.out.println(Hong.compareTo(Benz));// return -1
        System.out.println(Bmw.compareTo(Benz)); // return ;
    }
}
