package ch11_classes.ex04;

import ch11_classes.ex02.BookRepository;

import java.sql.SQLOutput;
import java.util.List;
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

    public void list() {
        List<BoardDTO> boardDTOList = boardRepository.list();
        for (BoardDTO boardDTO : boardDTOList) {
            System.out.println("boardDTO = " + boardDTO);
        }
    }

    public void check() {
        System.out.print("조회할 글 번호를 입력하세요 > ");
        Long id = sc.nextLong();
        BoardDTO boardDTO = boardRepository.check(id);
        if (boardDTO != null){
            System.out.println("boardDTO = " + boardDTO);
        }else{
            System.out.println("Cannot found,,,");
        }

    }

    public void correction() {
        System.out.print("수정할 글 id를 입력하세요 > ");
        Long id = sc.nextLong();
        System.out.print("비밀번호를 입력하세요 > ");
        String boardPass = sc.next();
        boolean result = boardRepository.correction(id, boardPass);
        if (result) {
            System.out.println("Successed!");
        }else {
            System.out.println("Failed,,,");
        }
    }

    public void delete() {
        System.out.print("삭제할 글 id를 입력하세요 > ");
        Long id = sc.nextLong();
        System.out.print("비밀번호를 입력하세요 > ");
        String boardPass = sc.next();
        boolean result = boardRepository.delete(id, boardPass);
        if (result){
            System.out.println("Successed!");
        }else{
            System.out.println("Failed,,,");
        }

    }
}
