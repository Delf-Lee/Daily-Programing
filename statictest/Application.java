package statictest;

/**
 * @author delf
 */
public class Application {
    static FirstClass firstClass = new FirstClass();
    static FirstClass firstClass1 = new FirstClass();
    public static void main(String[] args) {
        firstClass.field = "1";
        firstClass1.field = "2";
        System.out.println(firstClass.field);
        System.out.println(firstClass1.field);

    }
}
