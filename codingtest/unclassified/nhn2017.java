package codingtest.unclassified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class nhn2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Ground[] grounds = new Ground[Integer.parseInt(br.readLine()) + 1];
        int[] input;
        grounds[0] = new Ground(0, 0, Integer.MAX_VALUE);
        for (int i = 1; i < grounds.length; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            grounds[input[0]] = new Ground(input[1], input[2], input[3]); // 0:index, 1:x, 2:y, 3:r
            // grounds[input[0]].in(0);
        }
        int[] spot = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        /*if (spot[0] == spot[1]) {
            System.out.println(spot[0] + " " + spot[1]);
        }*/
        // Arrays.sort(grounds, Collections.reverseOrder());
        System.out.println(Arrays.toString(grounds));
        for (int i = 0; i < spot.length; i++) {
            for (int j = 1; j < grounds.length; j++) {
//                System.out.printf("path[%d](%d) == %d, spot[%d]==spot[%d](%d)\n", i, spot[i], j, (i + 1) % 2, i, spot[i]);
                if (spot[i] == j) {
//                    System.out.println("continue");
                    continue;
                }
                /*else if (spot[(i + 1) % 2] == j) {
                    System.out.println("break");
                    continue;
                }*/
                int bigger = grounds[spot[i]].r > grounds[j].r ? spot[i] : j; // 반지름이 더 큰 Ground 인덱스
                int smaller = grounds[spot[i]].r < grounds[j].r ? spot[i] : j; // 반지름이 더 작은 Ground 인덱스
                int r1 = grounds[bigger].r;
                int r2 = grounds[smaller].r;
                double d = grounds[spot[i]].getDist(grounds[j]);
                System.out.printf("bigger=%d(r1=%d), smaller=%d(r2=%d), %d > d=%f\n", bigger, r1, smaller, r2, r1 - r2, d);
                if (r1 - r2 > d) {
                    System.out.println("add");
                    grounds[smaller].in(bigger);
                }
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (Integer i : grounds[spot[0]].getPathOut()) {
            if(i == spot[1]) break;
        }
        for (Integer i : grounds[spot[0]].getPathOut()) {
            if(i == spot[0]) break;
                answer.add(i);
        }

        /*answer.add(spot[0]); // 출발
        answer.addAll(grounds[spot[0]].getPathOut()); // 출발에서 바깥으로
        // answer.add(999);
        answer.addAll(grounds[spot[1]].getPathIn()); // 바깥에서 도착지점으러
        answer.add(spot[1]);*/

        for (Integer i : answer) {
            System.out.print(i + " ");
        }
    }
}

class Ground implements Comparable<Ground> {
    int x, y;
    int r;
    List<Integer> outGround = new ArrayList<>(); // 자신을 포함하고 있는 Ground의 index

    public Ground(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double getDist(Ground ground) {
        return Math.sqrt(Math.pow(ground.x - this.x, 2) + Math.pow(ground.y - this.y, 2));
    }

    public void in(int gi) {
        if (!outGround.contains(gi)) {
            outGround.add(gi);
        }
    }

    public List<Integer> getPathOut() {
        outGround.sort(Collections.reverseOrder());
        return outGround;
    }

    public List<Integer> getPathIn() {
        Collections.sort(outGround);
        return outGround;
    }

    @Override
    public String toString() {
        return String.valueOf(r);
        // return String.valueOf(outGround);
    }

    /*@Override
    public int compare(Ground o1, Ground o2) {

    }*/

    @Override
    public int compareTo(Ground o) {
        return Integer.compare(r, o.r);
    }
}

/*for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int bigger = grounds[i].r > grounds[j].r ? i : j;
                int smaller = grounds[i].r < grounds[j].r ? i : j;
                int r1 = grounds[bigger].r;
                int r2 = grounds[smaller].r;
                double d = grounds[i].getDist(grounds[j]);
                if (r1 - r2 > d) {
                    grounds[smaller].in(bigger);
                }
            }
        }*/

/*public Ground(String[] input) {
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);
    }*/

/*int[] idxs = getSortIndexArr(i, j); // 0: smaller, 1: bigger
                int r1 = grounds[idxs[1]].r;
                int r2 = grounds[idxs[0]].r;
                double d = grounds[i].getDist(grounds[j]);
                if (r1 - r2 > d) {
                    grounds[idxs[0]].in(idxs[1]);
                }*/

/*public static int[] getSortIndexArr(int i, int j) {
        int[] arr = {i, j};
        Arrays.sort(arr);
        return arr;
    }*/

