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

    public BoardDTO check(Long id) {
        BoardDTO boardDTO = null;
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (id.equals(boardDTOList.get(i).getId())) {
                boardDTO = boardDTOList.get(i);
            }
        }
        return boardDTO;
    }

    public boolean correction(Long id, String boardPass) {
        boolean result = false;
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (id.equals(boardDTOList.get(i).getId()) && boardPass.equals(boardDTOList.get(i).getBoardPass())) {
                System.out.print("변경할 제목을 입력하세요 > ");
                boardDTOList.get(i).setBoardTitle(sc.next());
                System.out.print("변경할 내용을 입력하세요 > ");
                boardDTOList.get(i).setBoardContents(sc.next());
                result = true;
            }
        }
        return result;
    }
}

