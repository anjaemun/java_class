package ch12_classes.ex05;

public class AccountDTO {
    private Long id;
    private String accountNumber;
    private long deposit;
    private long withdraw;
    private String bankingAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getDeposit() {
        return deposit;
    }

    public void setDeposit(long deposit) {
        this.deposit = deposit;
    }

    public long getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(long withdraw) {
        this.withdraw = withdraw;
    }

    public String getBankingAt() {
        return bankingAt;
    }

    public void setBankingAt(String bankingAt) {
        this.bankingAt = bankingAt;
    }

    public static Long idValue = 1L;

    @Override
    public String toString() {
        return "거래 계좌 번호 = '" + accountNumber + '\'' +
                ", 입금 = " + "+" + deposit + "\t" +
                ", 출금 = " + "-" + withdraw + "\t" +
                ", 거래 시간 = '" + bankingAt + '\'' +
                '}';
    }

    public AccountDTO(String accountNumber, long deposit, long withdraw, String bankingAt) {
        this.id = idValue++;
        this.accountNumber = accountNumber;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.bankingAt = bankingAt;
    }
}
