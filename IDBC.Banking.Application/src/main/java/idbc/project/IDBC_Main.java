package idbc.project;

import java.util.Scanner;

public class IDBC_Main {
    public static void main(String[] args) {
        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        Generate generate = new Generate();
        Account account = new Account();
        Customer customer = new Customer();
        FundTransfer fundTransfer = new FundTransfer();
        Scanner scannerimpl = new Scanner(System.in);
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-WELCOME TO IDBI BANKING APPLICATION*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        while(true)
        {
            System.out.println("PRESS .1. FOR EXISTING CUSTOMER" +"\n"+ "PRESS .2. FOR BECOMING OUR BANKING CUSTOMER"
                    +"\n"+"PRESS .3. CHANGE YOUR PASSWORD"
                    +"\n"+"PRESS .4. FOR EXIT THE IDBI BANKING APPLICATION");
            int ch=0;
            ch = scannerimpl.nextInt();
            if(ch==1) {
                System.out.println("PLEASE ENTER YOUR REGISTERED CUSTOMER ID");
                     String customerId = scannerimpl.next();
                System.out.println("PLEASE ENTER YOUR REGISTERED USER ID");
                     String userId = scannerimpl.next();
                System.out.println("PLEASE ENTER YOUR REGISTERED PASSWORD");
                     String password = scannerimpl.next();
                     //customerDao.validateCustomerId(customerId);

                    boolean flag = customerDao.validateUserIdPassword(customerId,userId,password);
                    if(flag){
                        System.out.println("LOGIN SUCCESSFUL");
                        System.out.println("WELCOME TO IDBI BANK");
                    }
                    else{
                        System.out.println("INVALID USER ID OR PASSWORD");
                        continue;
                    }

                while (true) {
                    System.out.println("PRESS .1. DEPOSIT" + "\n" + "PRESS .2. WITHDRAW"
                            + "\n" + "PRESS .3. CHECK BALANCE" + "\n" + "PRESS .4. FUND TRANSFER" + "\n" + "PRESS .5. BANK STATMENT" +
                            "\n" + "PRESS .6. EXIT");
                    int choice = scannerimpl.nextInt();
                    if (choice == 1)
                    {
                                     System.out.println("PLEASE ENTER THE AMOUNT YOU WANT TO DEPOSITE");
                                     int depositamount = scannerimpl.nextInt();
                                     if (depositamount > 0)
                                     {  String detail ="self deposit";
                                       customerDao.depositAmount(customerId, depositamount,detail);
                                     } else
                                         {
                                           System.out.println("CHECK YOUR INPUT");
                                         }
                    }
                    if (choice == 2) {
                                      String detail ="self withdrawn";
                                      System.out.println("PLEASE ENTER THE AMOUNT YOU WANT TO WITHDRAW");
                                      int withdrawamount=scannerimpl.nextInt();
                                      if(withdrawamount>0){
                                          customerDao.withdrawAmount(customerId,withdrawamount,TransactionType.WITHDRAW.toString(),detail);
                                      }else
                                          {
                                          System.out.println("PLEASE CHECK YOUR INPUT");
                                          }

                    }
                    if (choice == 3) {
                             int balance =customerDao.checkBalance(customerId);
                              System.out.println("YOUR AVAILABLE BALANCE IN ACCOUNT-:" + balance);
                    }
                    if (choice == 4)
                    {
                          customerDao.fundTransfer1(customerId,TransactionType.FUNDTRANSFER.toString());
                       // fundTransfer.sendMoney(customerId,TransactionType.FUNDTRANSFER.toString());

                    }
                    if(choice==5){
                        // BANK STATEMENT
                        customerDao.bankStatement(customerId);
                    }

                    if(choice == 6){
                        continue;
                    }
                }
            }
            else if(ch==2)
            {
                System.out.println("PRESS 1 FOR ADDING NEW CUSTOMER "+ "\n" + "PRESS 2 FOR EXIT");
                int choice = scannerimpl.nextInt();
                if(choice == 1){
                    while(true)
                    {
                       customerDao.addNewCustomer();
                        break;
                    }
                }
                else if(choice == 2){
                    continue;
                }
            }
            else if(ch==3){

                System.out.println("PLEASE ENTER YOUR CUSTOMER ID");
                String customerid= scannerimpl.next();
                System.out.println("PLEASE ENTER YOUR USER ID");
                String userid=scannerimpl.next();
                System.out.println("PLEASE ENTER YOUR NEW PASSWORD");
                String password1 = scannerimpl.next();
                System.out.println("PLEASE RE-ENTER YOUR PASSWORD");
                String password2 = scannerimpl.next();
                if (password1.equals(password2)) {
                    customerDao.changePassword(password2,customerid);
                }
                else{
                    System.out.println("CHECK YOUR PASSWORD INPUT");
                }

            }
            else if(ch==4)
            {

                System.out.println("THANK YOU FOR BANKING WITH US ");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-  IDBI   *-*-*-*-*-*-*-*-*-*-*");

            }

        }
    }
}
