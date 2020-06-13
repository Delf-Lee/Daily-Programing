
public class Q2 {
    public long solution(long n) {
        String binaryString = Integer.toBinaryString((int) n);
        return toTernary(binaryString);
    }

    private static int toTernary(String binaryString) {
        final int tetraExp = 3;
        int result = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            int digit = Character.getNumericValue(binaryString.charAt(binaryString.length() - i - 1));
            result += (Math.pow(tetraExp, i) * digit);
        }
        return result;
    }
}