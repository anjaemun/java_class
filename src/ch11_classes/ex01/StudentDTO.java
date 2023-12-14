package ch11_classes.ex01;

public class StudentDTO {
    private Long id;
    private String studentName;
    private String studentNumber;
    private String StudentMajor;
    private String studentMobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentMajor() {
        return StudentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        StudentMajor = studentMajor;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    private static Long idValue = 1L;

    public StudentDTO() {
        this.id = idValue;
    }

    public StudentDTO(Long id, String studentName, String studentNumber, String studentMajor, String studentMobile) {
        this.id = idValue;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        StudentMajor = studentMajor;
        this.studentMobile = studentMobile;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", StudentMajor='" + StudentMajor + '\'' +
                ", studentMobile='" + studentMobile + '\'' +
                '}';
    }
}
