@FunctionalInterface
interface Webstar{
    void destroyStuff();
}

public class Test {
    public static void main(String[] args) {
        Webstar web = () -> {
            System.out.println();
        };
    }
}
