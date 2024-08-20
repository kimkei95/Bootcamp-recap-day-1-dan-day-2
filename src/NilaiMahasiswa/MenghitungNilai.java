package NilaiMahasiswa;

import java.util.Arrays;

public class MenghitungNilai {
    public static void main(String[] args) {
        int [][] matrix = {
                {90,70,85},
                {80,70,65},
                {55,70,65},
                {60,90,80},
                {70,70,70}

        };
        int[] nilaiTotal= new int[5];
    for (int i=0; i< matrix.length; i++){


        int nilaiRataRata = (matrix[i][0]+matrix[0][1]+matrix[0][2])/3;
        nilaiTotal[i] = nilaiRataRata;
        System.out.println(nilaiRataRata);
        }
        System.out.println(Arrays.toString(nilaiTotal));
    }


    }

