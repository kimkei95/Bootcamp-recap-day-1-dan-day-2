package Day5.Day4EqualsD;

public class EqualsDemo {
    public static void main(String[] args) {

    /// wrapper class
        //byte      Byte
        //short     Short
        // int      Integer
        // long     Long
        // float    Flat
        //double    Double
        // char     Character
        //boolean   Boolean

        Byte a = 20;
        byte b = 20;

        if (a == b) {
            System.out.println("sama");
        } else {
            System.out.println("tidak sama");
        }
        int c = 1000;
        Integer d = new Integer(c);
        System.out.println("int to Integer: "+d);
        int e = d.intValue();
        System.out.println("Reference to primitive: "+e);

        if(d==c){
            System.out.println("d dan c sama");
        }else{
            System.out.println("d dan c tidak sama");
        }

        String g = "5000";
        Integer g1 = new Integer(g);
        System.out.println("String to Integer: "+ (g1+ g1));
    }
}
