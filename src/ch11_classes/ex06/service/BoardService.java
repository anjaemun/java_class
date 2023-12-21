package ch11_classes.ex06.service;

import ch11_classes.ex06.common.CommonVariables;
import ch11_classes.ex06.dto.BoardDTO;
import ch11_classes.ex06.dto.CommentDTO;
import ch11_classes.ex06.repository.BoardRepository;
import ch11_classes.ex06.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardService {
    Scanner sc = new Scanner(System.in);
    BoardRepository boardRepository = new BoardRepository();

    CommentRepository commentRepository = new CommentRepository();


    public void boardMenu() {
        boolean run = true;

        while (run) {
            System.out.println("===========================================================");
            System.out.println("1.글 작성 2.글 목록 3.글 조회 4.글 수정 5.글 삭제 6.검색 0.메인 메뉴 ");
            System.out.println("===========================================================");
            System.out.print("항목 > ");
            int sel = sc.nextInt();
            if (sel == 1) {
                write();
            } else if (sel == 2) {
                boardList();
            } else if (sel == 3) {
                listById();
            } else if (sel == 4) {
                boardUpdate();
            } else if (sel == 5) {
                boardDelete();
            } else if (sel == 6) {
                boardSearch();
            } else if (sel == 0) {
                run = false;
            }
        }
    }

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
            System.out.println("id\t" + "Title\t" + "Writer\t" + "Hits\t" + "CreatedAt\t");
            for (BoardDTO boardDTO : boardDTOList) {
                System.out.println(boardDTO.getId() + "\t" + boardDTO.getBoardWriter() + "\t" +
                        boardDTO.getBoardWriter() + "\t" + boardDTO.getBoardHits() + "\t" + boardDTO.getCreatedAt() + "\t");
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
            boardRepository.hitsUp(id);
            System.out.println("boardDTO = " + boardDTO);
            System.out.println("=====댓글=====");
            List<CommentDTO> commentCheck = commentRepository.commentCheck();
            if (commentCheck != null) {
                for (CommentDTO commentDTO : commentCheck) {
                    System.out.println(commentDTO);
                }
            } else {
                System.out.println("작성된 댓글이 없습니다.");
            }
            System.out.println("댓글 작성하시려면 1번, 메인 메뉴로 돌아가려면 2번을 선택해주세요.");
            System.out.print(" > ");
            int sel = sc.nextInt();
            if (sel == 1) {
                System.out.print("댓글 > ");
                String comment = sc.next();
                CommentDTO commentDTO = new CommentDTO(id, CommonVariables.loginEmail, comment);
                boolean writeComment = commentRepository.writeComment(commentDTO);
                if (writeComment) {
                    System.out.println("댓글 작성 완료!!");
                } else {
                    System.out.println("댓글 작성 실패,,");
                }
            } else if (sel == 2) {
                boardMenu();
            }
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
            for (BoardDTO boardDTO : boardDTOList) {
                System.out.println("boardDTO = " + boardDTO);
            }
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }


    }

}



