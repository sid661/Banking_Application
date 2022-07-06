package idbc.project;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Generate
{
    Transaction transaction = new Transaction();
    public long accountNoGenerate()
    {
        Random random = new Random();
        long accoutNo =Math.round(random.nextFloat() * Math.pow(10,12));
        return accoutNo;
    }


    public String ifsccodeGenerate()
    {
        Random random = new Random();
        int ifsc = random.nextInt(100000);
        return ("IDBI"+ifsc);
    }

    public String customerId()
    {
        Random random = new Random();
        int id = random.nextInt(10000);
        return ("CID"+id);
    }



    public String userIdGenerate()
    {
        while(true)
    {
        System.out.println("PLEASE CREATE YOUR USER ID");
        System.out.println("YOUR USER ID SHOULD CONTAIN ._-  ONCE CHARACTER  AND CANNOT BE MORE THAN 20");
        Scanner sc = new Scanner(System.in);
        String str = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        String userId = sc.next();
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(userId);

        if (matcher.find() == true)
        {
            System.out.println("PLEASE REMEMBERB YOUR USERNAME");
            return userId;


        } else
            System.out.println("RE ENTER YOUR USER NAME");
    }

    }


    public String userPassword()
    {  while(true) {
        Scanner sc = new Scanner(System.in);
        System.out.println("PLEASE CREATE YOUR PASSWORD");
        String password1 = sc.next();
        System.out.println("PLEASE RE-ENTER YOUR PASSWORD");
        String password2 = sc.next();

        if (password1.equals(password2)) {
            System.out.println("PLEASE REMEMBER YOUR PASSWORD");
            return password1;

        } else
            System.out.println("RE-ENTER YOUR PASSWORD");
    }
    }
     public String checkRelation(){
        String relation ="";
        while(true) {
            Scanner sc = new Scanner(System.in);
            relation = sc.next();
            sc.nextLine();
            if (relation.equalsIgnoreCase("father") || relation.equalsIgnoreCase("mother") ||
                    relation.equalsIgnoreCase("wife") || relation.equalsIgnoreCase("son") ||
                    relation.equalsIgnoreCase("daughter")) {
                return relation;

            } else
                System.out.println("PLEASE CHECK YOUR INPUT");
        }
     }

     public int checkAge(){
          int age =0;
         while(true) {
             Scanner sc = new Scanner(System.in);
             age = sc.nextInt();
             sc.nextLine();
             if (age >= 18)
             {
              return age;

             } else
                 System.out.println("PLEASE CHECK YOUR AGE");

         }
     }
     public long generateTransactionId(){
        long transactionid=0;
         Random random = new Random();
         transactionid =Math.round(random.nextFloat() * Math.pow(10,6));
         return transactionid;
     }
}
