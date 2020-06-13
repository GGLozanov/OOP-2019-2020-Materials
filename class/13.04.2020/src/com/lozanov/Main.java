package com.lozanov;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // Test<String> test2 = new Test<>(); -> doesn't run
        Payload<Number> payload = new Payload<>(15);
        Package pack = new Package(payload);

        System.out.println(pack);
    }
}
