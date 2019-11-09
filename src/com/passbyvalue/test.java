package com.passbyvalue;

import java.util.Arrays;
import java.util.List;

public class test {

    public static void main(String[] args) {
        int a = 100;
        foo(a);
        System.out.printf("for primitive type int the value does not change: %s \n", a);

        int[] b = {1, 2, 3, 4, 5};

        System.out.printf("for non-primitive type int[](array) the value does change: \n");
        foo(b);
        for (int i : b) {
            System.out.println(i);
        }

        List c = Arrays.asList(1, 2, 3, 4, 5);

        System.out.printf("for non-primitive type List the value does change:\n");
        foo(c);
        c.forEach(i -> System.out.println(i));

    }

    public static void foo(int a) {
        a = a + 2;
    }

    public static void foo(int[] a) {
        for (int i = 0; i < a.length; i++) { //change the value
            a[i] = 10 + i;
        }

//        for (int i : a) {//does not change the value!!!
//            i=i*i;
//
//        }
    }

    public static void foo(List a) {
        for (int i = 0; i < a.size(); i++) {

            a.set(i, 20);
        }
    }
}
