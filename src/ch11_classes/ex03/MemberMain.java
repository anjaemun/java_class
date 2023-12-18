package ch11_classes.ex03;

import java.util.Scanner;

public class MemberMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberService memberService = new MemberService();
        boolean run = true;
        int selNo;
        while (run) {
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("1.회원가입 | 2.로그인 | 3.회원목록 조회 | 4.회원정보 수정 | 5.회원탈퇴 | 6.로그아웃 | 0.종료");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.print("항목 선택 > ");
            selNo = sc.nextInt();
            if (selNo == 1) {
                memberService.SignIn();
            } else if (selNo == 2) {
                memberService.SignUp();
            } else if (selNo == 3) {
                memberService.memberList();
            } else if (selNo == 4) {
                memberService.update();
            } else if (selNo == 5) {
                memberService.delete();
            } else if (selNo == 6) {
                memberService.logout();
            } else {
                run = false;
            }
        }
    }
}
