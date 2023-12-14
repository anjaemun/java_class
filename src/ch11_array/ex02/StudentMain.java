package ch11_array.ex02;

import java.util.ArrayList;
import java.util.List;

public class StudentMain {
    // Student 클래스 객체를 담기 위한 List studentList
    // 내가 만든 Class 이름도 들어올 수 있음
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
//        studentList.add(12); X
        String studentName = "학생1";
//        studentList.add(studentName); X
        // student 객체
        Student student1 = new Student(1L, "김지갑", "20232222", "컴퓨터 공학", "010-1111-2222");
        // studentList에 추가
        studentList.add(student1);

        Student student2 = new Student(2L, "이지갑", "20233333", "실용음악", "010-3333-2222");
        studentList.add(student2);
        // studentList 0번, 1번 인덱스 각각 출력
        System.out.println("studentList = " + studentList.get(0));
        System.out.println("studentList = " + studentList.get(1));

        Student a = studentList.get(0);
        System.out.println("a = " + a);
        System.out.println("student1의 이름 : " + a.getStudentName());

        // 1번 인덱스에 담긴 객체의 학과만 출력
        System.out.println("student2의 학과 : " + studentList.get(1).getStudentMajor());

        for (Student stu : studentList) {
            System.out.println("stu = " + stu);

            // 이름만
            System.out.println("stu.getStudentName() = " + stu.getStudentName());
        }
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println("studentList = " + studentList.get(i));
            // 학생 이름만
            System.out.println("studentList = " + studentList.get(i).getStudentName());
        }
    }
}
