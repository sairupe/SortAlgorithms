package testquestion;

public class Test3 {

    public static void main(String[] args) {

    }

    interface A {
        int x = 2;
    }

    static class B {
        int x = 2;
    }

    static class C extends B implements A {
        public void px(){
            //System.out.println(x); compile ERROR
        }
    }
}
