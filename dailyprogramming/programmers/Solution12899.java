public class Solution12899 {
    public static void main(String[] args) {
        System.out.println(new Solution12899().solution(7));
    }

    public String solution(int n) {
        String s = conversion(n, 3);
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(ch == '2' ? "4" : "1");
        }
        return sb.toString();
    }

    public static String conversion(int n, int num) {
        String retVal = "";
        if (num == 0) retVal = "0";
        while (num != 0) {
            retVal = (num % n < 10 ? Integer.toString(num % n) : Character.toString((char) (num % n + 55))) + retVal;
            if (num / n == 0) retVal = num + retVal;
            num = num / n;
        }
        return retVal;
    }
}
