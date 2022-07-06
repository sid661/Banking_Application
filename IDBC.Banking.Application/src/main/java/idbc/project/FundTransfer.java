package idbc.project;

import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FundTransfer
{
    Scanner sc = new Scanner(System.in);
    long beneficiaryaccount = 0;
    long beneficiaryaccount1 = 0;
    int amount =0;
    String beneficiaryBank="";
    String beneficiaryBranch="";
    String beneficiaryName="";
    String beneficiaryPhone="";
    public void sendMoney(String customerid,String type)
    {
            System.out.println(" PLEASE ENTER 12 DIGIT ACCOUNT OF BENEFICIARY ");
            beneficiaryaccount = sc.nextLong();

            System.out.println(" PLEASE RE-ENTER 12 DIGIT ACCOUNT OF BENEFICIARY ");
            beneficiaryaccount1 = sc.nextLong();
            if (beneficiaryaccount != beneficiaryaccount1) {
                System.out.println("PLEASE CHECK THE ACCOUNT NUMBER");
            }
            else if(beneficiaryaccount == beneficiaryaccount1) {
                System.out.println(" PLEASE ENTER BANK OF BENEFICIARY ");
                System.out.println("YOU CAN PROCESS FUND TRANSFER TO LISTED BANKS ");
                System.out.println("SBI"+"\n"+"HDFC"+"\n"+"KOTAK"+"\n"+"ICICI"+"\n"+"Axis");
                beneficiaryBank = sc.next();
                if((beneficiaryBank.equalsIgnoreCase("sbi"))||(beneficiaryBank.equalsIgnoreCase("hdfc"))||
                        (beneficiaryBank.equalsIgnoreCase("kotak"))||(beneficiaryBank.equalsIgnoreCase("icici"))||
                        (beneficiaryBank.equalsIgnoreCase("axis"))){
                    System.out.println("BANK ACCOUT ADDED");
                }
                else{
                    System.out.println("WE CANNOT PROVIDE FUND TRANFER TO PROVIDED BANK");
                }

                System.out.println(" PLEASE ENTER BRANCH NAME OF BENEFICIARY ");
                beneficiaryBranch = sc.next();

                System.out.println(" PLEASE ENTER FIRST NAME OF BENEFICIARY ");
                beneficiaryName = sc.next();

                System.out.println(" PLEASE ENTER PHONE NO OF BENEFICIARY ");

                    String str = "^[0-9]{10}$";
                    beneficiaryPhone = sc.next();
                    Pattern pattern = Pattern.compile(str);
                    Matcher matcher = pattern.matcher(beneficiaryPhone);

                  if(matcher.find() == true) {
                      System.out.println("PHONE NO ADDED");
                  }
                  else{
                      System.out.println("PLEASE CHECK YOUR PHONE NO ");
                  }
                    System.out.println("PLEASE ENTER THE AMOUNT" + "\n" + "CANNOT BE MORE THAN 2,00,000 RS");
                    amount = sc.nextInt();
                    if (amount < 200000) {
                        System.out.println("PROCESSING YOUR TRANSFER REQUEST");
                    }
                    else{
                        System.out.println("CANNOT PROCESS YOUR TRANSFER REQUEST");
                    }
                String details= "";
                details= beneficiaryaccount+beneficiaryBank+beneficiaryBranch+beneficiaryName+beneficiaryPhone+amount;
                    CustomerDao customerDao = new CustomerDaoImpl();
                    customerDao.withdrawAmount(customerid,amount,TransactionType.FUNDTRANSFER.toString(),details);



            }

    }

}
