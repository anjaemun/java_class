package ch12_classes.ex01;

import java.util.List;
import java.util.Scanner;

public class StudentService {
    StudentRepository studentRepository = new StudentRepository();
    Scanner sc = new Scanner(System.in);

    public void method1() {
        System.out.println("StudentService.method1");
        studentRepository.method1();
    }

    public void method2() {
        System.out.println("StudentService.method2");
        String str1 = "집에 가고 싶다.";
        studentRepository.method2(str1);
    }


    public void method3() {
        System.out.println("StudentService.method3");
        StudentDTO studentDTO = new StudentDTO("학생1", "20232222", "컴퓨터공학", "010-1111-2222");
//        StudentDTO studentDTO = new StudentDTO();
        boolean result = studentRepository.method3(studentDTO);
        System.out.println("result = " + result);
        if (result) {
            System.out.println("학생 등록 성공");
        } else {
            System.out.println("학생 등록 실패");
        }
    }

    //Repository 로부터 List를 리턴 받아 for문으로 출력
    public void method4() {
        List<StudentDTO> studentDTOList = studentRepository.method4();
        for (StudentDTO studentDTO : studentDTOList) {
            System.out.println("studentDTO = " + studentDTO);
        }
    }

    public void method5() {
        System.out.print("조회할 ID : ");
        Long id = sc.nextLong();
        StudentDTO studentDTO = studentRepository.method5(id);
        if (studentDTO != null) {
            System.out.println("studentDTO = " + studentDTO);
        } else {
            System.out.println("요청 하신 정보를 찾을 수 없습ㄴ다.");
        }
    }
}
