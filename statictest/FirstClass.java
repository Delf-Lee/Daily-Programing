package statictest;

/**
 * @author delf
 */
public class FirstClass {
    public String field;

    public void setInnerClassField(String s) {
        InnerClassOfFirst.field = s;
    }

    public static class InnerClassOfFirst {
        public static String field;
    }
}
