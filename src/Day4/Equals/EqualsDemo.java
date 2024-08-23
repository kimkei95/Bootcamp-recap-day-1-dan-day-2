package Day4.Equals;

public class EqualsDemo {
    public static void main(String[] args) {
        String a = "bootcamp";
        String b = "BOOTCAMP";
        String b1 = new String("BOOTCAMP");
        int a1 = 5;
        int a2 = 5;
        Integer c = Integer.valueOf(6);

        if(a1==a2){
            System.out.println("two int matched");
        }else {
            System.out.println("two int unmatched");
        }

//        if(a==b1){
//            System.out.println("two string matched");
//        }else {
//            System.out.println("two string unmatched");
//        }
        if(a.equals(b1)){
            System.out.println("two string matches");
        }else {
            System.out.println("two string unmatched");
        }

        String s1 =new String("Manusia");
        String s2 = new String("manusia");

//        if(s1==s2){
//            System.out.println("sama");
//        }else {
//            System.out.println("beda");
//        }
        if ((s1.toLowerCase().equals(s2))){
            System.out.println("sama");
        }else {
            System.out.println("beda");
        }
        }
    }

