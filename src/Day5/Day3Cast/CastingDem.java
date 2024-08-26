package Day5.Day3Cast;

class vehicle{

    class Car extends vehicle{

    }
    class Motorbike extends  vehicle{

    }
}
public class CastingDem {
    public static void main(String[] args) {
        //byte->short->char->int->long->float->double

        int a = 90;
        double b=a;
        short c = (short) a;
        long d = (long) b;
        float e = (float)b;


//        vehicle vhc = new vehicle();
//        vehicle mtr = (vehicle) new Motorbike();
//        vehicle car = (Motorbike) new Car();
//        vehicle carTwo = (vehicle) new Car();
//        Car carThree = (Car) new vehicle();


    }
}
