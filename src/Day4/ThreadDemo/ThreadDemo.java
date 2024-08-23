package Day4.ThreadDemo;

class Ferrari extends Thread{
    public void run(){
        for(int i=1;i<50;i++){
            System.out.println("Ferrari");
        }
    }

}
class Porsche extends Thread{
    public void run(){
        for(int i=1;i<50;i++){
            System.out.println("Porsche");
        }
    }

}

public class ThreadDemo {
    public static void main(String[] args) {
       Ferrari ferrari = new Ferrari();
       Porsche porsche = new Porsche();

       ferrari.start();
       porsche.start();
    }
}
