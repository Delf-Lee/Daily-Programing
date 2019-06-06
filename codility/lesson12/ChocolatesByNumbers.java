package codility.lesson12;

class ChocolatesByNumbers {
    // https://app.codility.com/demo/results/trainingT7SUVZ-YBD/
    public int solution(int N, int M) {
        return N / gcd(N, M); // lcm
    }

    public static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(new ChocolatesByNumbers().solution(10, 3));
    }
}

