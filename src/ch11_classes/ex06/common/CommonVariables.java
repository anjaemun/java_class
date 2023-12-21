package ch11_classes.ex06.common;

import ch11_classes.ex06.service.BoardService;

import java.util.Scanner;

public class CommonVariables {
    Scanner sc = new Scanner(System.in);
    public static String loginEmail = null;
    BoardService boardService = new BoardService();


    public void boardMenu() {
        boolean run = true;

        while (run) {
            System.out.println("===========================================================");
            System.out.println("1.글 작성 2.글 목록 3.글 조회 4.글 수정 5.글 삭제 6.검색 0.메인 메뉴 ");
            System.out.println("===========================================================");
            System.out.print("항목 > ");
            int sel = sc.nextInt();
            if (sel == 1) {
                boardService.write();
            } else if (sel == 2) {
                boardService.boardList();
            } else if (sel == 3) {
                boardService.listById();
                boardService.comment();
            } else if (sel == 4) {
                boardService.boardUpdate();
            } else if (sel == 5) {
                boardService.boardDelete();
            } else if (sel == 6) {
                boardService.boardSearch();
            } else if (sel == 0) {
                run = false;
            }
        }
    }
}
