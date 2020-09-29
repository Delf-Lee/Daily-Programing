public class Solution62048 {
    public static void main(String[] args) {
        System.out.println(new Solution62048().solution(8, 12));
    }

    public long solution(int w, int h) {
        long bigger = Math.max(w, h);
        long smaller = Math.min(w, h);
        long ratio = bigger / smaller;
        ratio = ratio % smaller == 0 ? ratio : ratio + 1;

        return (w * h) - ratio * smaller;
    }
}
