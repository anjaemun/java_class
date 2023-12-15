package ch11_classes.ex02;

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
        BookDTO bookDTO1 = null;
        for (int i = 0; i < bookDTOList.size(); i++) {
            if (id.equals(bookDTOList.get(i).getId())) {
                bookDTO1 = bookDTOList.get(i);
            }
        }
        return bookDTO1;
    }


    public BookDTO findByTitle(String bookTitle) {
        BookDTO bookDTO2 = null;
        for(int i = 0; i < bookDTOList.size(); i++){
            if(bookTitle.equals(bookDTOList.get(i).getBookTitle())){
                bookDTO2 = bookDTOList.get(i);
            }
        }
        return bookDTO2;
    }

}
