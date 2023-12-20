package ch11_classes.ex05;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankService {

    Scanner sc = new Scanner(System.in);
    BankRepository bankRepository = new BankRepository();
    List<ClientDTO> clientDTOList = new ArrayList<>();

    public void registAccount() {
        String clientAccount;
        System.out.println("계좌 등록을 진행합니다. 아래 정보를 입력해주세요.");
        System.out.print("성명 > ");
        String clientName = sc.next();
        boolean run = true;
        do {
            System.out.print("희망 계좌 번호 > ");
            clientAccount = sc.next();
            boolean result = bankRepository.checkAccountNumber(clientAccount);
            if (result) {
                System.out.println("이미 존재하는 계좌 번호입니다. 다시 입력해주세요.");
            } else {
                run = false;
            }
        } while (run);
        System.out.print("계좌 비밀번호 > ");
        String clientPassword = sc.next();
        String createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd,HH:mm분"));
        ClientDTO clientDTO = new ClientDTO(clientName, clientAccount, clientPassword, createdAt, 0);
        boolean result = bankRepository.registAccount(clientDTO);
        if (result) {
            System.out.println("계좌 등록이 완료 되었습니다.");
            for (ClientDTO clientDTO1 : clientDTOList) {
                System.out.println("clientDTO1 = " + clientDTO1);
            }
        } else {
            System.out.println("계좌 등록이 실패 하였습니다.");
        }
    }


    public void checkAccount() {
        boolean run1 = true;
        System.out.println("잔액 조회 입니다. 계좌 번호를 입력해주세요.");
        do {
            System.out.print(" > ");
            String accountNumber = sc.next();
            boolean checkAccount = bankRepository.checkAccountNumber(accountNumber);
            if (checkAccount) {
                bankRepository.checkAccount(accountNumber);
                run1 = false;
            } else {
                System.out.println("계좌 번호가 일치하지 않습니다.");
            }
        } while (run1);
    }

    public void deposit() {
        boolean run1 = true;
        System.out.println("입금입니다. 아래 정보를 입력해주세요.");
        do {
            System.out.print("계좌 번호 > ");
            String depositAccount = sc.next();
            boolean result = bankRepository.checkAccountNumber(depositAccount);
            if (result) {
                System.out.print("입금액 > ");
                long depositAmount = sc.nextLong();
                String createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd,HH:mm분"));
                bankRepository.deposit(depositAccount, depositAmount, createdAt);
                run1 = false;
            } else {
                System.out.println("계좌 번호가 일치하지 않습니다. ");
            }
        } while (run1);
    }

    public void withDraw() {
        boolean run1 = true;
        System.out.println("출금입니다. 아래 정보를 입력해주세요.");
        do {
            System.out.print("계좌 번호 > ");
            String withDrawAccount = sc.next();
            boolean result = bankRepository.checkAccountNumber(withDrawAccount);
            if (result) {
                System.out.print("비밀번호 > ");
                String withDrawPassword = sc.next();
                System.out.print("출금액 > ");
                long withDrawAmount = sc.nextLong();
                String createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd,HH:mm분"));
                bankRepository.withDraw(withDrawAccount, withDrawPassword, withDrawAmount, createdAt);
                run1 = false;
            } else {
                System.out.println("계좌 번호가 일치하지 않습니다.");
            }
        } while (run1);
    }

    public void transactionDetails() {
        System.out.print("계좌 번호 > ");
        String accountNumber = sc.next();
        boolean transactionDetails = bankRepository.checkAccountNumber(accountNumber);
        if (transactionDetails) {
            boolean run = true;
            while (run) {
                System.out.println("===========================================");
                System.out.println("1.전체 내역 | 2.입금 내역 | 3.출금 내역 | 4.종료 |");
                System.out.println("===========================================");
                System.out.print("원하시는 업무를 선택하세요 > ");
                int sel = sc.nextInt();
                if (sel == 1) {
                    bankRepository.allDetails(accountNumber);
                } else if (sel == 2) {
                    bankRepository.depositDetails(accountNumber);
                } else if (sel == 3) {
                    bankRepository.withDrawDetails(accountNumber);
                } else {
                    run = false;
                }
            }
        }
    }

    public void accountTransfer() {
        System.out.println("계좌 이체입니다. 아래 정보를 입력해주세요.");
        System.out.print("보내는 계좌 번호 > ");
        String remit = sc.next();
        System.out.print("받는 계좌 번호 > ");
        String collect = sc.next();
        System.out.print("이체할 금액 > ");
        long amount = sc.nextLong();
        String createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd,HH:mm분"));
        boolean result = bankRepository.accountTransfer(remit, collect, amount, createdAt);
        if (result) {
            System.out.println("이체 완료하였습니다.");
        } else {
            System.out.println("이체 실패하였습니다.");
        }

    }
}
