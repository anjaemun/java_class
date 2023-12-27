package ch12_classes.ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRepository {
    Scanner sc = new Scanner(System.in);
    private static List<BookDTO> bookDTOList = new ArrayList<>();

    public Boolean save(BookDTO bookDTO) {
        return bookDTOList.add(bookDTO);
    }

    public List<BookDTO> findAll() {
        return bookDTOList;
    }

    public BookDTO findById(Long id) {
        BookDTO bookDTO = null;
        for (int i = 0; i < bookDTOList.size(); i++) {
            if (id.equals(bookDTOList.get(i).getId())) {
                bookDTO = bookDTOList.get(i);
            }
        }
        return bookDTO;
    }

    public BookDTO findByTitle(String bookTitle) {
        BookDTO bookDTO = null;
        for (int i = 0; i < bookDTOList.size(); i++) {
            if (bookTitle.equals(bookDTOList.get(i).getBookTitle())) {
                bookDTO = bookDTOList.get(i);
            }
        }
        return bookDTO;
    }

    public List<BookDTO> search(String bookTitle) {
        // 검색 결과를 담을 List 선언
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (int i = 0; i < bookDTOList.size(); i++) {
            // 저장 되어 있는 도서명에 검색어가 포함 되어 있으면 true
            if (bookDTOList.get(i).getBookTitle().contains(bookTitle)) {
                BookDTO bookDTO = bookDTOList.get(i);
                bookDTOS.add(bookDTO);
//                bookDTOS.add(bookDTOList.get(i));
            }
        }
        return bookDTOS;
    }

    public boolean update(Long id, int bookPrice) {
        boolean result = false;
        for (int i = 0; i < bookDTOList.size(); i++) {
            if (id.equals(bookDTOList.get(i).getId())) {
                bookDTOList.get(i).setBookPrice(bookPrice);
                result = true;
            }
        }
        return result;
    }

    public boolean delete(Long id) {
        boolean result = false;
        for (int i = 0; i < bookDTOList.size(); i++) {
            if (id.equals(bookDTOList.get(i).getId())) {
                bookDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }
}
