package idbc.project;

import java.sql.*;
import java.util.Scanner;

public class CustomerDaoImpl implements CustomerDao
{
    Transaction tr = new Transaction();

    Customer customer = new Customer();
    Account account = new Account();
    Generate generate = new Generate();

    public void addNewCustomer() {

        System.out.println("PLEASE ENTER YOUR DETAILS FOR ACCOUNT OPENING IN IDBC BANK");


        Scanner sc = new Scanner(System.in);
        //------------------------------------------CUSTOMER CLASS INPUT-------------------------------------------------------------------//

        customer.setCustomerId(generate.customerId());
        //------------------------------------------FIRST NAME-------------------------------------------------------------------//
        System.out.println("PLEASE ENTER YOUR FIRST NAME");
        customer.setFirstname(sc.next());
        sc.nextLine();

        //------------------------------------------LAST NAME-------------------------------------------------------------------//
        System.out.println("PLEASE ENTER YOUR LAST NAME");
        customer.setLastname(sc.next());
        sc.nextLine();

        //------------------------------------------PHONE NO-------------------------------------------------------------------//
        System.out.println("PLEASE ENTER YOUR PHONE NUMBER");
        customer.setPhoneno(sc.nextLong());
        sc.nextLine();

        //------------------------------------------PERMANENT ADDRESS-------------------------------------------------------------------//
        System.out.println("PLEASE ENTER YOUR PERMANENT ADDRESS");
        customer.setPermanentAddress(sc.nextLine());

        //------------------------------------------CORROSPONDING ADDRESS--------------------------------------------------------------//
        System.out.println("PLEASE ENTER YOUR CORRESPONDING ADDRESS");
        customer.setCorrospondingAddress(sc.nextLine());


        //------------------------------------------PAN NO-------------------------------------------------------------------//
        System.out.println("PLEASE ENTER YOUR PERMANENT ACCOUNT NUMBER (PAN NO.)");
        customer.setPanNo(sc.next());
        sc.nextLine();

        //------------------------------------------AGE------------------------------------------------------------------//
        System.out.println("PLEASE ENTER YOUR AGE");
        customer.setAge(generate.checkAge());

        //------------------------------------------ACCOUNT CLASS INPUT-------------------------------------------------------------------//
        System.out.println("YOUR DETAILS HAVE BEEN VERIFIED PROCEED WITH FURTHER ACCOUNT OPENING PROCESS");
        //------------------------------------------ACCOUNT NO-------------------------------------------------------------------//
        account.setAccountNo(generate.accountNoGenerate());

        //------------------------------------------NOMINEE------------------------------------------------------------------//
        System.out.println("PLEASE ENTER YOUR NOMINEE NAME");
        account.setNominee(sc.nextLine());
        //-----------------------------------------NOMINEE RELATION------------------------------------------------------------------//
        System.out.println("PLEASE ENTER YOUR  RELATION  WITH NOMINEE");
        account.setNomineeRelation(generate.checkRelation());

        //------------------------------------------ACCOUNT TYPE-------------------------------------------------------------------//
        System.out.println("PLEASE SELECT ACCOUNT TYPE");
        System.out.println(".1. -- SAVING ACCOUNT" + "\n" + ".2. -- PAY ACCOUNT");
        int ch = 0;
        ch = sc.nextInt();
        sc.nextLine();
        if (ch == 1) {
            account.setAccountType("SAVING ACCOUNT");
        } else if (ch == 2) {
            account.setAccountType("PAY ACCOUNT");
        }
        //------------------------------------------USER ID GENERATION-------------------------------------------------------------------//
        account.setUserid(generate.userIdGenerate());
        //------------------------------------------PASSWORD GENERATION------------------------------------------------------------------//
        account.setUserPassword(generate.userPassword());
        //------------------------------------------IFSC CODE-------------------------------------------------------------------//
        account.setBranch(generate.ifsccodeGenerate());

        this.inserDataInAccountTable(account);
        this.inserDataInCustomerTable(customer, account.getAccountNo());
        System.out.println("YOUR DETAILS HAVE BEEN VERIFIED CREATING YOUR ACCOUNT");


        System.out.println(customer.toString());
        System.out.println(account.toString());
    }

