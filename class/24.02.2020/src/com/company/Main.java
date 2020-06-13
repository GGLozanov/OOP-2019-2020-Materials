package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main.strings();
        Main.boxedTypes();
    }

    static void strings() {
        String str1 = "asdf";

        String str2 = str1 + 123 + 234 + true;

        System.out.println(str1 == str2); // compares references
        System.out.println(str1.equals(str2)); // compares content
        System.out.println(str1.compareTo(str2)); // strcmp()

        System.out.println(str1);

        System.out.println(str1.contains("a"));
        System.out.println(str1.indexOf('x'));
        System.out.println(str1.hashCode());
        System.out.println(str2.length());
    }

    static void boxedTypes() {
        int a = new Integer(5); // primitives and boxed classes are coalesced
        String a2 = ((Integer)a).toString(); // boxing and unboxing
        System.out.println(a);
    }

    static void stringWithLessOverhead() {
        StringBuilder stringBuilder = new StringBuilder("string"); // expanded StringBuffer
        StringBuffer stringBuffer = new StringBuffer("buffer"); // string which can be changed
        // these classes are faster
    }
}
