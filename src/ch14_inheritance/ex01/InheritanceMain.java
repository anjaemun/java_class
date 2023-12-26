package ch14_inheritance.ex01;
public class InheritanceMain {
    public static void main(String[] args) {
        ParentClass parentClass = new ParentClass();
        parentClass.setName("name1");
        parentClass.setAge(10);
        System.out.println("parentClass = " + parentClass);
        parentClass.hello();

        ChildClass childClass = new ChildClass();
        // 상속 받았기 때문에 자식 클래스에서 get, set 메서드 사용 가능.
        childClass.setName("childName1");
        childClass.setAge(20);
        System.out.println("childClass = " + childClass);
        childClass.hello();

        // 좌변 : 부모 타입의 객체, 우변 : 자식 클래스 생성자
        ParentClass parentClass1 = new ChildClass();
        parentClass1.hello();
        parentClass1 = new ParentClass();
        parentClass1.hello();
        // 좌변 : 자식 타입의 객체, 우변 : 부모 클래스 생성자
//        ChildClass childClass1 = (ChildClass) new ParentClass();
    }
}
