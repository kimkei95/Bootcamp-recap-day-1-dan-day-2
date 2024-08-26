package Day5.RecapD1;

public class BuatObj {
    public String name;
    public int score;

    public  BuatObj(String sName, int sScore){
        this.name = sName;
        this.score = sScore;
        status();
    }

    private void status() {
        System.out.println("nama: "+ name);
        System.out.println("Score: "+ score);
    }


}
