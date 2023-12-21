package ch11_classes.ex06.repository;

import ch11_classes.ex06.common.CommonVariables;
import ch11_classes.ex06.dto.BoardDTO;
import ch11_classes.ex06.dto.CommentDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardRepository {
    Scanner sc = new Scanner(System.in);
    List<BoardDTO> boardDTOList = new ArrayList<>();

    public boolean write(BoardDTO boardDTO) {
        return boardDTOList.add(boardDTO);
    }

    public List<BoardDTO> boardList() {
        return boardDTOList;
    }

    public BoardDTO listById(Long id) {
        for (BoardDTO boardDTO : boardDTOList) {
            if (id.equals(boardDTO.getId())) {
                return boardDTO;
            }
        }
        return null;
    }

    public boolean boardUpdateCheck(Long id) {
        for (BoardDTO boardDTO : boardDTOList) {
            if (id.equals(boardDTO.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean boardUpdate(Long id, int sel) {
        boolean result = true;
        for (BoardDTO boardDTO : boardDTOList) {
            if (id.equals(boardDTO.getId())) {
                if (boardDTO.getBoardWriter().equals(CommonVariables.loginEmail)) {
                    while (result) {
                        if (sel == 1) {
                            boardDTO.setBoardTitle(sc.next());
                            result = false;
                        } else if (sel == 2) {
                            boardDTO.setBoardContents(sc.next());
                            result = false;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    public Boolean boardDelete(Long id) {
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (id.equals(boardDTOList.get(i).getId())) {
                if (boardDTOList.get(i).getBoardWriter().equals(CommonVariables.loginEmail)) {
                    boardDTOList.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public List<BoardDTO> boardSerach(String searchWord) {
        List<BoardDTO> boardDTOS = new ArrayList<>();
        for (BoardDTO boardDTO : boardDTOList) {
            if (boardDTO.getBoardTitle().contains(searchWord)) {
                boardDTOS.add(boardDTO);
            }
        }
        return boardDTOS;
    }

    public void hitsUp(Long id){
        for (BoardDTO boardDTO:boardDTOList){
            if (id.equals(boardDTO.getId())){
                long hits = boardDTO.getBoardHits();
                hits += 1;
                boardDTO.setBoardHits(hits);
            }
        }
    }

}

