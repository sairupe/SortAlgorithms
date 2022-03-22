package testquestion;

public class Test1 {

    public static void main(String[] args) {
        try {
            throw new ExceptionB();
        } catch (ExceptionA e) {
            System.out.println("1");
        } catch (Exception e) {
            System.out.println("2");
        }
    }

    static class ExceptionA extends Exception {

    }

    static class ExceptionB extends ExceptionA {

    }
}
