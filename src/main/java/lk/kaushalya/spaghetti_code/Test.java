package lk.kaushalya.spaghetti_code;

class BadCode {
    public void doSomething(int marks) {

        if (marks >= 50) {
            if (marks >= 75) {
                System.out.println("A");
            } else {
                if (marks >= 60) {
                    System.out.println("B");
                } else {
                    if (marks >= 50) {
                        System.out.println("C");
                    } else {
                        System.out.println("S");
                    }
                }
            }
        } else {
            System.out.println("F");
        }
    }
}

class AntiPattern {
    public void doSomething(int marks) {
        if(marks>= 75) {
            System.out.println("A");
        } else if(marks >= 60) {
            System.out.println("B");
        } else if(marks >= 50) {
            System.out.println("C");
        } else if(marks >= 40) {
            System.out.println("S");
        } else {
            System.out.println("F");
        }
    }
}

public class Test {
    public static void main(String[] args) {
        BadCode badCode = new BadCode();
        badCode.doSomething(80);

        AntiPattern antiPattern = new AntiPattern();
        antiPattern.doSomething(80);
    }
}
