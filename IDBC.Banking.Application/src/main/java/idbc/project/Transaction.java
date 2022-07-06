package idbc.project;

import java.sql.Timestamp;

public class Transaction {

    private long transactionid;
    private String transactionntype;
    private int amount;
    private Timestamp localDateTime;
    private String customerid;
    private long accountno;
    private String beneficarydetails;

    public Transaction() {
    }

    public Transaction(long transactionid, String transactionntype, int amount, Timestamp localDateTime, String customerid, long accountno, String beneficarydetails) {
        this.transactionid = transactionid;
        this.transactionntype = transactionntype;
        this.amount = amount;
        this.localDateTime = localDateTime;
        this.customerid = customerid;
        this.accountno = accountno;
        this.beneficarydetails = beneficarydetails;
    }

    public long getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(long transactionid) {
        this.transactionid = transactionid;
    }

    public String getTransactionntype() {
        return transactionntype;
    }

    public void setTransactionntype(String transactionntype) {
        this.transactionntype = transactionntype;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Timestamp getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(Timestamp localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public long getAccountno() {
        return accountno;
    }

    public void setAccountno(long accountno) {
        this.accountno = accountno;
    }

    public String getBeneficarydetails() {
        return beneficarydetails;
    }

    public void setBeneficarydetails(String beneficarydetails) {
        this.beneficarydetails = beneficarydetails;
    }
}
