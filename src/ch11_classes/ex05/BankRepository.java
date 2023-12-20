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
        for (ClientDTO clientDTO : clientDTOList) {
            if (accountNumber.equals(clientDTO.getAccountNumber())) {
                System.out.println("잔액 : " + clientDTO.getBalance() + "원");
            }
        }
    }

    public void deposit(String depositAccount, long depositAmount, String createdAt) {
        for (ClientDTO clientDTO : clientDTOList) {
            if (depositAccount.equals(clientDTO.getAccountNumber())) {
                long nowAmount = clientDTO.getBalance();
                clientDTO.setBalance(nowAmount + depositAmount);
                System.out.println("잔액 : " + clientDTO.getBalance() + "원");
                AccountDTO accountDTO = new AccountDTO(depositAccount, depositAmount, 0, createdAt);
                accountDTOList.add(accountDTO);
                System.out.println("입금이 완료 되었습니다.");
            }
        }
    }

    public void withDraw(String withDrawAccount, String withDrawPassword, long withDrawAmount, String createdAt) {
        for (ClientDTO clientDTO : clientDTOList) {
            if (withDrawAccount.equals(clientDTO.getAccountNumber())) {
                if (clientDTO.getBalance() > withDrawAmount) {
                    if (withDrawPassword.equals(clientDTO.getClientPassword())) {
                        long balance = clientDTO.getBalance();
                        clientDTO.setBalance(balance - withDrawAmount);
                        System.out.println("잔액 : " + clientDTO.getBalance());
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
        for (ClientDTO clientDTO : clientDTOList) {
            if (accountNumber.equals(clientDTO.getAccountNumber())) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void allDetails(String accountNumber) {
        for (AccountDTO accountDTO : accountDTOList) {
            if (accountNumber.equals(accountDTO.getAccountNumber())) {
                System.out.println(accountDTO);
            }
        }
    }

    public void depositDetails(String accountNumber) {
        for (AccountDTO accountDTO : accountDTOList) {
            if (accountNumber.equals(accountDTO.getAccountNumber())) {
                System.out.println("입금액 : " + "+" + accountDTO.getDeposit() + "\t" + " 거래 시간 : " + accountDTO.getBankingAt());
            }
        }
    }


    public void withDrawDetails(String accountNumber) {
        for (AccountDTO accountDTO : accountDTOList) {
            if (accountNumber.equals(accountDTO.getAccountNumber())) {
                System.out.println("출금액 : " + "-" + accountDTO.getWithdraw() + "\t" + " 거래 시간 : " + accountDTO.getBankingAt());
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
                            for (ClientDTO clientDTO : clientDTOList) {
                                if (collect.equals(clientDTO.getAccountNumber())) {
                                    long currentBalance2 = clientDTO.getBalance();
                                    clientDTO.setBalance(currentBalance2 + amount);
                                    AccountDTO accountDTO2 = new AccountDTO(collect, amount, 0, createdAt);
                                    accountDTOList.add(accountDTO2);
                                }
                            }
                        }
                    }
                    result = true;
                } else {
                    System.out.println("대상과 계좌 번호가 일치하지 않습니다.");
                }
            }
        }
        return result;
    }
}



