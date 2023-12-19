package ch11_classes.ex04;

import java.util.List;
import java.util.Scanner;

public class BoardService {
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
        listPrint(boardDTOList);
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
            System.out.println("Successes!");
        } else {
            System.out.println("Failed,,,");
        }

    }

    public void search() {
        System.out.print("찾을 제목을 입력하세요 > ");
        String boardTitle = sc.next();
        List<BoardDTO> boardDTOList = boardRepository.search(boardTitle);
        if (!boardDTOList.isEmpty()) {
            listPrint(boardDTOList);
        }
    }

    // 목록 출력 전용 메서드
    // list, search 메서드 로부터 리스트 데이터를 전달 받아서 출력하는 메서드
    private void listPrint(List<BoardDTO> boardDTOList) {
        for (BoardDTO boardDTO : boardDTOList) {
            System.out.println("boardDTO = " + boardDTO);
        }
    }

    public void testData() {
        for (int i = 0; i < 11; i++) {
            BoardDTO boardDTO = new BoardDTO("title" + i, "writer" + i, "contents" + i, "1234" + i);
            boardRepository.write(boardDTO);
        }
    }
}
