package Day2.Animal;

public class MainAnimal {
    private static final String zooDestination ="ragunan";
    public class InnerClass{
        public void zooName(){
            System.out.println("kebun binatang: " + zooDestination);
        }
    }
    public static void main(String[] args) {
        Kocheng myCat = new Kocheng();
        myCat.suaraBinatang();
        myCat.animalLegs();
        myCat.sleep();

        MainAnimal mainAnimal = new MainAnimal();
        MainAnimal.InnerClass innerObj = mainAnimal.new InnerClass();
        innerObj.zooName();
    }
}
