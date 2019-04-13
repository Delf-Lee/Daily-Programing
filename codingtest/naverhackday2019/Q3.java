package codingtest.naverhackday2019;


public class Q3 {
    public int solution(int[] T) {
        int maxValue = T[0];
        int minValue = T[0];
        int minIndex = 0;
        int partition = 0;

        for (int i = 1; i < T.length; i++) {
            maxValue = Math.max(maxValue, T[i]);
            if (minValue >= T[i]) {
                minValue = T[i];
                minIndex = i;
            } else if (maxValue > T[i]) {
                partition = i;
                break;
            }
        }

        return Math.max(partition, minIndex) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Q3().solution(new int[]{4, -2, 3, 8, 6}));
        System.out.println(new Q3().solution(new int[]{-5, -5, -5, -42, 6, 12}));
        System.out.println(new Q3().solution(new int[]{-5, -5, 2, -5, 1, 6, 12}));
    }
}

