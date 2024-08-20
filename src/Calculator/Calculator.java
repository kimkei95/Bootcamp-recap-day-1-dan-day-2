package Calculator;
import static Calculator.AddValues.add;
import static Calculator.SubstractValues.substract;
public class Calculator {
    public static void main(String[] args) {
        //use imported method
        int result = add(2,4);
        System.out.println("sum = "+ result);
        //import as obj
        SubstractValues substraction = new SubstractValues();
        System.out.println(substraction.substract(10,5));

        //direct
        System.out.println("subs two int:"+ SubstractValues.substract(10,5));


        double resultTwo = substract(13.22,20.55);
        System.out.println("subs two double: "+ resultTwo);


        float resultThree = substract(1.22f,5.22f);
        System.out.println("subs two floats:" + resultThree);


        //data type casting
        // byte short char int long float double cuman bisa buat switch

        float phiVar = (float) Math.PI;
        System.out.println(phiVar);
        double squareRoot = Math.sqrt(135);
        System.out.println(squareRoot);
        double powerNumber =3;
        double powerOfTwo = Math.pow(powerNumber, 2);
        System.out.println(powerOfTwo);



        enum Grade{
            BAD,
            AVERAGE,
            EXCELLENT
        }
        Grade myGrade = Grade.EXCELLENT;
        System.out.println("my grade: "+ myGrade);
    }
}
