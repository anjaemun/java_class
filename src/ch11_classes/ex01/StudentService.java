package ch11_classes.ex01;

public class StudentService {
    StudentRepository studentRepository = new StudentRepository();

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
    }
}
