import java.util.Collections;

public class Arrays {

    public static void main(String[] args){
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Array Length: " + numbers.length);
        numbers[0] =35;

//        System.out.println(numbers[0]);
        int [] newArray= java.util.Arrays.copyOf(numbers, numbers.length+1);
        newArray [newArray.length -1] =60;
        System.out.println("New Array:"+ newArray[5]);



//        String[] hari = {"Senin","Selasa","Rabu"};
//        System.out.println("hari le:" + hari.length);
//        System.out.println(hari[2]);
        int searchValue =4;
        for (int i = 0; i <newArray.length ; i++) {
            if (newArray[i] == searchValue){
                System.out.println("value 4 exist");
                break;
            }
        }
        //enhanced.ver
        for (int j : newArray) {
            if (j == searchValue) {
                System.out.println("value 4 exist");
                break;
            }

        }// urutin bulan (desc)
        Integer[] bulan = {1,3,6,7,2,5,4};
//        Arrays.sort(bulan); (asc)
        java.util.Arrays.sort(bulan, Collections.reverseOrder());
        System.out.println(java.util.Arrays.toString(bulan));

        //multidim array
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println("ele bar 1, kol 2= " + matrix[2][1]);

        //add element
        int [][] matrixThird = new int[3][3];
        matrixThird [0][1] =10;
        System.out.println(java.util.Arrays.deepToString(matrixThird));

        for (int i =0; i< matrixThird.length;i++){
//            matrixThird[i][0]++;
            for (int j = 0; j< matrixThird.length;j++){
//                matrixThird[i][j]++;
                matrixThird[0][j]*=2;

                System.out.println(matrixThird[i][j]+ " ");

            }
            System.out.println();
        }
    }
}
