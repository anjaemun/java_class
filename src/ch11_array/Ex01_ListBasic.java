package ch11_array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Ex01_ListBasic {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
//        ArrayList<Integer> intList2 = new ArrayList<>();
        // intList에 10이라는 데이터 추가
        intList.add(10);
        //intList 의 크기 출력
        System.out.println("intList.size() = " + intList.size());
        intList.add(100);
        // intList 1번 인덱스에 99 데이터 추가
        intList.add(1, 99);
        // intList 1번 인덱스 삭제
        intList.remove(1);

        System.out.println("intList.size() = " + intList.size());
        System.out.println("intList.get(0) = " + intList.get(0));
        System.out.println("intList.get(0) = " + intList.get(1));

        List<String> strList = new ArrayList<>();
        strList.add("안녕");
        strList.add(1, "hello");
        System.out.println("strList.get(0) = " + strList.get(0));
        System.out.println("strList.get(0) = " + strList.get(1));
        String str1 = strList.get(1);
        System.out.println("str1 = " + str1);

        // for문을 이용 하여 intList에 담긴 데이터 모두 출력
        for (int i = 0; i < intList.size(); i++) {
            System.out.println("intList" + "(" + i + ")" + " = " + intList.get(i));
        }
        // for each
        for (int a : intList) {
            System.out.println("a = " + a);
        }

        intList.forEach(a -> {
            System.out.println("a = " + a);
        });

        // for문을 이용 하여 strList에 담긴 데이터 모두 출력
        for (int i = 0; i < strList.size(); i++) {
            System.out.println("strList" + "(" + i + ")" + " = " + strList.get(i));
        }

        for (String a : strList) {
            System.out.println("a = " + a);
        }
    }
}



