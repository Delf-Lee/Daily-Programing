package codingtest.zum;

/**
 * @author delf
 */
public class Q3_StringTransform {
    public String solution(String S) {
        StringBuilder sb = new StringBuilder(S);
        for (int i = 1; i < sb.length(); i++) {
            try {
                if (sb.charAt(i - 1) == sb.charAt(i)) {
                    sb.delete(i - 1, i + 1);
                    i -= 2;
                }
            } catch (StringIndexOutOfBoundsException e) {
                // 0이하의 인덱스를 참조할 때 무시한다.
                // 무시해도 문제가 없다.
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q3_StringTransform().solution("ACCAABBC"));
    }
}
