package idbc.project;

public class InvalidInputException extends Exception{

    public InvalidInputException(String msg){
        super();
        System.out.println(msg);
    }
}
