package ch11_classes.ex05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankRepository {
    List<ClientDTO> clientDTOList = new ArrayList<>();
    List<AccountDTO> accountDTOList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public boolean registAccount(ClientDTO clientDTO) {
        return clientDTOList.add(clientDTO);
    }

    public void checkAccount(String accountNumber) {
        for (int i = 0; i < clientDTOList.size(); i++) {
            if (accountNumber.equals(clientDTOList.get(i).getAccountNumber())) {
                System.out.println("잔액 : " + clientDTOList.get(i).getBalance() + "원");
            }
        }
    }

    public void deposit(String depositAccount, long depositAmount, String createdAt) {
        for (int i = 0; i < clientDTOList.size(); i++) {
            if (depositAccount.equals(clientDTOList.get(i).getAccountNumber())) {
                long nowAmount = clientDTOList.get(i).getBalance();
                clientDTOList.get(i).setBalance(nowAmount + depositAmount);
                System.out.println("잔액 : " + clientDTOList.get(i).getBalance() + "원");
                AccountDTO accountDTO = new AccountDTO(depositAccount, depositAmount, 0, createdAt);
                accountDTOList.add(accountDTO);
                System.out.println("입금이 완료 되었습니다.");
            }
        }
    }

    public void withDraw(String withDrawAccount, String withDrawPassword, long withDrawAmount, String createdAt) {

        for (int i = 0; i < clientDTOList.size(); i++) {
            if (withDrawAccount.equals(clientDTOList.get(i).getAccountNumber())) {
                if (clientDTOList.get(i).getBalance() > withDrawAmount) {
                    if (withDrawPassword.equals(clientDTOList.get(i).getClientPassword())) {
                        long balance = clientDTOList.get(i).getBalance();
                        clientDTOList.get(i).setBalance(balance - withDrawAmount);
                        System.out.println("잔액 : " + clientDTOList.get(i).getBalance());
                        AccountDTO accountDTO = new AccountDTO(withDrawAccount, 0, withDrawAmount, createdAt);
                        accountDTOList.add(accountDTO);
                        System.out.println("출금이 완료 되었습니다.");
                    } else {
                        System.out.println("입력 정보가 일치하지 않습니다.");
                    }
                } else {
                    System.out.println("잔액이 부족합니다.");
                }
            }
        }
    }

    public boolean checkAccountNumber(String accountNumber) {
        boolean result = false;
        for (int i = 0; i < clientDTOList.size(); i++) {
            if (accountNumber.equals(clientDTOList.get(i).getAccountNumber())) {
                result = true;
            }
        }
        return result;
    }

    public void allDetails(String accountNumber) {
        for (int i = 0; i < accountDTOList.size(); i++) {
            if (accountNumber.equals(accountDTOList.get(i).getAccountNumber())) {
                System.out.println(accountDTOList.get(i));
            }
        }
    }

    public void depositDetails(String accountNumber) {
        for (int i = 0; i < accountDTOList.size(); i++) {
            if (accountNumber.equals(accountDTOList.get(i).getAccountNumber())) {
                System.out.println("입금액 : " + "+" + accountDTOList.get(i).getDeposit() + "\t" + " 거래 시간 : " + accountDTOList.get(i).getBankingAt());
            }
        }
    }


    public void withDrawDetails(String accountNumber) {
        for (int i = 0; i < accountDTOList.size(); i++) {
            if (accountNumber.equals(accountDTOList.get(i).getAccountNumber())) {
                System.out.println("출금액 : " + "-" + accountDTOList.get(i).getWithdraw() + "\t" + " 거래 시간 : " + accountDTOList.get(i).getBankingAt());
            }
        }
    }

    public boolean accountTransfer(String remit, String collect, long amount, String createdAt) {
        boolean result = false;
        for (int i = 0; i < clientDTOList.size(); i++) {
            if (collect.equals(clientDTOList.get(i).getAccountNumber())) {
                System.out.println("받는 사람이 " + clientDTOList.get(i).getClientName() + "이 맞습니까?");
                System.out.println("맞으면 1, 아니면 2를 입력해주세요.");
                System.out.print(" > ");
                int transferCheck = sc.nextInt();
                if (transferCheck == 1) {
                    for (int j = 0; j < clientDTOList.size(); j++) {
                        if (remit.equals(clientDTOList.get(j).getAccountNumber())) {
                            long currentBalance = clientDTOList.get(j).getBalance();
                            clientDTOList.get(j).setBalance(currentBalance - amount);
                            AccountDTO accountDTOS = new AccountDTO(remit, 0, amount, createdAt);
                            accountDTOList.add(accountDTOS);
                            for (int k = 0; k < clientDTOList.size(); k++) {
                                if (collect.equals(clientDTOList.get(k).getAccountNumber())) {
                                    long currentBalance2 = clientDTOList.get(k).getBalance();
                                    clientDTOList.get(k).setBalance(currentBalance2 + amount);
                                    AccountDTO accountDTO2 = new AccountDTO(collect, amount, 0, createdAt);
                                    accountDTOList.add(accountDTO2);
                                }
                            }
                        }
                    }
                    result = true;
                } else {
                    System.out.println("받는 계좌 번호가 일치하지 않습니다.");
                }
            }
        }
        return result;
    }
}


