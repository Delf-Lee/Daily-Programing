package codility.lesson10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author delf
 */
public class Flags {
    // https://app.codility.com/demo/results/trainingKWS6GB-F7W/
    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (Integer.max(A[i - 1], A[i + 1]) < A[i]) {
                peaks.add(i);
            }
        }

        if (peaks.size() < 3) {
            return peaks.size();
        }

        int result = 0;
        for (int k = 2; k <= peaks.size(); k++) {
            int flags = 1;
            int peak = 0;
            int nextPeak = 1;
            for (int i = 0; i < peaks.size() - 1; i++) {
                if (Math.abs(peaks.get(peak) - peaks.get(nextPeak)) >= k) {
                    flags++;
                    peak = nextPeak;
                    nextPeak = peak + 1;
                } else {
                    nextPeak++;
                }
                if(nextPeak == peaks.size() || flags == k) {
                    break;
                }
            }
            if(result > flags) {
                return result;
            }
            result = Math.max(flags, result);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Flags().solution(new int[]{1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
    }
}