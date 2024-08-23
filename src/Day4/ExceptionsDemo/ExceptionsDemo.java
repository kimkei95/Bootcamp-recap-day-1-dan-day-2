package Day4.ExceptionsDemo;

public class ExceptionsDemo {
    public static void main(String[] args) {
        int[]a = new int[3];
        try{
        System.out.println(a[3]);
        }
        catch (ArrayIndexOutOfBoundsException e){
        System.out.println(e);
        }
        try{
            setBalance(-3);
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
        System.out.println("aplikasi lanjut berjalan.....");
    }

    public static void setBalance(int balance){
        if(balance<0){
            throw new IllegalArgumentException("Balance cannot be negative"+ balance);
        }
        System.out.println("balance is set to : "+ balance);
    }
}
