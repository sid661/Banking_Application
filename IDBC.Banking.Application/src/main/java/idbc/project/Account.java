package idbc.project;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Account {
    private long accountNo; // RANDOM GENRATED
    private String nominee; // USER INPUT
    private String nomineeRelation; // user input
    private String accountType; // ASKED
    private String userid; // RANDOM GENERATED
    private String userPassword;  // CREATED BY USER
    private String branch;/// SHOULD BE ALLOCATED WITH IN THAT STATE
    private int balance;
    Timestamp localDateTime;

    public Account (){}

    public Account(long accountNo, String nominee, String nomineeRelation, String accountType, String userid, String userPassword, String branch, int balance, Timestamp localDateTime) {
        this.accountNo = accountNo;
        this.nominee = nominee;
        this.nomineeRelation = nomineeRelation;
        this.userid = userid;
        this.userPassword = userPassword;
        this.branch = branch;
        this.balance = balance;
        this.localDateTime = localDateTime;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getNomineeRelation() {
        return nomineeRelation;
    }

    public void setNomineeRelation(String nomineeRelation) {
        this.nomineeRelation = nomineeRelation;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch=branch;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Timestamp getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(Timestamp localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "Account{" +
                "nominee='" + nominee + '\'' +
                ", nomineeRelation='" + nomineeRelation + '\'' +
                ", accountNo=" + accountNo +
                ", accountType='" + accountType + '\'' +
                ", userid='" + userid + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", Branch='" + branch + '\'' +
                '}';
    }
}
