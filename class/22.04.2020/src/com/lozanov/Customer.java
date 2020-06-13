package com.lozanov;

public class Customer {
    private String firstName;
    private String lastName;
    private String SSN;
    private String address;
    private String money;
    private int age;
    private String email;
    private char sex;

    public Customer(CustomerBuilder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        SSN = builder.SSN;
        address = builder.address;
        money = builder.money;
        age = builder.age;
        email = builder.email;
        sex = builder.sex;
    }

    public static class CustomerBuilder {
        private String firstName; // mandatory
        private String lastName; // mandatory
        private String SSN; // mandatory
        private String address;
        private String money;
        private int age;
        private String email;
        private char sex;

        public CustomerBuilder(String firstName, String lastName, String SSN) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.SSN = SSN;
        }

        public CustomerBuilder address(String address) {
            this.address = address;
            return this;
        }

        public CustomerBuilder money(String money) {
            this.money = money;
            return this;
        }

        public CustomerBuilder age(int age) {
            this.age = age;
            return this;
        }

        public CustomerBuilder email(String email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder money(char sex) {
            this.sex = sex;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }

    }


}
