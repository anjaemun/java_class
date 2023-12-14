package ch11_array.ex03;

import java.util.ArrayList;
import java.util.List;

public class BookMain {
    // Book 객체를 담기위한 bookList 객체 선언

    // 기본생성자로 Book 객체(book1) 생성 후 bookList에 추가

    // 매개변수 생성자로 Book 객체(book2) 생성 후 bookList에 추가

    // for를 이용하여 bookList의 전체 데이터 출력

    // for each를 이용하여 bookList의 전체 데이터 출력

    // list의 0번 인덱스에 담긴 책의 가격을 50000으로 변경

    // list의 1번 인덱스에 담긴 출판사의 제목을 "안녕출판사"로 변경

    // for를 이용하여 bookList의 전체 데이터 출력

    // for each를 이용하여 bookList의 전체 데이터 출력

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book();
        book1.setId(1234L);
        book1.setBookTitle("책1");
        book1.setBookAuthor("저자1");
        book1.setBookPublisher("출판1");
        book1.setBookPrice(15000);
        bookList.add(book1);
        Book book2 = new Book(4321L, "책2", "저자2", "출판2", 10000);
        bookList.add(book2);
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println("bookList(" + i + ") = " + bookList.get(i));
        }
        System.out.println();
        for (Book a : bookList) {
            System.out.println("bookList = " + a);
        }
        System.out.println();
        bookList.get(0).setBookPrice(50000);
        bookList.get(1).setBookPublisher("안녕 출판사");
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println("bookList(" + i + ") = " + bookList.get(i));
        }

        System.out.println();
        for (Book b : bookList) {
            System.out.println("bookList = " + b);
        }
    }
}
