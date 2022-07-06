package idbc.project;

public class Customer {
    private String customerId;
    private String firstname;
    private String lastname;
    private long phoneno;
    private String permanentAddress;
    private String corrospondingAddress;
    private String panNo;
    private int age;
    private Account account;
    private Transaction transaction;

    public  Customer (){}
    public Customer(String customerId, String firstname, String lastname, long phoneno, String permanentAddress,
                    String corrospondingAddress, String panNo, int age, Account account, Transaction transaction)
    {
        this.customerId = customerId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneno = phoneno;
        this.permanentAddress = permanentAddress;
        this.corrospondingAddress = corrospondingAddress;
        this.panNo = panNo;
        this.age = age;
        this.account = account;
        this.transaction = transaction;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(long phoneno) {
        this.phoneno = phoneno;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getCorrospondingAddress() {
        return corrospondingAddress;
    }

    public void setCorrospondingAddress(String corrospondingAddress) {
        this.corrospondingAddress = corrospondingAddress;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneno=" + phoneno +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", corrospondingAddress='" + corrospondingAddress + '\'' +
                ", panNo='" + panNo + '\'' +
                ", age=" + age +
                ", account=" + account +
                ", transaction=" + transaction +
                '}';
    }
}
