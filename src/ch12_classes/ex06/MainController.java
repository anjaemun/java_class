package ch12_classes.ex06;

import ch12_classes.ex06.service.MemberService;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberService memberService = new MemberService();
        boolean run = true;
        int sel;
        while (run) {
            System.out.println("=====회원 관리=====");
            System.out.println("======================================================================================");
            System.out.println("| 1.회원가입 | 2.로그인 | 3.회원목록 | 4.회원 수정 | 5.회원 탈퇴 | 6.로그아웃 | 7.게시판 | 0.종료 |");
            System.out.println("======================================================================================");
            System.out.print("항목 > ");
            sel = sc.nextInt();
            if (sel == 1) {
                memberService.save();
            } else if (sel == 2) {
                memberService.login();
            } else if (sel == 3) {
                memberService.memberList();
            } else if (sel == 4) {
                memberService.update();
            } else if (sel == 5) {
                memberService.leave();
            } else if (sel == 6) {
                memberService.logout();
            } else if (sel == 7) {
                memberService.loginCheck();
            } else if (sel == 0) {
                run = false;
            }
        }
    }
}
