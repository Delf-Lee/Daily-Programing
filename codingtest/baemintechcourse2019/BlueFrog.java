package codingtest.baemintechcourse2019;

/**
 * @author delf
 */
public class BlueFrog {

    public String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                sb.append((char) ('z' + ('a' - c)));
            } else if (Character.isUpperCase(c)) {
                sb.append((char) ('Z' + ('A' - c)));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new BlueFrog().solution("I love you"));
    }
}

