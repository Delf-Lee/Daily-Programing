import java.util.Arrays;

// 책상 배치가 주어졌을때 둘레를 구하라
public class Solution6 {
    public static void main(String[] args) {
        System.out.println(new Solution6().solution("0 0 0 0;0 1 1 0;0 0 1 0;0 0 0 0")); // 8
        System.out.println(new Solution6().solution("000000;011110;000000;000010;000110;001110;000000")); // 22
    }

    public int solution(String q) {
        String[] bluePrint = q.split(";");

        int tableCount = 0;
        int tangentCount = 0;
        for (int j = 0; j < bluePrint.length; j++) {
            bluePrint[j] = bluePrint[j].replace(" ", "");
            char[] array = bluePrint[j].toCharArray();
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] == '1') {
                    if (bluePrint[j - 1].charAt(i) == '1') {
                        tangentC    ount++;
                    }
                    tableCount++;
                    if (array[i] == array[i + 1]) {
                        tangentCount++;
                    }
                }
            }
        }
        return (tableCount * 4) - (tangentCount * 2);
    }
}
