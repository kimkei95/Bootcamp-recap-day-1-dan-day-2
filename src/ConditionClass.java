public class ConditionClass {
    public static void main (String[]args){
        int myScore = 50;
        String myAttendance = "A";
        //Nested Switch Condition
        switch (myScore){
            case 50:
                System.out.println("D");
                switch(myAttendance){
                    case "C":
                        System.out.println("bad");
                    case "B":
                        System.out.println("average");
                    case "A":
                        System.out.println("good");
                }
                break;

            case 60:
                System.out.println("C");
                break;


            case 70:
                System.out.println("B");
                break;

            default:
                System.out.println("No score");
        }


    }
}
