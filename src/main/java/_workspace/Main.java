package _workspace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Student[] arr = new Student[5];
        List<Student> list = new ArrayList<>();

        arr[0] = new Student("A", 26, "컴퓨터공학");
        arr[1] = new Student("B", 24, "컴퓨터공학");
        arr[2] = new Student("C", 27, "기계공학");
        arr[3] = new Student("D", 21, "컴퓨터공학");
        arr[4] = new Student("E", 20, "기계공학");

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        Arrays.sort(arr);
        Collections.sort(list);

        System.out.println("* Plaint array print");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("\n* ArrayList print");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Grade[] grades = new Grade[3];
        grades[0] = new Grade("aa");
        grades[1] = new Grade("cc");
        grades[2] = new Grade("bb");

        Arrays.sort(grades);
        for (int i = 0; i < grades.length; i++) {
            System.out.println(grades[i].name);
        }

    }
}

class Grade implements Comparable<Grade>{
    public String name;

    public Grade(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Grade o) {
        return 0;
    }
}

class Student implements Comparable<Student> {
    public String name;
    public int age;
    public String department;

    public Student(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.age, o.age);
        // return this.age - o.age;
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}
