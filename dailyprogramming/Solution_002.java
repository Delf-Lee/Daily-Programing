package dailyprogramming;

public class Solution_002 {
    public int getRankedElementInArray(int[] nums, int rank) {
        boolean descending = true;
        // rank가 절반 이상일 경우, 내림차순이 아닌 오름차순으로 계산해서 연산 줄임
        if (rank > nums.length / 2) {
            rank = nums.length - rank + 1;
            descending = false;
        }

        int tmp; // 스왑 변수
        for (int i = 0; i < rank; i++) { // 원하는 순서까지
            for (int j = i; j < nums.length; j++) {
                if (compare(nums[i], nums[j],descending)) { // 선택정렬 실행
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        System.out.println("loop count: " + rank);
        return nums[rank - 1];
    }

    private boolean compare(int a, int b, boolean descending) {
        return descending ? (a < b) : (a > b);
    }
}

/*
 * 사실 그냥 정렬하고 알맞은 순서의 요소를 반환해주면 될일.
 * 그래도 이러면 어찌됐든 그 정렬 알고리즘만큼의 시간복잡도가 소요되는데,
 * 이 경우에는 내가 '몇 번째 요소'를 원하는지 알고있기 때문에 반복도 그만큼만 하면 된다.
 * 가장 적합해보이는 정렬 알고리즘은 n번 돌면 n개까지 확실하게 정렬되는 선택정렬이 적합하지 않을까싶다.
 * */
