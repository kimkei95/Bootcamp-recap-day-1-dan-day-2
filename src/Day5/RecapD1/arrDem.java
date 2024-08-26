package Day5.RecapD1;

import java.util.Arrays;

public class arrDem {
    public static void main(String[] args) {
        int[] numA = {1,2,3,4};
        int[] numB = new int[7];

        int [][]multiA = {
                {1,2,3,4},
                {5,6,7,8}
        };
        int[][] multiB = new int[3][3];
        System.out.println("multi: "+ multiA[1][0]+ " dan"+ multiA[0][2]);
        System.out.println("numA all ele: "+ Arrays.toString(numA));

        for(int i = 0; i< numA.length;i++){
            System.out.println(numA[i]);
        }
    }
}
