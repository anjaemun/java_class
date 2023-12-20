package ch11_classes.ex05;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankService();
        boolean run = true;
        int sel;
        while (run) {
            System.out.println("==================================================================================");
            System.out.println("1.신규 계좌 등록 | 2.잔액 조회 | 3.입금 | 4.출금 | 5.입출금 내역 조회 | 6.계좌 이체 | 0.종료 |");
            System.out.println("==================================================================================");
            System.out.print("원하시는 업무를 선택해주세요 > ");
            sel = sc.nextInt();
            if (sel == 1) {
                System.out.println(sel + "번, 신규 계좌 등록을 선택하셨습니다.");
                bankService.registAccount();
            } else if (sel == 2) {
                System.out.println(sel + "번, 잔액 조회를 선택하셨습니다.");
                bankService.checkAccount();
            } else if (sel == 3) {
                bankService.deposit();
            } else if (sel == 4) {
                bankService.withDraw();
            } else if (sel == 5) {
                bankService.transactionDetails();
            } else if (sel == 6) {
                bankService.accountTransfer();
            } else if (sel == 0) {
                run = false;
            }
        }
    }
}
