package codility.lesson5;

public class CountDiv {
    public int solution(int A, int B, int K) {
        return B / K - A / K + (A % K == 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        System.out.println(new CountDiv().solution(11, 345, 17));
    }
}
