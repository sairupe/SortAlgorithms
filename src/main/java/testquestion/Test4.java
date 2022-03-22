package testquestion;

public class Test4 {

    public static void main(String[] args) {
        new B();
    }

    static class C {
        C() {
            System.out.println("C");
        }
    }

    static class A {
        C c = new C();

        A() {
            this("A");
        }

        A(String s) {// A的有参构造函数
            System.out.println(s);
        }
    }

    static class B extends A {
        B() {
            super();
            System.out.println("B");
        }
    }
}
