package ch11_classes.ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardService {
    Scanner sc = new Scanner(System.in);
    BoardRepository boardRepository = new BoardRepository();
    List<BoardDTO> boardDTOList = new ArrayList<>();

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
            System.out.println(boardDTO);
            System.out.println(boardDTO.getCreatedAt());
        }
    }

    public void check() {
        System.out.print("조회할 글 번호를 입력하세요 > ");
        Long id = sc.nextLong();
        boardRepository.hitsUp(id);
        boardRepository.check(id);
    }

    public void correction() {
        System.out.print("수정할 글 id를 입력하세요 > ");
        Long id = sc.nextLong();
        System.out.print("비밀번호를 입력하세요 > ");
        String boardPass = sc.next();
        boolean result = boardRepository.correction(id, boardPass);
        if (result) {
            System.out.println("Successes!");
        } else {
            System.out.println("Failed,,,");
        }
    }

    public void delete() {
        System.out.print("삭제할 글 id를 입력하세요 > ");
        Long id = sc.nextLong();
        System.out.print("비밀번호를 입력하세요 > ");
        String boardPass = sc.next();
        boolean result = boardRepository.delete(id, boardPass);
        if (result) {
            System.out.println("Successed!");
        } else {
            System.out.println("Failed,,,");
        }

    }

    public void search() {
        System.out.print("찾을 제목을 입력하세요 > ");
        String boardTitle = sc.next();
        List<BoardDTO> boardDTOList = boardRepository.search(boardTitle);
        if (boardDTOList.size() > 0) {
            for (BoardDTO boardDTO : boardDTOList) {
                System.out.println("boardDTO = " + boardDTO);
            }
        } else {
            System.out.println("Cannot found,,,");
        }
    }

}
