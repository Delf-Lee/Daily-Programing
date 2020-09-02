import java.util.*;

public class Solution42627 {

    public static void main(String[] args) {
        System.out.println(new Solution42627().solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }

    public int solution(int[][] jobs) {
        List<Disk> list = new ArrayList<>();
        for (int[] job : jobs) {
            list.add(new Disk(job[0], job[1]));
        }
        list.sort(Comparator.comparingInt(disk -> disk.processTime));

        int time = 0;
        int sum = 0;

        while (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (time >= list.get(i).requestTime) {
                    time += list.get(i).processTime;
                    sum += time - list.get(i).requestTime;
                    list.remove(i);
                    break;
                }

                if (i == list.size() - 1) time++;
            }
        }

        return sum / jobs.length;
    }

    class Disk {
        public int requestTime;
        public int processTime;

        public Disk(int requestTime, int processTime) {
            this.requestTime = requestTime;
            this.processTime = processTime;
        }
    }
}
