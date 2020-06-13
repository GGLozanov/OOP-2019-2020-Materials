package com.lozanov;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        OuterClass o = new OuterClass(4);
        o.sayHello();

        OuterClass.PublicInnerClass o1 = o.new PublicInnerClass(); // needs an instance because it's not static

        OuterClass.StaticPublicInnerClass o2 = new OuterClass.StaticPublicInnerClass(); // it's okay because it's static

        o.anonymousClass(new RandomInterface() {
            @Override
            public void doSomething() {

            }
        });

        Collections.sort(new ArrayList<Integer>(), new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return 0;
            }
        });

        Customer.CustomerBuilder customerBuilder = new Customer.CustomerBuilder("Ivan", "Wazovski", "089282481");
        Customer customer = customerBuilder.address("sda").build();
    }
}
