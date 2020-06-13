package com.lozanov;

public class OuterClass {

    private int number;

    public OuterClass(int number) {
        this.number = number;
    }

    public void sayHello() {
        System.out.println("Hello!");
    }

    private class InnerClass {
        public void saySomething() {
            System.out.println("I am an inner class and my outer class number is " + number);
        }
    }

    public class PublicInnerClass {
        public void saySomething() {
            System.out.println("I am a public inner class and my outer class number is " + number);
        }
    }

    public static class StaticPublicInnerClass {
        public void saySomething() {
            System.out.println("I am a static public inner class");
        }
    }

    public void someCrazyShit() {
        class InnerCrazyShitClass {
            public void saySomething() {
                System.out.println("I am an inner class in a method and my outer class number is " + number);
            }
        }

        InnerCrazyShitClass crazy = new InnerCrazyShitClass();
        crazy.saySomething();
    }

    public void anonymousClass(RandomInterface ri) {
        ri.doSomething();
    }
}