    public void inserDataInAccountTable(Account account) {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idbc", "root", "sid@123");
            String query = "insert into account values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setLong(1, account.getAccountNo());
            pst.setString(2, account.getNominee());
            pst.setString(3, account.getNomineeRelation());
            pst.setString(4, account.getAccountType());
            pst.setString(5, account.getUserid());
            pst.setString(6, account.getUserPassword());
            pst.setString(7, account.getBranch());
            pst.setInt(8, account.getBalance());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            pst.setTimestamp(9, timestamp);

            int rows = pst.executeUpdate();
            System.out.println("ACCOUNT HAS BEEN GENERATED");
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void inserDataInCustomerTable(Customer customer, long account) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idbc", "root", "sid@123");
            String query = "insert into customer values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, customer.getCustomerId());
            pst.setString(2, customer.getFirstname());
            pst.setString(3, customer.getLastname());
            pst.setLong(4, customer.getPhoneno());
            pst.setString(5, customer.getPermanentAddress());
            pst.setString(6, customer.getCorrospondingAddress());
            pst.setString(7, customer.getPanNo());
            pst.setInt(8, customer.getAge());
            pst.setLong(9, account);
            int rows = pst.executeUpdate();
            System.out.println("Inserted Successfully");
            System.out.println("THANK YOU FOR SELECTING IDBI AS YOUR BANKING PARTNER");
           con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private long validateCustomerId(String customerId) {
        long accountno = 0;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idbc", "root", "sid@123");
            String query = "select accountno from customer where customerid = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, customerId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                accountno = rs.getLong("accountno");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accountno;
    }

    public boolean validateUserIdPassword(String customerId, String userid, String password) {
        long accountno = this.validateCustomerId(customerId);
        String userId1 = "";
        String password1 = "";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idbc", "root", "sid@123");
            String query = "select userid,userpassword from account where accountno = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setLong(1, accountno);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                userId1 = rs.getString("userid");
                password1 = rs.getString("userpassword");
            }
            con.close();
            if (userid.equals(userId1) && password.equals(password1)) {
               return true;
            }
            else {
               return false;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    public int checkBalance(String customerId) {
      long accountno = this.validateCustomerId(customerId);
      int balance =0;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idbc", "root", "sid@123");
            String query = "select balance from account where accountno = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setLong(1, accountno);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                balance = rs.getInt("balance");

            }

          con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
      return balance;
    }
    public void depositAmount(String customerId,int depositAmount,String detail)
    {
        int availableBalance = this.checkBalance(customerId);
        long accountno = this.validateCustomerId(customerId);
        int newbalance = (availableBalance +depositAmount);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idbc", "root", "sid@123");
            String query = "update account set balance = ? where accountno = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,newbalance );
            pst.setLong(2,accountno);
            int row  = pst.executeUpdate();
            this.addNewTransaction(customerId,accountno,TransactionType.DEPOSIT.toString(),depositAmount,detail);
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("DEPOSIT SUCCESSFUL ---> YOUR CURRENT AVAILAVLE BALANCE AMOUNT IS  -->"+" "+newbalance);

    }

    public void withdrawAmount(String customerId, int withdrawAmount,String type, String detail)
    {
        int availableBalance = this.checkBalance(customerId);
        long accountno = this.validateCustomerId(customerId);
        if(availableBalance<withdrawAmount)
        {
            System.out.println("INSUFFICIENT BALANCE AMOUNT ");
        }
        else
            {
        int newbalance = (availableBalance - withdrawAmount);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idbc", "root", "sid@123");
            String query = "update account set balance = ? where accountno = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,newbalance );
            pst.setLong(2,accountno);
            int row  = pst.executeUpdate();

             if(type.equalsIgnoreCase(TransactionType.WITHDRAW.toString())) {
                 this.addNewTransaction(customerId,accountno,TransactionType.WITHDRAW.toString(),withdrawAmount,detail);
             }
             else{
                 this.addNewTransaction(customerId,accountno,TransactionType.FUNDTRANSFER.toString(),withdrawAmount,detail);
                 }

            con.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
                System.out.println("WITHDRWAL SUCESSFUL ---> YOUR WITHDRAWL AMOUNT IS  -->"+" "+newbalance);
       }
    }
    public void addNewTransaction(String customerid,long accountno,String type,int amount,String detail){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idbc", "root", "sid@123");
            String query = "insert into transactions values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            long transactionid = generate.generateTransactionId();
            pst.setLong(1,transactionid);
            pst.setString(2,type);
            pst.setInt(3, amount);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            pst.setTimestamp(4, timestamp);
            pst.setString(5, detail);
            pst.setString(6, customerid);
            pst.setLong(7, accountno);
            int rows = pst.executeUpdate();
            con.close();
            System.out.println("Inserted Successfully");
            System.out.println("THANK YOU FOR SELECTING IDBI AS YOUR BANKING PARTNER");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void bankStatement(String customerid){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idbc", "root", "sid@123");
            String query = "select * from transactions where customerid = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,customerid );
            ResultSet rs =pst.executeQuery();

            while(rs.next())
            {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"+
                        rs.getInt(3) + "\t" + rs.getTimestamp(4) + "\t" +
                        rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getLong(7));

            }
        } catch (SQLException e){
            System.out.println("ERROR OCCURRED SORRY FOR YOUR INCONVENIENCE");
        }

    }



    public void changePassword(String password,String customerid){
       long accountno = this. validateCustomerId(customerid);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idbc", "root", "sid@123");
            String query = "update account set userpassword = ? where accountno = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,password );
            pst.setLong(2,accountno);
            int rows = pst.executeUpdate();
            con.close();
            System.out.println("PASSWORD UPDATED");

        } catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void fundTransfer1(String customerid,String detail){
        long acc = this.validateCustomerId(customerid);
        System.out.println(acc);
    }


}