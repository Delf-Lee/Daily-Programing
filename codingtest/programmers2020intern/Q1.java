package test;

import java.util.*;

public class Qone {
    /*public int solution(int p) {
        int year = p;
        while (year <= 10000) {
            String s = Integer.toString(++year);
            HashSet<Integer> set = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
            for (char c : s.toCharArray()) {
                if(!set.remove(Integer.parseInt(String.valueOf(c)))) {
                    break;
                }
            }
            System.out.println(set);
            if (set.size() == 6) {
                return year;
            }
        }
        throw new IllegalArgumentException();
    }*/

    /*public long solution(long n) {
        String binaryString = Integer.toBinaryString((int) n);
        return toTernary(binaryString);
    }

    private static int toTernary(String binaryString) {
        final int tetraExp = 3;
        int result = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            int digit = Character.getNumericValue(binaryString.charAt(binaryString.length() - i - 1));
            result += (Math.pow(tetraExp, i) * digit);
        }
        return result;
    }*/

    public int[] solution(int total_sp, int[][] skills) {
        int[] answer = {};
        SkillTree skillTree = new SkillTree();
        for (int i = 0; i < skills.length; i++) {
            for (int j = 0; j < skills[i].length; j++) {
                Skill upperSkill = new Skill(i);
                Skill subSkill = new Skill(upperSkill, j);
                skillTree.addSkill(subSkill);
            }
            System.out.println(skillTree);
        }

        int nodeCount = skillTree.getNodeCount();
        int sp = total_sp / nodeCount;

        return answer;
    }

    static public class SkillTree {
        private Skill head;

        public int getSum() {
            return head.getSum();
        }

        public int getNodeCount() {
            return head.getNodeCount();
        }

        public void addSkill(Skill skill) {
            if (Objects.isNull(head)) {
                this.head = skill;
            }
            head.addSubSkill(skill.upperSkill);
        }

        @Override
        public String toString() {
            return "SkillTree{" +
                    "head=" + head +
                    '}';
        }
    }

    static public class Skill {
        private int value;
        private Skill upperSkill;
        private Set<Skill> subSkills = new HashSet<>();

        public void addSubSkill(Skill skill) {
            if (isCorrectValue(skill)) {
                subSkills.add(skill);
                return;
            }

            for (Skill s : subSkills) {
                s.addSubSkill(s);
            }
        }

        public Skill(int value) {
            this.value = value;
        }

        public Skill(Skill upperSkill, int value) {
            this.value = value;
            this.upperSkill = upperSkill;
        }

        public boolean isCorrectValue(Skill skill) {
            return this.value == skill.value;
        }

        public int getSum() {
            if (subSkills.isEmpty()) {
                return value;
            }
            return subSkills.stream().mapToInt(Skill::getSum).sum();
        }

        public int getNodeCount() {
            if (subSkills.isEmpty()) {
                return 0;
            }
            return subSkills.size() + 1;
        }

        @Override
        public String toString() {
            return "Skill{" +
                    "value=" + value +
                    ", upperSkill=" + upperSkill +
                    ", subSkills=" + subSkills +
                    '}';
        }
    }

    public static void main(String[] args) {
        Random random = new Random();

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < 37; i++) {
            set.add(i);
        }

        int days = 8;
        int bingoTryCnt = days * 9;
        int targetMissCnt = 40;
        int targetHitCnt = 36;
        int targetMissCntReal = 0;
        int targetHitCntReal = 0;
        int totalMissCnt = 0;
        int totalHitCnt = 0;
        int testCase = 10000000;
        int clearCnt = 0;

        for (int j = 0; j < testCase; j++){
            int missCnt = 0;
            int hitCnt = 0;
            Set<Integer> tmpSet = new HashSet<>(set);
            for (int i = 0; i < bingoTryCnt; i++) {
                if(!tmpSet.remove(random.nextInt(36) + 1)) {
                    missCnt++;
                } else {
                    hitCnt++;
                }
            }
            if(missCnt <= targetMissCnt) {
                targetMissCntReal++;
            }

            if (hitCnt >= targetHitCnt) {
                targetHitCntReal++;
            }

            if(tmpSet.isEmpty()) {
                clearCnt++;
            }
            totalMissCnt += missCnt;
            totalHitCnt += hitCnt;
        }
        System.out.println("## DAY " + days + " ##");
        System.out.println(">> assumption value of bingo try count: " + bingoTryCnt);
        System.out.println(">> assumption value of bingo miss count: " + targetMissCnt);
        System.out.println(">> test try count: " + testCase);


        System.out.println("total miss count = " + totalMissCnt);
        System.out.println("miss average = " + totalMissCnt / testCase);

        System.out.println("total hit count = " + totalHitCnt);
        System.out.println("hit average = " + totalHitCnt / testCase);

        /*System.out.println("clear count = " + clearCnt);
        System.out.println(String.format("clear ratio = %.2f%%", ((double) clearCnt / (double) testCase) * 100));*/

        System.out.println(String.format("number of test case that less %d missed = %d", targetMissCnt, targetMissCntReal));
        System.out.println(String.format("ratio fail target = %.2f%%", ((double) targetMissCntReal / (double) testCase) * 100));

        System.out.println(String.format("number of test case that more %d hit = %d", targetHitCnt, targetHitCntReal));
        System.out.println(String.format("ratio fail target = %.2f%%", ((double) targetHitCntReal / (double) testCase) * 100));
    }
}
