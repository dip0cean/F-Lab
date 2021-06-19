package collection;

import java.io.StringWriter;
import java.util.Scanner;

public class HashSetTest {
//    public static void main(String[] args) {
//        Object[]        objArray = {"1", new Integer(1), "2", "2", "3", "4", "4", "4"};
//        HashSet<Object> hashSet  = new HashSet<>();
//
//        for (Object obj : objArray) {
//            System.out.println("현재 값 : " + obj +  " / 할당 여부 " + hashSet.add(obj));
//        }
//
//        System.out.println(hashSet);
//    }

    public static void main(String[] args) {
//        int[] arr = {42, 84, 252, 420, 840, 126, 42, 84, 420, 126};
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] arr   = {39, 40, 41, 42, 43, 44, 82, 83, 84, 85};
        Scanner   sc    = new Scanner(System.in);
        int[]     arr   = new int[10];
        boolean[] len   = new boolean[42];
        int       count = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            len[arr[i] % 42] = true;
        }

        for (boolean bol : len) {
            if (bol) count += 1;
        }

        System.out.println(count);
    }
}
