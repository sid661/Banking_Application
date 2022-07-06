package idbc.project;

public interface CustomerDao {

    void addNewCustomer();

    void inserDataInCustomerTable(Customer customer,long account);

    void inserDataInAccountTable(Account account);

    boolean validateUserIdPassword(String customerId, String userid, String password);

    int checkBalance(String customerId);

    void depositAmount(String customerId,int depositAmount,String detail);

    void withdrawAmount(String customerId, int withdrawAmount,String type,String detail);

    void addNewTransaction(String customerid,long accountno,String type,int amount,String benificiary);
   void changePassword(String password,String customerid);
   void bankStatement(String customerid);
}
