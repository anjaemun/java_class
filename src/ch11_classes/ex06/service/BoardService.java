package ch11_classes.ex06.service;

import ch11_classes.ex06.common.CommonVariables;
import ch11_classes.ex06.dto.BoardDTO;
import ch11_classes.ex06.dto.CommentDTO;
import ch11_classes.ex06.repository.BoardRepository;

import java.util.List;
import java.util.Scanner;

public class BoardService {
    Scanner sc = new Scanner(System.in);
    BoardRepository boardRepository = new BoardRepository();

    public void write() {
        System.out.print("제목 > ");
        String boardTitle = sc.next();
        System.out.print("내용 > ");
        String boardContents = sc.next();
        BoardDTO boardDTO = new BoardDTO(boardTitle, CommonVariables.loginEmail, boardContents);
        boolean write = boardRepository.write(boardDTO);
        if (write) {
            System.out.println("작성 완료!!");
        } else {
            System.out.println("작성 실패,,");
        }

    }

    public void boardList() {
        List<BoardDTO> boardDTOList = boardRepository.boardList();
        if (!boardDTOList.isEmpty()) {
            System.out.println("id\ttitle\twriter\thits\tdate");
            for (BoardDTO boardDTO : boardDTOList) {
                System.out.println("boardDTO = " + boardDTO);
            }
        } else {
            System.out.println("작성된 글이 없습니다.");
        }

    }

    public void listById() {
        System.out.print("찾을 글 id > ");
        Long id = sc.nextLong();
        BoardDTO boardDTO = boardRepository.listById(id);
        if (boardDTO != null) {
            System.out.println("boardDTO = " + boardDTO);
        } else {
            System.out.println("조회 결과가 없습니다.");
        }
    }

    public void boardUpdate() {
        System.out.print("수정할 글 id > ");
        Long id = sc.nextLong();
        boolean boardUpdatecheck = boardRepository.boardUpdateCheck(id);
        if (boardUpdatecheck) {
            System.out.println("===================");
            System.out.println("1.글 제목 | 2.글 내용");
            System.out.println("===================");
            System.out.print("변경할 항목 > ");
            int sel = sc.nextInt();
            boolean boardUpdate = boardRepository.boardUpdate(id, sel);
            if (!boardUpdate) {
                System.out.println("수정 완료!!");
            } else {
                System.out.println("수정 실패,,");
            }
        } else {
            System.out.println("해당 글이 존재하지 않습니다.");
        }

    }

    public void boardDelete() {
        System.out.print("삭제할 글 id > ");
        Long id = sc.nextLong();
        boolean delete = boardRepository.boardDelete(id);
        if (delete) {
            System.out.println("삭제 완료");
        } else {
            System.out.println("본인의 글만 삭제할 수 있습니다.");
        }
    }

    public void boardSearch() {
        System.out.print("검색어 > ");
        String searchWord = sc.next();
        List<BoardDTO> boardDTOList = boardRepository.boardSerach(searchWord);
        if (boardDTOList != null) {
            for (BoardDTO boardDTO:boardDTOList){
                System.out.println("boardDTO = " + boardDTO);
            }
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }


    }

    public void comment() {

    }
}



