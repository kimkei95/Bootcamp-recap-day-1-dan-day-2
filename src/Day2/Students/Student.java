package Day2.Students;

import org.w3c.dom.ls.LSOutput;

public class Student {
    public static final String uName ="tadika mesra";
    public String name;
    public int score;

//    public Student(String sName, int sScore){
//        name =sName;
//        score = sScore;
//        status(score);
//    }
    public Student(String name, int score){
        this.name = name;
        this.score = score;
        status();
    }

    private void status(){
        System.out.println();
        System.out.println(name +" memiliki nilai "+ score);
        System.out.println(uName);

        if (score >70){
            System.out.println(name + " lulus");

        }else{
            System.out.println(name+ " owalah ngawor");
        }

        }
    }

