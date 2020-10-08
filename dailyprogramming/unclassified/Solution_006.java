package unclassified;

public class Solution_006 {
    public String getSecondValue(int[] arr) {
        int tmp;
        int cnt = 0;
        for (int i = 0; i < 2; i++) { // 2회까지
            for (int j = i; j < arr.length; j++) {
                cnt++;
                if (arr[i] < arr[j]) { // 선택정렬 실행
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println("cnt = " + cnt);
        return (arr[0] == arr[1]) ? "Dose not exist" : Integer.toString(arr[1]);
    }
}