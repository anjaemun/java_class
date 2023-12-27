package ch12_classes.ex01;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private static List<StudentDTO> studentDTOList = new ArrayList<>();

    public void method1() {
        System.out.println("StudentRepository.method1");
    }

    public void method2(String str1) {
        System.out.println("str1 = " + str1);
    }

    public boolean method3(StudentDTO studentDTO) {
//        if (studentDTO.getId() == null) {
//            System.out.println("큰일 났다.");
//        }
        System.out.println("studentDTO = " + studentDTO);
//        boolean result = studentDTOList.add(studentDTO);
//        return result;
        return studentDTOList.add(studentDTO);
    }

    public List<StudentDTO> method4() {
        return studentDTOList;
    }

    public StudentDTO method5(Long id) {
        StudentDTO studentDTO = null;
        for (int i = 0; i < studentDTOList.size(); i++) {
            if (id.equals(studentDTOList.get(i).getId())) {
                studentDTO = studentDTOList.get(i);
            }
        }
        return studentDTO;
    }
}

