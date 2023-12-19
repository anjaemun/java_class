package ch11_classes.ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardRepository {
    List<BoardDTO> boardDTOList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public boolean write(BoardDTO boardDTO) {
        return boardDTOList.add(boardDTO);
    }

    public List<BoardDTO> list() {
        return boardDTOList;
    }

    public void check(Long id) {
//        List<BoardDTO> boardDTOList1 = new ArrayList<>();
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (id.equals(boardDTOList.get(i).getId())) {
                System.out.println("id : " + boardDTOList.get(i).getId());
                System.out.println("Title : " + boardDTOList.get(i).getBoardTitle());
                System.out.println("Writer : " + boardDTOList.get(i).getBoardWriter());
                System.out.println("Contents : " + boardDTOList.get(i).getBoardContents());
                System.out.println("조회수 : " + boardDTOList.get(i).getBoardHits());
            }else {
                System.out.println("존재 하지 않습니다.");
            }
        }
    }


    public boolean correction(Long id, String boardPass) {
        boolean result = false;
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (id.equals(boardDTOList.get(i).getId()) && boardPass.equals(boardDTOList.get(i).getBoardPass())) {
                System.out.print("변경할 제목을 입력 하세요 > ");
                boardDTOList.get(i).setBoardTitle(sc.next());
                System.out.print("변경할 내용을 입력 하세요 > ");
                boardDTOList.get(i).setBoardContents(sc.next());
                result = true;
            }
        }
        return result;
    }

    public boolean delete(Long id, String boardPass) {
        boolean result = false;
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (id.equals(boardDTOList.get(i).getId())) {
                if (boardPass.equals(boardDTOList.get(i).getBoardPass())) {
                    boardDTOList.remove(i);
                    result = true;
                } else {
                    System.out.println("비밀 번호가 틀렸습니다. ");
                }
            }
        }
        return result;
    }

    public List<BoardDTO> search(String boardTitle) {
        List<BoardDTO> boardDTOS = new ArrayList<>();
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (boardDTOList.get(i).getBoardTitle().contains(boardTitle)) {
                BoardDTO boardDTO = boardDTOList.get(i);
                boardDTOS.add(boardDTO);
            }
        }
        return boardDTOS;
    }

    public void hitsUp(Long id) {
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (id.equals(boardDTOList.get(i).getId())) {
                Long hits = boardDTOList.get(i).getBoardHits();
                boardDTOList.get(i).setBoardHits(++hits);
            }
        }
    }
}

