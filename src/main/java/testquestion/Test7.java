package testquestion;

public class Test7 {
    public static void main(String[] args) {
        new Child("milk");
    }

    static class People {
        String name;

        public People() {
            System.out.println(1);
        }

        public People(String name) {
            System.out.println(2);
            this.name = name;
        }
    }

    static class Child extends People {
        People father;

        public Child(String name) {
            System.out.println(3);
            this.name = name;
            father = new People(name + ":F");
        }

        public Child() {
            System.out.println(4);
        }
    }
}
