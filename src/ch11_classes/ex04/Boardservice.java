package ch11_classes.ex04;

import ch11_classes.ex02.BookRepository;

import java.util.Scanner;

public class Boardservice {
    Scanner sc = new Scanner(System.in);
    BoardRepository boardRepository = new BoardRepository();

    public void write() {
        System.out.print("Title > ");
        String boardTitle = sc.next();
        System.out.print("Writer > ");
        String boardWriter = sc.next();
        System.out.print("Contents > ");
        String boardContents = sc.next();
        System.out.print("Password > ");
        String boardPass = sc.next();
        BoardDTO boardDTO = new BoardDTO(boardTitle, boardWriter, boardContents, boardPass);
        boolean result = boardRepository.write(boardDTO);
        if (result) {
            System.out.println("Successed!");
        } else {
            System.out.println("Failed!");
        }
    }
}
