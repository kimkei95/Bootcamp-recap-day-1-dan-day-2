package Day5.ScannerDemo;

import java.util.Scanner;

public class ScannerD {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Visitor visitor = new Visitor();

        System.out.println("input: ");
        String myName = scan.next();
        visitor.setVisitorName(myName);
       boolean isPhoneNumberInvalid = true;
       if (isPhoneNumberInvalid) {
           while(true) {
               System.out.println("print your phone num: ");
               String myPhoneNumberInput = scan.next();
               System.out.println(myPhoneNumberInput);



               int myPhoneNumberLength = myPhoneNumberInput.length();
               if (myPhoneNumberLength >12){
                   System.out.println("input valid phone number!!!!" +
                           "Please input the correct phone number: ");
               }
               else{
//           System.out.println("input your phone number: ");
//           String myPhoneNumberInput = scan.next();
//           visitor.setVisitorPhoneNumber(myPhoneNumberInput);

                   visitor.setVisitorPhoneNumber(myPhoneNumberInput);
                   System.out.println("input your address: ");
                   String myAddress = scan.next();
                   System.out.println("visitor adress: "+ myAddress);

                   break;
               }

           }
       }

        System.out.println("Welcome "+myName);
    }
}
