package Calculator;

public class AddValues {
    public static int add(int num1, int num2){
        return num1+num2;
    }
    public static void main(String[] args) {
        int result = add(2,4);
        System.out.println("sum = "+ result);

        SubstractValues substraction = new SubstractValues();
        System.out.println(substraction.substract(10,5));
    }

}
