package backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Grade[] grades = new Grade[sc.nextInt()];
        for (int i = 0; i < grades.length; i++) {
            grades[i] = new Grade(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(grades, new Comparator<Grade>() {
            @Override
            public int compare(Grade g1, Grade g2) {
                if (g1.kor == g2.kor) {
                    if (g1.eng == g2.eng) {
                        if (g1.mth == g2.mth) return g1.name.compareTo(g2.name);
                        return Integer.compare(g2.mth, g1.mth);
                    }
                    return Integer.compare(g1.eng, g2.eng);
                }
                return Integer.compare(g2.kor, g1.kor);
            }
        });

        for (int i = 0; i < grades.length; i++) {
            System.out.println(grades[i].name);
        }
    }
}

class Grade {
    String name;
    int kor;
    int eng;
    int mth;

    public Grade(String name, int kor, int eng, int mth) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mth = mth;
    }
}