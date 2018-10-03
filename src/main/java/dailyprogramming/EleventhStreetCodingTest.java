package Temporary;

import java.util.StringTokenizer;

public class EleventhStreetCodingTest {
    // '.', '?', '!' 을 문장의 기준으로 할 때, 문장들 중 최대 단어 수는 몇 개?
    public int solution2(String S) {
        StringTokenizer st1 = new StringTokenizer(S, ".|?|!");
        int max = 0;
        while (st1.hasMoreTokens()) {
            int cnt = 0;
            String s = st1.nextToken();
            StringTokenizer st2 = new StringTokenizer(s, " ");
            while (st2.hasMoreTokens()) {
                st2.nextToken();
                cnt++;
            }
            if (cnt > max) {
                max = cnt;
            }
        }
        return max;
    }

    // 동전이 모두 같은 방향을 보게하려고 한다. 뒤집어야 할 최소 횟수는 몇 번?
    public int solution3(int[] A) {
        int cnt[] = {0, 0};
        for (int i : A) cnt[i]++;
        return cnt[0] > cnt[1] ? cnt[1] : cnt[0];
    }


    // 배열 A[0]에서 value값을 index로 하여 계속 엑세스 했을 때, -1이 나오기 전까지 몇번 엑세스?
    public int solution1(int[] A) {
        int cnt = 0, i = 0;
        while ((i = A[i]) != -1) cnt++;
        return cnt;
    }
}
