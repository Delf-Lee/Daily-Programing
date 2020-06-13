public class Q3 {
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
    }