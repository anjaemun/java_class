package ch12_classes.ex04;

import java.util.Scanner;

public class BoardMain {
    public static void main(String[] args) {
        BoardService boardservice = new BoardService();
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int sel;
        while (run) {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("1. 글 작성 | 2. 글 목록 | 3. 글 조회 | 4. 글 수정 | 5. 글 삭제 | 6. 검색 | 7. 테스트 데이터 0 . 종료");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.print("항목 입력 > ");
            sel = sc.nextInt();
            if (sel == 1) {
                boardservice.write();
            } else if (sel == 2) {
                boardservice.list();
            } else if (sel == 3) {
                boardservice.check();
            } else if (sel == 4) {
                boardservice.correction();
            } else if (sel == 5) {
                boardservice.delete();
            } else if (sel == 6) {
                boardservice.search();
            } else if (sel == 0){
                run = false;
            } else if (sel == 7){
                boardservice.testData();
            }
        }
    }
}
