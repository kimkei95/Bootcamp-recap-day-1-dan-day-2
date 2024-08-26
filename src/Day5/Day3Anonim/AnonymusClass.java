package Day5.Day3Anonim;
interface Welcome{
    void welcoming();
}
public class AnonymusClass {
    public static void main(String[] args) {
        Welcome yourWelcome = new Welcome() {
            @Override
            public void welcoming() {
                System.out.println("hehe");
            }
        };
        yourWelcome.welcoming();
    }
}
