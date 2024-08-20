import java.util.Arrays;
import java.util.Collections;
public class Main {
    public static void main(String[] args) {
        //tipe data integer (khusus angka)
        int age = 20;

        //tipe data string (karakter bebas seperti huruf, angka, simbol, dll)
        String name = "Danu";

        //tipe data boolean (untuk mengatur nilai kebenaran true/false)
        Boolean isStudent = true;

        //System.out.println(variabel/string) : untuk menampilkan output ke terminal atau console
        System.out.println(name);
        System.out.println(name + age); //
        System.out.println(isStudent);

        // Looping(perulangan)
        /* cara baca:
         * for(){ } : perintah(blok kode) untuk melakukan looping
         * int i = 0: variabel i sebagai nilai awal perulangan
         * i < 5 : kondisi kapan perulangan berhenti, dalam kasus ini looping akan melakukan perulangan hanya kurang dari 5
         * i++ : increment, untuk mengentikan perulangan */
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration " + i); //output iteration 0 s/d iteration 4
        }

        //logic kondisional if/else sebagai contoh dari penggnunaan tipe data Boolean
        /* cara baca: jika isStudent bernilai true, maka akan menampilkan output ke konsol nama + ia a student
         jika isStudent bernilai false maka akan menampilkan nama + is not a student ke konsol  */
        if(isStudent) {
            System.out.println(name + " is a student."); //output pertama jika isStudent bernilai true
        } else {
            System.out.println(name + " is not a student."); //output kedua jika isStudent bernilai false
        }

        // tipe data array : tipe data yang menampung banyak data sekaligus
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Array Length: " + numbers.length); // .length untuk menghitung jumlah data dalam suatu array
        numbers[4] = 7; //untuk mengganti nilai dari indeks array ke-4 menjadi 7

        // array dengan campuran data
        Object[] dataSiswa = {"danu", 25};
        String nama = "danu";
        Integer usia = 25;

        Object[] datacCampuran = {nama, usia};

        System.out.println("data siswa"+dataSiswa);
        System.out.println("array campuran"+datacCampuran);

        //sorting array ascending
        Integer sortArray[] = {2,3,1,5,4};
        Arrays.sort(sortArray);
        System.out.println("sort array : "+sortArray);
        for (int i = 0; i < sortArray.length; i++){
            System.out.println("sortedArray-"+i);
        }

        /* int[] newNumbers: membuat variabel baru untuk menampung salinan array numbers sebelumnya
         * Arrays.copyOf: method untuk menyalin sumber array dari numbers
         * newNumbers[5] = 50; menambahkan data baru ke indeks terakhir dengan nilai 50*/
        int[] newNumbers = Arrays.copyOf(numbers, numbers.length + 1);
        newNumbers[5] = 50;
        System.out.println("new numbers"+ newNumbers); //output : new numbers: [1, 2, 3, 4, 5, 50].

        /* cara baca
         * for (int i = 0; i < newNumbers.length; i++) : akan melakukan perulangan sebanyak jumlah data dari newNumbers
         *  if(newNumbers[i] == searchValue): memeriksa kondisi apakah didalam data newNumbers sama dengan search value  */
        int searchValue = 4;
        for (int i = 0; i < newNumbers.length; i++) {
            if(newNumbers[i] == searchValue){
                System.out.println("value 4 is exist"); //output jika kondisi terpenuhi
                System.out.println("current value : "+ newNumbers[i]); //output newNumbers
                break;
            }
        }
        //binarySearch: untuk mencari elemen dalam array
        System.out.println("binary search : "+ Arrays.binarySearch(numbers, searchValue)); //output : 3 (karena nilai 4 ditemukan pada indeks ke-3

        //array dua dimensi aray dalam array
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        // Accessing elements in a 2D array
        System.out.println("Element at row 1, column 2: " + matrix[0][1]);
        // Looping through a 2D array
        System.out.println("array 2 dimensi");
        for (int i = 0; i < matrix.length; i++) { //looping array pertama
            for (int j = 0; j < matrix[i].length; j++) { //looping array kedua
                matrix[i][j]++; //untuk menambahkan 1 ke setiap elemen array
                matrix[1][j]+=2; //untuk menambahkan 5 ke tiap elemen array dalam indeks ke-1 dalam array
                matrix[2][j]*=2; //untuk mengkalikan 2 ke tiap elemen array dalam indeks ke-2 dalam array
                System.out.print(+ matrix[i][j] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }

        Integer[][][] matrix3D = {
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }
        };

        // Looping untuk menampilkan data array
        System.out.println("3D array:");
        for (int i = 0; i < matrix3D.length; i++) {
            for (int j = 0; j < matrix3D[i].length; j++) {
                for (int k = 0; k < matrix3D[j].length; k++) {
                    System.out.print(matrix3D[i][j][k] + " ");
                    System.out.println(Arrays.deepToString(matrix3D)); //Array.deepToString : method untuk mengkonversi array ke string, berbeda dengan toString, deepToString akan menggali lebih dalam nilai2 yang ada dalam array
                }
            }
            System.out.println(); // Move to the next line after each row
        }

        //operator matematika
        int a = 5;
        int b = 10;
        int tambah = a + b;
        int kali = a * b;
        int kurang = b-a;
        int bagi = b/a;
        int modulus = b % a;
    }
}

//    note : perbedaan int dan Integer, int untuk data sederhana, Integer untuk data yang akan di manipulasi dengan function2 seperti arrays