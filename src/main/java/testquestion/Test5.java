package testquestion;

public class Test5 {
    public static void main(String[] args) {
        String a = "a";
        change(a);
        System.out.println(a);
    }

    public static void change(String s) {
        s = "aaa";
    }
}
