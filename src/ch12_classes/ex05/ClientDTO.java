package ch12_classes.ex05;


public class ClientDTO {
    private Long id;
    private String clientName;
    private String accountNumber;
    private String clientPassword;
    private String clientCreatedAt;
    private long balance = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public String getClientCreatedAt() {
        return clientCreatedAt;
    }

    public void setClientCreatedAt(String clientCreatedAt) {
        this.clientCreatedAt = clientCreatedAt;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", 성명 = '" + clientName + '\'' +
                ", 계좌 번호 = '" + accountNumber + '\'' +
                ", 계좌 개설 시간 = '" + clientCreatedAt + '\'' +
                ", 잔액 = " + balance +
                '}';
    }

    public static Long idValue = 1L;

    public ClientDTO(String clientName, String accountNumber, String clientPassword, String clientCreatedAt, long balance) {
        this.id = idValue++;
        this.clientName = clientName;
        this.accountNumber = accountNumber;
        this.clientPassword = clientPassword;
        this.clientCreatedAt = clientCreatedAt;
        this.balance = balance;
    }


}
