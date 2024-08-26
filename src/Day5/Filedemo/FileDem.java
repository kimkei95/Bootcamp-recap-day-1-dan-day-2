package Day5.Filedemo;

import java.io.*;
import java.util.LinkedList;

public class FileDem {
    public static void main(String[] args) {
        String line;
        LinkedList<String>line1 = new LinkedList<>();
        String filePath = "output.txt";
boolean check = new File(filePath).exists();
        System.out.println("File Exsist: "+ check);


        if (check == true) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    line1.add(line);
                }
                reader.close();
            } catch (IOException e) {
                System.out.println(e);
            }
            System.out.println("get text context: " + line1);

            for (String l1 : line1) {
                System.out.println("L1: " + l1);
            }

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                for (String l1 : line1) {
                    writer.write(l1);
                    writer.write("\n");
                }
                writer.write("\n this text has been modified");
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("file ga ada");
        }
    }
}
