package ch11_classes.ex02;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService {
    Scanner sc = new Scanner(System.in);
    List<BookDTO> bookDTOList = new ArrayList<>();
    BookRepository bookRepository = new BookRepository();

    public void save() {
        System.out.print("제목 입력 > ");
        String bookTitle = sc.next();
        System.out.print("저자 입력 > ");
        String bookAuthor = sc.next();
        System.out.print("가격 입력 > ");
        int bookPrice = sc.nextInt();
        System.out.print("출판사 입력 > ");
        String bookPublisher= sc.next();
        BookDTO bookDTO = new BookDTO(bookTitle,bookAuthor,bookPrice,bookPublisher);
        boolean result = bookRepository.save(bookDTO);
        if (result) {
            System.out.println("책 등록 성공");
        } else {
            System.out.println("책 등록 실패");
        }
    }

    public void findAll() {
        List<BookDTO> bookDTOList = bookRepository.findAll();
        for (BookDTO bookDTO : bookDTOList) {
            System.out.println("BookDTO = " + bookDTO);
        }
    }

    public void findById() {
        System.out.print("조회할 ID : ");
        Long id = sc.nextLong();
        BookDTO bookDTO = bookRepository.findById(id);
        if (bookDTO != null) {
            System.out.println("bookDTO = " + bookDTO);
        } else {
            System.out.println("요청 하신 정보를 찾을 수 없습ㄴ다.");
        }
    }

    public void findByTitle() {
        System.out.print("조회할 제목 : ");
        String bookTitle = sc.next();
        BookDTO bookDTO = bookRepository.findByTitle(bookTitle);
        if (bookDTO != null) {
            System.out.println("bookDTO = " + bookDTO);
        } else {
            System.out.println("요청 하신 정보를 찾을 수 없습니다.");
        }
    }

}
