package Day2.Employee;

public class Employee {
    private String name;


    //getter

    public String getName() {
        return name;
    }

    //setter


    public void setName(String name) {
        this.name = name;
        present();
    }
    public void present(){
        System.out.println( name + " hadir");
    }
}
