package ch11_classes.ex02;

import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int selectNo;
        // bookService 클래스 객체 선언
        BookService bookService = new BookService();

        while (run) {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("1.도서 등록 | 2.도서목록 | 3.도서조회(id) | 4.도서조회(제목) | 5.가격수정 | 6.도서삭제 | 7. 도서 검색 | 0. 종료");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.print("선택> ");
            selectNo = sc.nextInt();
            if (selectNo == 1) {
                bookService.save();
            } else if (selectNo == 2) {
                bookService.findAll();
            } else if (selectNo == 3) {
                bookService.findById();
            } else if (selectNo == 4) {
                bookService.findByTitle();
            } else if (selectNo == 5) {
                bookService.update();
            } else if (selectNo == 6) {
                bookService.delete();
            } else if (selectNo == 7) {
                bookService.search();
            } else if (selectNo == 0) {
                run = false;
            }
        }
    }
}
